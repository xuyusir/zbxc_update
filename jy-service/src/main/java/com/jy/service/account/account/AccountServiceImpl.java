package com.jy.service.account.account;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.ExcelUtils;
import com.jy.common.utils.RegexUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.account.authority.RoleMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.person.LivelocationMapper;
import com.jy.dao.function.person.info.PersoninfoMapper;
import com.jy.dao.function.person.resume.ResumeinfoMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.select.AreaMapper;
import com.jy.dao.system.select.EducationbackgroundMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountExample;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.function.enterprise.enterpriseFunction.Accountenterprise;
import com.jy.entiy.function.enterprise.enterpriseFunction.AccountenterpriseExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.AccountenterpriseExample.Criteria;
import com.jy.entiy.function.enterprise.info.Enterpriseinfo;
import com.jy.entiy.function.person.Livelocation;
import com.jy.entiy.function.person.LivelocationExample;
import com.jy.entiy.function.person.info.Personinfo;
import com.jy.entiy.function.person.info.PersoninfoExample;
import com.jy.entiy.function.person.resume.Resumeinfo;
import com.jy.entiy.function.person.resume.ResumeinfoExample;
import com.jy.service.account.base.BaseAccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 类名 :  AccountServiceImpl
 * 描述 : 账户服务实现类
 *
 * @author cheng fei
 * @date 2018-08-08 23:04
 */

@Service
public class AccountServiceImpl extends BaseAccountService implements AccountService {

    /**
     * 数据库操作日志类型
     */
    private static final String DB_LOG_TYPE = "DB_LOG_ACCOUNT";

    /**
     * 参数可传递的账号状态类型
     */
    private static final Integer[] STATUS_ARRAY = {0, 1};

    /**
     * 检测用户名格式正则
     */
    private static final Pattern CHECK_USERNAME_PATTERN = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{3,15}");

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private DictionariesMapper dictionariesMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private EducationbackgroundMapper educationbackgroundMapper;

    @Resource
    private PersoninfoMapper personinfoMapper;

    @Resource
    private ResumeinfoMapper resumeinfoMapper;

    @Resource
    private EnterpriseinfoMapper enterpriseinfoMapper;

    @Resource
    private AccountenterpriseMapper accountenterpriseMapper;

    @Resource
    private AreaMapper areaMapper;

    @Resource
    private LivelocationMapper livelocationMapper;

    @Resource
    FileinfoMapper fileinfoMapper;

    @Value("${WEB_APP_KEY}")
    private String WEB_APP_KEY;

    /**
     * redis
     */
    @Resource
    private JedisClient jedisClient;

    @Value("${REDIS_PASSWORD}")
    private String redisPassword;

    @Value("${SESSION_EXPIRE}")
    private Integer sessionExpire;

    @Value("${JSP_EXPIRE}")
    private Integer JSP_EXPIRE;

    @Override
    public Result insertManageAccount(AccountInfo accountInfo, String authorityCode, Account account,
                                      String confirmPassword) throws Exception {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测密码和验证密码是否一致
        if (!confirmPassword.equals(account.getPassword())) {
            Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测状态值是否正确
        if (!Arrays.asList(STATUS_ARRAY).contains(account.getStatus())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        BASE64Decoder dn = new BASE64Decoder();
        account.setPassword(new String(dn.decodeBuffer(confirmPassword), Constant.CODED_SET));

        // 补全参数
        // 设置账号类型
        account.setDictionariesid(dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE));

        //添加账号
        insertAccount(accountInfo, account);

        // 插入数据库操作日志
        String log = "添加了管理员账号[ 用户名=" + account.getUsername() + ",姓名=" + account.getName() + ",邮箱=" + account.getEmail()
                + ",电话=" + account.getPhone() + ",用户组=" + roleMapper.getNameByRoleID(account.getRoleid()) + ",审核="
                + (account.getStatus() == 0 ? "禁用" : "启用") + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result updateManageAccount(AccountInfo accountInfo, String authorityCode, Account account, String confirmPassword) throws Exception {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测参数
        // 检测两次密码是否一致
        if (!checkTwoPassWord(account.getPassword(), confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测状态值是否正确
        if (account.getStatus() != null && !Arrays.asList(STATUS_ARRAY).contains(account.getStatus())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 密码不为空,处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        if (StringUtils.isNotBlank(account.getPassword())) {
            BASE64Decoder dn = new BASE64Decoder();
            account.setPassword(new String(dn.decodeBuffer(confirmPassword), Constant.CODED_SET));
        } else {
            account.setPassword(null);
        }

        // 修稿账号
        updateAccount(accountInfo, account);


        // 插入数据库操作日志
        String log = "修改了[ " + account.getUsername() + " ]管理员账号[ ";
        log += StringUtils.isBlank(account.getUsername()) ? "" : "用户名=" + account.getUsername() + ",";
        log += StringUtils.isBlank(account.getName()) ? "" : "姓名=" + account.getName() + ",";
        log += StringUtils.isBlank(account.getEmail()) ? "" : "邮箱=" + account.getEmail() + ",";
        log += StringUtils.isBlank(account.getPhone()) ? "" : "电话=" + account.getPhone() + ",";
        log += account.getRoleid() == null ? "" : "用户组=" + roleMapper.getNameByRoleID(account.getRoleid()) + ",";
        log += account.getStatus() == null ? "" : "审核=" + (account.getStatus() == 0 ? "禁用" : "启用") + ",";
        log += log.substring(0, log.length() - 1) + "]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result deleteManageAccountAll(AccountInfo accountInfo, String authorityCode, String accountIDS)
            throws MyException {
        /*// 检测权限
         * Result checkAuthority = this.checkAuthority(accountInfo, authorityCode); if
         * (checkAuthority.getStatus() != 200) { return checkAuthority; }
         *
         * String[] account_ids_array = account_ids.split(",");
         *
         * // 循环删除 for (String id_str : account_ids_array) {
         *
         * // 检测参数 if (!StringUtils.isNumeric(id_str)) { return
         * Result.build(ResultEnum.PARAMETER_ERROR); }
         *
         * //查询账号信息 Account account =
         * accountMapper.selectByPrimaryKey(Long.parseLong(id_str));
         *
         * // 删除账号信息 int i = accountMapper.deleteByPrimaryKey(Long.parseLong(id_str));
         * if (i < 1) { throw new MyException(ResultEnum.DELETE_SQL_ERROR); }
         *
         * // 添加数据库操作日志 String log = "删除了[ " + account.getUsername() + " ]账号";
         * this.dbLog(accountInfo.getAccount().getAccountid(),
         * accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
         *
         * }
         */
        return deleteAccount(accountInfo, authorityCode, accountIDS);
    }

    @Override
    public Result getManageAccountList(AccountInfo accountInfo, boolean isDelete, String search, Integer page, Integer pageSize) {

        //检测账号类型
        if (!this.checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        search = this.checkSearch(search);
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> manageAccountList = accountMapper.getManageAccountList(isDelete, search);
        PageInfo<Map<String, Object>> info = new PageInfo<>(manageAccountList);
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put("rows", info.getList());
        map.put("count", info.getTotal());

        return Result.succee(map);
    }

    @Override
    public Result updateAccountStatus(AccountInfo accountInfo, String authorityCode, String accountIDS,
                                      Integer status) throws MyException {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测状态参数
        if (!Arrays.asList(STATUS_ARRAY).contains(status)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 拆分字符串
        String[] accountIdsArray = accountIDS.split(",");

        // 循环修改状态
        for (String accountID : accountIdsArray) {

            // 检测参数格式
            if (!StringUtils.isNumeric(accountID)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }

            // 查询账号信息
            Account oldAccount = accountMapper.selectByPrimaryKey(Long.parseLong(accountID));

            // 修改状态
            Account account = new Account();
            account.setAccountid(Long.parseLong(accountID));
            account.setStatus(status);
            updateAccount(accountInfo, account);

            // 数据库操作日志
            String log = "修改[ " + oldAccount.getUsername() + " ]账号状态为:[ " + (status == 0 ? "禁用" : "启用") + " ]";
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
        }

        return Result.succee();
    }

    @Override
    public Result exportManageAccountList(AccountInfo accountInfo, String authorityCode, String search) throws MyException {
        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        search = this.checkSearch(search);

        // 查询所有数据
        List<Map<String, Object>> enterpriseAccountList = accountMapper.getManageAccountList(false, search);
        // 组装返回数据的结构
        Map<String, List<List<String>>> map = new HashMap<>(1);

        // 设置Excel第一行的内容
        List<List<String>> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("用户名");
        list2.add("姓名");
        list2.add("邮箱");
        list2.add("电话");
        list2.add("所属用户组");
        list2.add("最后登陆时间");
        list2.add("状态");
        list.add(list2);

        // 设置Excel具体内容
        for (Map<String, Object> enterpriseAccount : enterpriseAccountList) {

            List<String> list3 = new ArrayList<>();
            list3.add(enterpriseAccount.get("UserName") == null ? "-" : enterpriseAccount.get("UserName").toString());
            list3.add(enterpriseAccount.get("Name") == null ? "-" : enterpriseAccount.get("Name").toString());
            list3.add(enterpriseAccount.get("Email") == null ? "-" : enterpriseAccount.get("Email").toString());
            list3.add(enterpriseAccount.get("Email") == null ? "-" : enterpriseAccount.get("Phone").toString());
            list3.add(enterpriseAccount.get("RoleName") == null ? "-" : enterpriseAccount.get("RoleName").toString());
            list3.add(enterpriseAccount.get("LastLoginTime") == null ? "-" : enterpriseAccount.get("LastLoginTime").toString());
            list3.add(enterpriseAccount.get("Status") == null ? "-" : ("0".equals(enterpriseAccount.get("Status").toString()) ? "禁用" : "启用"));
            list.add(list3);
        }
        map.put("中博星辰管理员账号列表", list);

        HSSFWorkbook workbook = ExcelUtils.getExcelFileStream(map);

        // 设置Excel格式

        // 设置Excel列宽度
        HSSFSheet sheet = workbook.getSheetAt(0);
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 5000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 6000);
        sheet.setColumnWidth(6, 2000);

        //  另一个字体样式   
        HSSFFont columnHeadFont = workbook.createFont();
        columnHeadFont.setFontName("宋体");
        columnHeadFont.setFontHeightInPoints((short) 14);
        columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //  列头的样式   
        HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
        columnHeadStyle.setFont(columnHeadFont);
        //  左右居中   
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //  上下居中   
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        columnHeadStyle.setLocked(true);
        columnHeadStyle.setWrapText(true);
        //  设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）   
        columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);

        HSSFRow row = sheet.getRow(0);
        row.setHeight((short) 500);

        //设置Excel列数
        int column = 6;
        for (int i = 0; i < column; i++) {
            HSSFCell cell = row.getCell(i);
            cell.setCellStyle(columnHeadStyle);
        }
        return Result.succee(workbook);
    }

    @Override
    public Result insertPersonAccount(AccountInfo accountInfo, String authorityCode, Account account,
                                      String confirmPassword) throws Exception {
        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测参数
        // 检测两次密码是否一致
        if (!confirmPassword.equals(account.getPassword())) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        BASE64Decoder dn = new BASE64Decoder();
        account.setPassword(new String(dn.decodeBuffer(confirmPassword), Constant.CODED_SET));

        // 补全参数
        // 设置账号类型
        account.setDictionariesid(dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON));
        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        account.setPage(1);
        // 账号状态: 0不可用,1可用,2删除
        account.setStatus(1);
        account.setIsmember(false);

        insertAccount(accountInfo, account);

        // 添加个人信息
        Personinfo personinfo = new Personinfo();
        personinfo.setName(account.getName());
        personinfo.setAccountid(account.getAccountid());
        insertPersonInfo(accountInfo, personinfo);

        // 添加信息到个人简历表
        Resumeinfo resumeInfo = new Resumeinfo();
        resumeInfo.setAccountid(account.getAccountid());
        resumeInfo.setResumename(account.getName());
        resumeInfo.setPhone(account.getPhone());
        resumeInfo.setEmail(account.getEmail());

        // 添加现居住地址
        Livelocation livelocation = new Livelocation();
        livelocation.setProvince(personinfo.getPostcode());
        livelocation.setCity(personinfo.getCitycode());
        livelocation.setCounty(personinfo.getCountycode());

        insertResumeInfo(accountInfo, resumeInfo, null);

        // 插入数据库操作日志
        String log = "添加了[ " + account.getName() + " ]个人用户账号:[ 手机号 =" + account.getPhone() + ",邮箱=" + account.getEmail()
                + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result registerPersonAccount(String phone, String code, String passwrod, String confirmPassword)
            throws Exception {

        return registerAccount(phone, code, passwrod, confirmPassword, Constant.ACCOUNT_TYPE_PERSON);
    }

    @Override
    public Result insertPersonData(AccountInfo accountInfo, Personinfo personinfo) throws MyException {

        //检测参数
        if (!StringUtils.isNumeric(personinfo.getBirthyear()) || !StringUtils.isNumeric(personinfo.getBirthmonth())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 修改账号
        Account account = accountInfo.getAccount();
        account.setName(personinfo.getName());
        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        if (accountInfo.getAccount().getEmail() != null) {
            account.setPage(3);
        } else {
            account.setPage(2);
        }
        if (StringUtils.isBlank(account.getCreateby())) {
            account.setCreateby(personinfo.getName());
        }
        if (account.getCreatepersonid() == null) {
            account.setCreatepersonid(account.getAccountid());
        }
        updateAccount(accountInfo, account);

        // 检测是否有个人信息
        PersoninfoExample example = new PersoninfoExample();
        com.jy.entiy.function.person.info.PersoninfoExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
        List<Personinfo> list = personinfoMapper.selectByExample(example);
        Date date = new Date();

        personinfo.setAccountid(account.getAccountid());
        if (list == null || list.size() == 0) {
            insertPersonInfo(accountInfo, personinfo);
        } else {
            personinfo.setId(list.get(0).getId());
            if (StringUtils.isBlank(personinfo.getCreateby())) {
                personinfo.setCreateby(personinfo.getName());
            }
            updatePersonInfo(accountInfo, personinfo);
        }

        //添加简历
        Resumeinfo resumeinfo = new Resumeinfo();
        resumeinfo.setAccountid(accountInfo.getAccount().getAccountid());
        resumeinfo.setResumename(personinfo.getName());
        resumeinfo.setSex(personinfo.getSex());
        resumeinfo.setPhone(accountInfo.getAccount().getPhone());
        resumeinfo.setUniversity(personinfo.getUniversity());
        resumeinfo.setSpecialty(personinfo.getSpecialty());
        resumeinfo.setGrade(personinfo.getGrade());
        resumeinfo.setYear(Integer.parseInt(personinfo.getBirthyear()));
        resumeinfo.setMonth(Integer.parseInt(personinfo.getBirthmonth()));

        // 添加现居住地址
        Livelocation livelocation = new Livelocation();
        livelocation.setProvince(personinfo.getProvincecode());
        livelocation.setCity(personinfo.getCitycode());
        livelocation.setCounty(personinfo.getCountycode());

        // 查询是否存在简历
        ResumeinfoExample resumeInfoExample = new ResumeinfoExample();
        com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria resumeInfoExampleCriteria = resumeInfoExample.createCriteria();
        resumeInfoExampleCriteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
        List list2 = resumeinfoMapper.selectByExample(resumeInfoExample);
        // 不存在简历
        if (list2 == null || list2.size() == 0) {
            // 插入数据到简历数据
            insertResumeInfo(accountInfo, resumeinfo, livelocation);
        } else {
            Resumeinfo oldResumeInfo = (Resumeinfo) list2.get(0);
            resumeinfo.setResumeid(oldResumeInfo.getResumeid());
            updateResumeInfo(accountInfo, resumeinfo, livelocation);
        }

        // 插入数据库操作日志
        String oldName = StringUtils.isBlank(accountInfo.getAccount().getName()) ? personinfo.getName() : accountInfo.getAccount().getName();
        String log = "[ " + oldName + " ]更新了账号详细资料[ ";
        log += StringUtils.isBlank(personinfo.getName()) ? "" : "姓名=" + personinfo.getName() + ",";
        log += StringUtils.isBlank(personinfo.getSex()) ? "" : "性别=" + personinfo.getSex() + ",";
        log += StringUtils.isBlank(personinfo.getBirthyear()) ? "" : "出生年=" + personinfo.getBirthyear() + ",";
        log += StringUtils.isBlank(personinfo.getBirthmonth()) ? "" : "出生月=" + personinfo.getBirthmonth() + ",";
        log += personinfo.getEducationid() == null ? "" : "学历证书=" + educationbackgroundMapper.getEducationLevelByEducationID(personinfo.getEducationid()) + ",";
        log += StringUtils.isBlank(personinfo.getGrade()) ? "" : "年级=" + personinfo.getGrade() + ",";
        log += StringUtils.isBlank(personinfo.getSpecialty()) ? "" : "专业=" + personinfo.getBirthyear() + ",";
        log += StringUtils.isBlank(personinfo.getProvincecode()) ? "" : "所在省=" + areaMapper.getNameByCode(personinfo.getProvincecode()) + ",";
        log += StringUtils.isBlank(personinfo.getCitycode()) ? "" : "所在市=" + areaMapper.getNameByCode(personinfo.getCitycode()) + ",";
        log += StringUtils.isBlank(personinfo.getCountycode()) ? "" : "所在县=" + areaMapper.getNameByCode(personinfo.getCountycode()) + ",";
        log = log.substring(0, log.length() - 1) + " ]";

        this.dbLog(accountInfo.getAccount().getAccountid(), oldName, log, DB_LOG_TYPE);

        //修改session中的信息
        updateToken(accountInfo);

        return Result.succee(accountInfo);
    }


    @Override
    public Result getPersonInfo(AccountInfo accountInfo) {
        PersoninfoExample example = new PersoninfoExample();
        com.jy.entiy.function.person.info.PersoninfoExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
        List<Personinfo> list = personinfoMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return Result.succee();
        } else {
            return Result.succee(list.get(0));
        }
    }

    @Override
    public Result updatePersonAccount(AccountInfo accountInfo, String authorityCode, Account account, String confirmPassword) throws Exception {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测参数
        // 检测两次密码是否一致
        if (!checkTwoPassWord(account.getPassword(), confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 密码不为空,处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        if (StringUtils.isNotBlank(account.getPassword())) {
            BASE64Decoder dn = new BASE64Decoder();
            account.setPassword(new String(dn.decodeBuffer(confirmPassword), "UTF-8"));
        } else {
            account.setPassword(null);
        }

        // 查询账号历史信息
        Account oldAccount = accountMapper.selectByPrimaryKey(account.getAccountid());
        updateAccount(accountInfo, account);

        // 判断是否修改姓名,修改姓名,同步修改个人详细信息,简历表姓名
        if (StringUtils.isNotBlank(account.getName()) && !account.getName().equals(oldAccount.getName())) {

            // 修改个人资料
            Personinfo personinfo = new Personinfo();
            personinfo.setAccountid(account.getAccountid());
            personinfo.setName(account.getName());
            updatePersonInfo(accountInfo, personinfo);

            // 修改个人简历表
            Resumeinfo resumeinfo = new Resumeinfo();
            resumeinfo.setAccountid(account.getAccountid());
            resumeinfo.setResumename(account.getName());
            updateResumeInfo(accountInfo, resumeinfo, null);
        }

        // 插入数据库操作日志
        String log = "修改了[ " + oldAccount.getName() + " ]个人账号:[ ";
        log += StringUtils.isBlank(account.getName()) ? "" : "姓名=" + account.getName() + ",";
        log += StringUtils.isBlank(account.getPhone()) ? "" : "电话=" + account.getPhone() + ",";
        log += StringUtils.isBlank(account.getEmail()) ? "" : "邮箱=" + account.getEmail() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result deletePersonAccountAll(AccountInfo accountInfo, String authorityCode, String accountIDS)
            throws MyException {
        return deleteAccount(accountInfo, authorityCode, accountIDS);
    }

    @Override
    public Result getPersonAccountList(AccountInfo accountInfo, boolean isDelete, Integer accountType, String search, Integer page, Integer pageSize) {

        //检测账号类型
        if (!this.checkManageAccount(accountInfo.getAccount())){
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //个人账号类型:0全部,1会员,2非会员
        Integer[] accountTypeArray = {0, 1, 2};

        // 检测参数
        if (!Arrays.asList(accountTypeArray).contains(accountType)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        Integer isMember;
        if (accountType == 0) {
            isMember = null;
        } else if (accountType == 1) {
            isMember = 1;
        } else if (accountType == 2) {
            isMember = 0;
        } else {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        search = this.checkSearch(search);
        // 分页
        PageHelper.startPage(page, pageSize);
        // 查询
        List<Map<String, Object>> personAccountList = accountMapper.getPersonAccountList(isDelete, search, isMember);
        PageInfo<Map<String, Object>> info = new PageInfo<>(personAccountList);

        // 返回
        Map<String, Object> map = new HashMap<>(2);
        map.put("rows", info.getList());
        map.put("count", info.getTotal());

        return Result.succee(map);
    }

    @Override
    public Result exportPersonAccountList(AccountInfo accountInfo, String authorityCode, Integer accountType, String search) throws MyException {

        Integer[] accountTypeArray = {0, 1, 2};

        // 检测参数
        if (!Arrays.asList(accountTypeArray).contains(accountType)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        Integer isMember;
        if (accountType == 0) {
            isMember = null;
        } else if (accountType == 1) {
            isMember = 1;
        } else if (accountType == 2) {
            isMember = 0;
        } else {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        search = this.checkSearch(search);

        // 查询所有数据
        List<Map<String, Object>> manageAccountList = accountMapper.getPersonAccountList(false, search, isMember);
        // 组装返回数据的结构
        Map<String, List<List<String>>> map = new HashMap<>(1);

        // 设置Excel第一行的内容
        List<List<String>> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("姓名");
        list2.add("联系电话");
        list2.add("联系邮箱");
        list2.add("类型");
        list2.add("最后登陆时间");
        list.add(list2);

        // 设置Excel具体内容
        for (Map<String, Object> enterpriseAccount : manageAccountList) {

            List<String> list3 = new ArrayList<>();
            list3.add(enterpriseAccount.get("Name") == null ? "" : enterpriseAccount.get("Name").toString());
            list3.add(enterpriseAccount.get("Phone") == null ? "" : enterpriseAccount.get("Phone").toString());
            list3.add(enterpriseAccount.get("Email") == null ? "" : enterpriseAccount.get("Email").toString());
            list3.add(enterpriseAccount.get("IsMember") == null ? ""
                    : ((boolean) enterpriseAccount.get("IsMember") ? "会员" : "非会员"));
            list3.add(enterpriseAccount.get("LastLoginTime") == null ? ""
                    : enterpriseAccount.get("LastLoginTime").toString());
            list.add(list3);
        }
        map.put("中博星辰企业账号列表", list);

        HSSFWorkbook workbook = ExcelUtils.getExcelFileStream(map);

        // 设置Excel格式

        // 设置Excel列宽度
        HSSFSheet sheet = workbook.getSheetAt(0);
        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 6000);

        //  另一个字体样式   
        HSSFFont columnHeadFont = workbook.createFont();
        columnHeadFont.setFontName("宋体");
        columnHeadFont.setFontHeightInPoints((short) 14);
        columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //  列头的样式   
        HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
        columnHeadStyle.setFont(columnHeadFont);
        //  左右居中   
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //  上下居中   
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        columnHeadStyle.setLocked(true);
        columnHeadStyle.setWrapText(true);
        //  设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）   
        columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);

        HSSFRow row = sheet.getRow(0);
        row.setHeight((short) 500);
        int column = 5;
        for (int i = 0; i < column; i++) {
            HSSFCell cell = row.getCell(i);
            cell.setCellStyle(columnHeadStyle);
        }

        return Result.succee(workbook);
    }

    @Override
    public Result insertEnterpriseAccount(AccountInfo accountInfo, String authorityCode, Account account, Enterpriseinfo enterpriseinfo, String confirmPassword) throws Exception {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测参数
        // 检测两次密码是否一致
        if (!confirmPassword.equals(account.getPassword())) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        BASE64Decoder dn = new BASE64Decoder();
        account.setPassword(new String(dn.decodeBuffer(confirmPassword), "UTF-8"));

        // 补全参数
        // 设置账号类型
        account.setDictionariesid(dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE));
        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        account.setPage(1);
        // 账号状态: 0不可用,1可用,2删除
        account.setStatus(1);

        // 添加账号
        insertAccount(accountInfo, account);

        // 添加企业信息
        inertEnterpriseInfo(accountInfo, enterpriseinfo, account);

        // 插入数据库操作日志
        String log = "添加了[ " + enterpriseinfo.getEnterprisename() + " ]账号:[ 联系人=" + account.getName() + ",电话="
                + account.getPhone() + ",邮箱=" + account.getEmail() + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result registerEnterpriseAccount(String phone, String code, String password, String confirmPassword)
            throws Exception {
        return registerAccount(phone, code, password, confirmPassword, Constant.ACCOUNT_TYPE_ENTERPRISE);
    }

    @Override
    public Result insertEnterpriseInfo(AccountInfo accountInfo, Enterpriseinfo enterpriseinfo) throws MyException {

        //检测参数,验证公司官网正则
        if (!RegexUtils.checkURL(enterpriseinfo.getEnterpriseurl())) {
            return Result.build(ResultEnum.URL_FORMAT_ERROR);
        }

        // 修改账号信息
        Account account = new Account();
        account.setAccountid(accountInfo.getAccount().getAccountid());
        account.setName(enterpriseinfo.getContactorname());
        accountInfo.getAccount().setName(enterpriseinfo.getContactorname());

        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        if (accountInfo.getAccount().getPage() != 3) {
            if (accountInfo.getAccount().getEmail() != null) {
                account.setPage(3);
            } else {
                account.setPage(2);
            }
        }
        if (StringUtils.isBlank(accountInfo.getAccount().getCreateby())) {
            account.setCreateby(account.getName());
        }
        if (accountInfo.getAccount().getCreatepersonid() == null) {
            account.setCreatepersonid(account.getAccountid());
        }
        updateAccount(accountInfo, account);

        // 查询账号和企业信息关联关系
        AccountenterpriseExample example = new AccountenterpriseExample();
        Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
        List<Accountenterprise> list = accountenterpriseMapper.selectByExample(example);

        Enterpriseinfo oldEnterpriseInfo = null;
        if (list == null || list.size() == 0) {
            // 账号没有绑定企业信息

            // 插入企业信息表
            inertEnterpriseInfo(accountInfo, enterpriseinfo, account);
            oldEnterpriseInfo = enterpriseinfo;
        } else {
            // 账号绑定有企业信息

            Accountenterprise accountenterprise = list.get(0);
            enterpriseinfo.setEnterpriseid(accountenterprise.getEnterpriseid());

            // 补全信息
            if (StringUtils.isBlank(enterpriseinfo.getCreateby())) {
                enterpriseinfo.setCreateby(enterpriseinfo.getContactorname());
            }
            oldEnterpriseInfo = enterpriseinfoMapper.selectByPrimaryKey(enterpriseinfo.getEnterpriseid());
            updateEnterpriseInfo(accountInfo, enterpriseinfo);
        }

        // 上传了公司logo,添加文件应用
        if (enterpriseinfo.getLogofileid() != null) {
            this.addUseFile(enterpriseinfo.getLogofileid(), "EnterpriseInfo", (long) enterpriseinfo.getEnterpriseid());
        }

        // 数据库操作日志
        String enterpriseName = StringUtils.isBlank(oldEnterpriseInfo.getEnterprisename()) ? enterpriseinfo.getEnterprisename() : oldEnterpriseInfo.getEnterprisename();
        String log = "[ " + enterpriseName + " ]企业更新了企业信息[ ";
        log += StringUtils.isBlank(enterpriseinfo.getContactorname()) ? "" : "联系人=" + enterpriseinfo.getContactorname() + ",";
        log += StringUtils.isBlank(enterpriseinfo.getEnterprisename()) ? "" : "公司名称=" + enterpriseinfo.getEnterprisename() + ",";
        log += StringUtils.isBlank(enterpriseinfo.getIntroduction()) ? "" : "公司简介=" + enterpriseinfo.getIntroduction() + ",";
        log += StringUtils.isBlank(enterpriseinfo.getEnterpriseurl()) ? "" : "公司官网=" + enterpriseinfo.getEnterpriseurl() + ",";
        log += enterpriseinfo.getLogofileid() != null ? "" : "公司logo=" + fileinfoMapper.getFileNameByFileID(enterpriseinfo.getLogofileid()) + ",";
        log = log.substring(0, log.length() - 1) + " ]";

        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        //更新session中的用户信息
        this.updateToken(accountInfo);

        return Result.succee();
    }

    @Override
    public Result getEnterpriseInfo(Integer enterpriseID, Long accountID) {

        if (enterpriseID == null && accountID == null) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        Map<String, Object> data = null;
        if (enterpriseID != null && accountID == null) {
            AccountenterpriseExample example = new AccountenterpriseExample();
            Criteria criteria = example.createCriteria();
            criteria.andEnterpriseidEqualTo(enterpriseID);
            List<Accountenterprise> list = accountenterpriseMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                return Result.succee();
            }
            data = accountMapper.getEnterpriseAccount(list.get(0).getAccountid());
        } else {
            data = accountMapper.getEnterpriseAccount(accountID);
        }
        if (data.get("file_path") != null && StringUtils.isNotBlank(data.get("file_path").toString())) {
            data.put("file_path", aliyunOSSClientUtil.getUrl(data.get("file_path").toString()));
        }
        aliyunOSSClientUtil.closeOSSClient();
        return Result.succee(data);
    }

    @Override
    public Result updaletEnterpriseAccount(AccountInfo accountInfo, String authorityCode, Account account, Enterpriseinfo enterpriseinfo, String confirmPassword) throws Exception {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        // 检测参数
        // 检测两次密码是否一致
        if (!checkTwoPassWord(account.getPassword(), confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 检测参数格式,唯一性
        Result checkAccount = checkAccount(account);
        if (checkAccount.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAccount;
        }

        // 密码不为空,处理密码加密,
        // 密码加密方式:1.MD5加密,然后base64加密,数据库储存MD5加密后的结果
        if (StringUtils.isNotBlank(account.getPassword())) {
            BASE64Decoder dn = new BASE64Decoder();
            account.setPassword(new String(dn.decodeBuffer(confirmPassword), "UTF-8"));
        } else {
            account.setPassword(null);
        }

        // 补全参数
        account.setUpdateby(accountInfo.getAccount().getName());
        account.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        account.setUpdatetime(new Date());

        // 修改账号
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        // 设置企业ID
        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(account.getAccountid());
        enterpriseinfo.setEnterpriseid(enterpriseID);

        // 查询企业信息
        Enterpriseinfo oldEnterpriseInfo = enterpriseinfoMapper.selectByPrimaryKey(enterpriseID);
        // 修改企业信息
        i = enterpriseinfoMapper.updateByPrimaryKeySelective(enterpriseinfo);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        // 插入数据库操作日志
        String log = "修改了[ " + oldEnterpriseInfo.getEnterprisename() + " ]账号:[ ";
        log += StringUtils.isBlank(enterpriseinfo.getEnterprisename()) ? ""
                : "企业名称=" + enterpriseinfo.getEnterprisename() + ",";
        log += StringUtils.isBlank(account.getName()) ? "" : "联系人=" + account.getName() + ",";
        log += StringUtils.isBlank(account.getPhone()) ? "" : "电话=" + account.getPhone() + ",";
        log += StringUtils.isBlank(account.getEmail()) ? "" : "邮箱=" + account.getEmail() + ",";
        log = log.substring(0, log.length() - 1) + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result deleteEnterpriseAccountAll(AccountInfo accountInfo, String authorityCode, String accountIDS)
            throws MyException {

        // 检测权限
        /*
         * Result checkAuthority = this.checkAuthority(accountInfo, authorityCode); if
         * (checkAuthority.getStatus() != 200) { return checkAuthority; }
         *
         * String[] account_ids_array = account_ids.split(",");
         *
         * // 循环删除 for (String id_str : account_ids_array) {
         *
         * // 检测参数 if (!StringUtils.isNumeric(id_str)) { return
         * Result.build(ResultEnum.PARAMETER_ERROR); }
         *
         * // 查询账号和企业的关联关系 AccountenterpriseExample example = new
         * AccountenterpriseExample(); Criteria criteria = example.createCriteria();
         * criteria.andAccountidEqualTo(Long.parseLong(id_str)); Accountenterprise
         * accountenterprise = accountenterpriseMapper.selectByExample(example).get(0);
         *
         * // 查询企业信息 Enterpriseinfo enterpriseinfo =
         * enterpriseinfoMapper.selectByPrimaryKey(accountenterprise.getEnterpriseid());
         *
         * // 删除企业信息 int i =
         * enterpriseinfoMapper.deleteByPrimaryKey(accountenterprise.getEnterpriseid());
         * if (i < 1) { throw new MyException(ResultEnum.DELETE_SQL_ERROR); }
         *
         * //删除企业logo文件 if (enterpriseinfo.getLogofileid() != null) {
         * deleteFile(accountInfo, DB_LOG_TYPE, enterpriseinfo.getLogofileid(),
         * "EnterpriseInfo", (long)enterpriseinfo.getEnterpriseid()); }
         *
         * // 删除账号信息 i = accountMapper.deleteByPrimaryKey(Long.parseLong(id_str)); if (i
         * < 1) { throw new MyException(ResultEnum.DELETE_SQL_ERROR); }
         *
         * // 删除账号企业关联关系 i =
         * accountenterpriseMapper.deleteByPrimaryKey(accountenterprise.
         * getAccountenterpriseid()); if (i < 1) { throw new
         * MyException(ResultEnum.DELETE_SQL_ERROR); }
         *
         * // 添加数据库操作日志 String log = "删除了[ " + enterpriseinfo.getEnterprisename() +
         * " ]账号"; this.dbLog(accountInfo.getAccount().getAccountid(),
         * accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
         *
         * }
         */
        return deleteAccount(accountInfo, authorityCode, accountIDS);
    }

    @Override
    public Result getEnterpriseAccountList(boolean isDelete, String search, Integer page, Integer pageSize) {

        search = this.checkSearch(search);
        PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> data = accountMapper.getEnterpriseAccountList(isDelete, search);
        PageInfo<Map<String, Object>> info = new PageInfo<>(data);
        List<Map<String, Object>> list = info.getList();
        long total = info.getTotal();
        Map<String, Object> map = new HashMap<>(2);
        map.put("rows", list);
        map.put("count", total);
        return Result.succee(map);
    }

    @Override
    public Result exportEnterpriseAccountList(boolean isDelete, AccountInfo accountInfo, String authorityCode, String search) throws MyException {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        search = this.checkSearch(search);

        // 查询所有数据
        List<Map<String, Object>> enterpriseAccountList = accountMapper.getEnterpriseAccountList(isDelete, search);
        // 组装返回数据的结构
        Map<String, List<List<String>>> map = new HashMap<>(1);

        // 设置Excel第一行的内容
        List<List<String>> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("企业名称");
        list2.add("联系人");
        list2.add("联系电话");
        list2.add("邮箱");
        list2.add("最后登陆时间");
        list.add(list2);

        // 设置Excel具体内容
        for (Map<String, Object> enterpriseAccount : enterpriseAccountList) {

            List<String> list3 = new ArrayList<>();
            list3.add(enterpriseAccount.get("EnterpriseName") == null ? ""
                    : enterpriseAccount.get("EnterpriseName").toString());
            list3.add(enterpriseAccount.get("Name") == null ? "" : enterpriseAccount.get("Name").toString());
            list3.add(enterpriseAccount.get("Phone") == null ? "" : enterpriseAccount.get("Phone").toString());
            list3.add(enterpriseAccount.get("Email") == null ? "" : enterpriseAccount.get("Email").toString());
            list3.add(enterpriseAccount.get("LastLoginTime") == null ? ""
                    : enterpriseAccount.get("LastLoginTime").toString());
            list.add(list3);
        }
        map.put("中博星辰企业账号列表", list);

        HSSFWorkbook workbook = ExcelUtils.getExcelFileStream(map);

        //设置Excel列宽度
        HSSFSheet sheet = workbook.getSheetAt(0);
        sheet.setColumnWidth(0, 10000);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);

        //另一个字体样式   
        HSSFFont columnHeadFont = workbook.createFont();
        columnHeadFont.setFontName("宋体");
        columnHeadFont.setFontHeightInPoints((short) 14);
        columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //列头的样式   
        HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
        columnHeadStyle.setFont(columnHeadFont);
        //左右居中   
        columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //上下居中   
        columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        columnHeadStyle.setLocked(true);
        columnHeadStyle.setWrapText(true);
        //设置单元格的背景颜色（单元格的样式会覆盖列或行的样式）   
        columnHeadStyle.setFillForegroundColor(HSSFColor.WHITE.index);

        HSSFRow row = sheet.getRow(0);
        row.setHeight((short) 500);
        int column = 5;
        for (int i = 0; i < column; i++) {
            HSSFCell cell = row.getCell(i);
            cell.setCellStyle(columnHeadStyle);
        }

        return Result.succee(workbook);
    }

    @Override
    public Result checkUserName(Long id, String username) {
        if (!CHECK_USERNAME_PATTERN.matcher(username).matches()) {
            return Result.build(ResultEnum.ACCOUNT_USER_FORMAT_ERROR);
        }
        if (id == null || id == 0) {
            id = null;
        }
        Integer count = accountMapper.getAccountCountByUserName(id, username);
        return Result.succee(count == 0);
    }

    @Override
    public Result checkPhone(Long id, String phone) {
        if (!RegexUtils.checkMobile(phone) && !RegexUtils.checkPhone(phone)) {
            return Result.build(ResultEnum.PHONE_ERROR);
        }
        if (id == null || id == 0) {
            id = null;
        }
        Integer count = accountMapper.getAccountCountByPhone(id, phone);
        return Result.succee(count == 0);
    }

    @Override
    public Result checkEmail(Long id, String email) {
        if (!RegexUtils.checkEmail(email)) {
            return Result.build(ResultEnum.EMAIL_ERROR);
        }
        if (id == null || id == 0) {
            id = null;
        }
        Integer count = accountMapper.getAccountCountByEmail(id, email);
        return Result.succee(count == 0);
    }

    /**
     * 检测账号的账号名,电话,邮箱是否重复
     *
     * @param account 检测的账号
     * @return
     */
    private Result checkAccount(Account account) {

        // 电话不为空,检测电话号码格式,可以是固定电话或者是手机号
        if (StringUtils.isNotBlank(account.getPhone()) && !RegexUtils.checkPhone(account.getPhone()) && !RegexUtils.checkMobile(account.getPhone())) {
            return Result.build(ResultEnum.PHONE_ERROR);
        }

        // 邮箱不为空,检测邮箱格式
        if (StringUtils.isNotBlank(account.getEmail()) && !RegexUtils.checkEmail(account.getEmail())) {
            return Result.build(ResultEnum.EMAIL_ERROR);
        }

        // 检测用户名
        if (StringUtils.isNotBlank(account.getUsername())) {
            Result checkUserName = checkUserName(account.getAccountid(), account.getUsername());
            if (checkUserName.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
                return checkUserName;
            }
            if (!(boolean) checkUserName.getData()) {
                return Result.build(ResultEnum.ACCOUNT_USERNAME_EXIST);
            }
        }

        // 检测电话号码
        if (StringUtils.isNotBlank(account.getPhone())) {
            Result checkPhone = checkPhone(account.getAccountid(), account.getPhone());
            if (checkPhone.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
                return checkPhone;
            }
            if (!(boolean) checkPhone.getData()) {
                return Result.build(ResultEnum.PHONE_EXIST);
            }
        }

        // 检测邮箱
        if (StringUtils.isNotBlank(account.getEmail())) {
            Result checkEmail = checkEmail(account.getAccountid(), account.getEmail());
            if (checkEmail.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
                return checkEmail;
            }
            if (!(boolean) checkEmail.getData()) {
                return Result.build(ResultEnum.EMAIL_EXIST);
            }
        }

        return Result.succee();
    }

    @Override
    public Result updatePassWord(AccountInfo accountInfo, String oldPassword, String password, String confirmPassword)
            throws Exception {

        // 验证参数
        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(password)
                || StringUtils.isBlank(confirmPassword)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 验证密码和确认密码是否一致
        if (!password.equals(confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 验证旧密码是否和新密码一致,一致直接返回修改成功
        if (oldPassword.equals(password)) {
            return Result.succee();
        }

        // 解码
        BASE64Decoder dn = new BASE64Decoder();
        oldPassword = new String(dn.decodeBuffer(oldPassword), Constant.CODED_SET);
        password = new String(dn.decodeBuffer(password), Constant.CODED_SET);

        // 验证旧密码是否正确
        Account account = accountMapper.selectByPrimaryKey(accountInfo.getAccount().getAccountid());
        if (!account.getPassword().equals(oldPassword)) {
            return Result.build(ResultEnum.PASSWORD_ERROR);
        }

        // 修改密码
        Account account2 = new Account();
        account2.setAccountid(account.getAccountid());
        account2.setPassword(password);
        account.setUpdateby(accountInfo.getAccount().getName());
        account.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        account.setUpdatetime(new Date());

        // 修改密码
        int i = accountMapper.updateByPrimaryKeySelective(account2);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        this.dbLog(account.getAccountid(), account.getName(), "账号[ " + account.getUsername() + " ]修改了密码", DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result updateEmail(AccountInfo accountInfo, String emailToken) throws MyException {

        Account account = accountInfo.getAccount();
        String serverToken = jedisClient.get(Constant.JSP_PRE + account.getAccountid(), redisPassword);

        if (StringUtils.isBlank(serverToken) || StringUtils.isBlank(emailToken) || !emailToken.equals(serverToken)) {
            return Result.build(ResultEnum.JSP_ERROR);
        }

        account.setEmail(jedisClient.get(Constant.EMAIL_PRE + account.getAccountid(), redisPassword));
        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        account.setPage(3);
        //修改账号
        updateAccount(accountInfo, account);

        Integer enterpriseTypeID = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE);
        Integer personTypeID = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON);

        String log = "";
        if (enterpriseTypeID.intValue() == account.getDictionariesid()) {

            // 企业账号修改企业信息表中的邮箱
            AccountenterpriseExample example = new AccountenterpriseExample();
            Criteria criteria = example.createCriteria();
            criteria.andAccountidEqualTo(account.getAccountid());
            Accountenterprise accountenterprise = accountenterpriseMapper.selectByExample(example).get(0);
            Enterpriseinfo enterpriseinfo = new Enterpriseinfo();
            enterpriseinfo.setEnterpriseid(accountenterprise.getEnterpriseid());
            enterpriseinfo.setContactoremail(account.getEmail());

            //修改企业账号
            updateEnterpriseInfo(accountInfo, enterpriseinfo);
            log = "[ " + enterpriseinfoMapper.getEnterpriseNameByAccountID(account.getAccountid()) + " ]企业绑定了邮箱[ " + account.getEmail() + " ]";
        } else if (personTypeID.intValue() == account.getDictionariesid()) {

            // 个人用户修改简历表信息
            Resumeinfo resumeinfo = new Resumeinfo();
            resumeinfo.setAccountid(account.getAccountid());
            resumeinfo.setEmail(account.getEmail());
            updateResumeInfo(accountInfo, resumeinfo, null);
            log = "[ " + account.getName() + " ]绑定了邮箱[ " + account.getEmail() + " ]";

        }
        // 插入数据库操作日志
        this.dbLog(account.getAccountid(), account.getName(), log, DB_LOG_TYPE);

        //更新session信息
        this.updateToken(accountInfo);

        return Result.succee(accountInfo);
    }

    @Override
    public Result resetPasswordByPhone(String phone, String code, String password, String confirmPassword) throws Exception {

        // 验证密码是否与确认密码一致
        if (!password.equals(confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 验证验证码
        String serverCode = jedisClient.get(Constant.PHONE_CODE_PRE + phone, redisPassword);
        if (!code.equals(serverCode)) {
            return Result.build(ResultEnum.PHONE_CODE_ERROR);
        }

        //手机号是否注册
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        int count = accountMapper.countByExample(example);
        if (count < 1) {
            return Result.build(ResultEnum.PHONE_NOT_EXIST_ERROR);
        }

        //查询账号信息
        Account oldAccount = accountMapper.selectByExample(example).get(0);

        // 解码密码
        BASE64Decoder dn = new BASE64Decoder();
        password = new String(dn.decodeBuffer(password), Constant.CODED_SET);

        // 重置密码
        Account account = new Account();
        account.setAccountid(oldAccount.getAccountid());
        account.setPassword(password);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(account);

        updateAccount(accountInfo, account);

        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), "用户[ " + accountInfo.getAccount().getName() + " ]重置了密码", DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result resetPasswordByEmail(String email, String code, String password, String confirmPassword) throws Exception {

        // 验证密码是否与确认密码一致
        if (!password.equals(confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        //验证验证码
        String serverCode = jedisClient.get(Constant.RESET_PASSWORD_PRE + email, redisPassword);
        if (StringUtils.isBlank(serverCode) || !code.equals(serverCode)) {
            return Result.build(ResultEnum.EMIAL_CODE_ERROR);
        }

        //查询账号
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        Account old_account = accountMapper.selectByExample(example).get(0);

        // 解码密码
        BASE64Decoder dn = new BASE64Decoder();
        password = new String(dn.decodeBuffer(password), Constant.CODED_SET);

        // 重置密码
        Account account = new Account();
        account.setAccountid(old_account.getAccountid());
        account.setPassword(password);
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(old_account);
        updateAccount(accountInfo, account);

        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), "用户[ " + accountInfo.getAccount().getName() + " ]重置了密码", DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result getAccount(AccountInfo accountInfo, Long accountID) {
        //检测是否是管理员账号
        if (!checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }
        Account account = accountMapper.selectByPrimaryKey(accountID);
        // 处理密码
        account.setPassword(null);
        return Result.succee(account);
    }

    @Override
    public Result updatePersonInfo(AccountInfo accountInfo, String name, String sex) throws MyException {

        //创建要修改的实体类
        Resumeinfo resumeinfo = new Resumeinfo();

        //是否修改了数据库
        boolean flag = false;

        if (name.equals(accountInfo.getAccount().getName()) && sex.equals(accountInfo.getAccount().getSex())) {
            return Result.succee(accountInfo);
        } else {

            flag = true;

            //修改账号表
            Date date = new Date();
            Account account = accountInfo.getAccount();
            account.setName(name);
            account.setSex(sex);
            updateAccount(accountInfo, account);

            resumeinfo.setAccountid(accountInfo.getAccount().getAccountid());
            resumeinfo.setSex(sex);
            updateResumeInfo(accountInfo, resumeinfo, null);

            //插入数据库操作日志
            String log = "[ " + accountInfo.getAccount().getName() + " ]个人账号修改了[ 姓名=" + name + ",性别=" + sex + " ]";
            this.dbLog(accountInfo.getAccount().getAccountid(), StringUtils.isBlank(name) ? accountInfo.getAccount().getName() : name, log, DB_LOG_TYPE);

        }

        if (flag) {
            this.updateToken(accountInfo);
        }

        return Result.succee(accountInfo);
    }

    @Override
    public Result updatePhone(AccountInfo accountInfo, String phone, String code) throws MyException {

        //检测参数
        if (!RegexUtils.checkMobile(phone)) {
            return Result.build(ResultEnum.PHONE_ERROR);
        }
        //验证验证码
        String serverCode = jedisClient.get(Constant.PHONE_CODE_PRE + phone, redisPassword);
        if (!code.equals(serverCode)) {
            return Result.build(ResultEnum.PHONE_CODE_ERROR);
        }

        //修改手机号码
        if (phone.equals(accountInfo.getAccount().getPhone())) {
            return Result.succee(accountInfo);
        } else {

            //修改账号
            Account account = new Account();
            account.setAccountid(accountInfo.getAccount().getAccountid());
            account.setPhone(phone);
            updateAccount(accountInfo, account);

            //判断账号类型
            Integer accountTypeEnterprise = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE);
            Integer accountTypePerson = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON);

            if (accountInfo.getAccount().getDictionariesid().intValue() == accountTypeEnterprise) {
                //企业用户
                //获取账号和企业的关联信息
                AccountenterpriseExample example = new AccountenterpriseExample();
                Criteria criteria = example.createCriteria();
                criteria.andAccountidEqualTo(account.getAccountid());
                List<Accountenterprise> list = accountenterpriseMapper.selectByExample(example);
                //修改企业信息
                Enterpriseinfo enterpriseinfo = new Enterpriseinfo();
                enterpriseinfo.setEnterpriseid(list.get(0).getEnterpriseid());
                enterpriseinfo.setContactorphone(phone);
                updateEnterpriseInfo(accountInfo, enterpriseinfo);

            } else if (account.getDictionariesid().intValue() == accountTypePerson) {
                //个人用户,修改简历 Resumeinfo表
                Resumeinfo resumeinfo = new Resumeinfo();
                resumeinfo.setAccountid(accountInfo.getAccount().getAccountid());
                resumeinfo.setPhone(phone);
                updateResumeInfo(accountInfo, resumeinfo, null);
            }

            //插入数据库操作日志
            String log = "账号ID为[ " + accountInfo.getAccount().getAccountid() + " ]的用户修改绑定手机号为[ " + phone + " ]";
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

            //修改session中的账号信息
            accountInfo.getAccount().setPhone(phone);
            this.updateToken(accountInfo);

            return Result.succee(accountInfo);
        }
    }

    @Override
    public Result updateHeadPhoto(AccountInfo accountInfo, Long headPhotoFileID) throws MyException {

        //修改账号头像
        Account account = new Account();
        account.setAccountid(accountInfo.getAccount().getAccountid());
        account.setHeadphoto(headPhotoFileID);

        updateAccount(accountInfo, account);

        //添加文件应用
        this.addUseFile(headPhotoFileID, "Account", accountInfo.getAccount().getAccountid());

        //判断是否有旧头像,有旧头像删除
        if (accountInfo.getAccount().getHeadphoto() != null) {
            this.deleteFile(accountInfo, DB_LOG_TYPE, accountInfo.getAccount().getHeadphoto(), "Account", accountInfo.getAccount().getAccountid());
        }

        //更新session中的用户信息
        accountInfo.getAccount().setHeadphoto(headPhotoFileID);
        String filePath = fileinfoMapper.getFileFullPathByFileID(headPhotoFileID);
        if (StringUtils.isNotBlank(filePath)) {
            filePath = aliyunOSSClientUtil.getUrl(filePath);
            aliyunOSSClientUtil.closeOSSClient();
        }
        accountInfo.getAccount().setHeadPhotoPath(filePath);

        this.updateToken(accountInfo);

        return Result.succee(accountInfo);
    }

    /**
     * 检测两次密码是否一致
     *
     * @param password
     * @param confirmPassword
     * @return
     */
    private boolean checkTwoPassWord(String password, String confirmPassword) {
        boolean a = StringUtils.isNotBlank(password);
        boolean b = StringUtils.isNotBlank(confirmPassword);
        if (a) {
            if (b) {
                return password.equals(confirmPassword);
            } else {
                return false;
            }
        } else {
            if (b) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/30 0:28
     * 描述 : 注册账号
     *
     * @param phone           电话号码
     * @param code            验证码
     * @param password        密码
     * @param confirmPassword 确认密码
     * @param accountType     账号类型
     * @return
     * @throws Exception
     */
    public Result registerAccount(String phone, String code, String password, String confirmPassword, String accountType) throws Exception {

        // 验证验证码
        String serviceCode = jedisClient.get(Constant.PHONE_CODE_PRE + phone, redisPassword);
        if (!code.equals(serviceCode)) {
            return Result.build(ResultEnum.PHONE_CODE_ERROR);
        }

        // 验证密码和确认密码 一致
        if (!password.equals(confirmPassword)) {
            return Result.build(ResultEnum.ACCOUNT_TWO_PASSWORD_DIFFERENT);
        }

        // 验证手机号正则
        if (!RegexUtils.checkMobile(phone)) {
            return Result.build(ResultEnum.PHONE_ERROR);
        }

        // 解码密码
        BASE64Decoder dn = new BASE64Decoder();
        password = new String(dn.decodeBuffer(password), Constant.CODED_SET);
        Account account = new Account();
        account.setDictionariesid(dictionariesMapper.getDictionariesIDByCode(accountType));
        // 登陆后转跳页面:1完善资料页,2绑定邮箱页,3登陆前页面或首页
        account.setPage(1);
        // 状态: 0不可用,1可用,2删除
        account.setStatus(1);
        account.setPhone(phone);
        account.setPassword(password);
        account.setCreatetime(new Date());
        if (accountType.equals(Constant.ACCOUNT_TYPE_PERSON)) {
            account.setIsmember(false);
        }

        int i = accountMapper.insertSelective(account);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        String log = "";
        // 企业账号
        if (accountType.equals(Constant.ACCOUNT_TYPE_ENTERPRISE)) {

            // 添加企业基本信息
            Enterpriseinfo enterpriseinfo = new Enterpriseinfo();
            enterpriseinfo.setContactorphone(phone);
            i = enterpriseinfoMapper.insertSelective(enterpriseinfo);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }

            // 添加账号和企业信息关联关系
            Accountenterprise accountenterprise = new Accountenterprise();
            accountenterprise.setAccountid(account.getAccountid());
            accountenterprise.setEnterpriseid(enterpriseinfo.getEnterpriseid());

            i = accountenterpriseMapper.insertSelective(accountenterprise);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
            log = "手机号[ " + phone + " ]注册了企业账号";
        } else if (accountType.equals(Constant.ACCOUNT_TYPE_PERSON)) {

            // 添加个人简历信息
            Resumeinfo resumeinfo = new Resumeinfo();
            resumeinfo.setAccountid(account.getAccountid());
            resumeinfo.setPhone(phone);
            resumeinfo.setCreatepersonid(account.getAccountid());
            resumeinfo.setCreatetime(new Date());

            i = resumeinfoMapper.insertSelective(resumeinfo);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
            log = "手机号[ " + phone + " ]注册了个人账号";
        }

        // 数据库操作日志
        dbLog(account.getAccountid(), null, log, DB_LOG_TYPE);

        return Result.succee(account);
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/30 0:15
     * 描述 :修改企业信息
     *
     * @param accountInfo    当前登陆人员
     * @param enterpriseinfo 要修改的企业信息
     * @throws MyException
     */
    private void updateEnterpriseInfo(AccountInfo accountInfo, Enterpriseinfo enterpriseinfo) throws MyException {
        enterpriseinfo.setUpdateby(accountInfo.getAccount().getName());
        enterpriseinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        enterpriseinfo.setUpdatetime(new Date());
        Enterpriseinfo oldEnterpriseInfo = enterpriseinfoMapper.selectByPrimaryKey(enterpriseinfo.getEnterpriseid());

        if (oldEnterpriseInfo != null && enterpriseinfo.getLogofileid() != null && oldEnterpriseInfo.getLogofileid() != null && enterpriseinfo.getLogofileid().longValue() == oldEnterpriseInfo.getLogofileid()) {
            //logo文件ID一致,不修改
            enterpriseinfo.setLogofileid(null);
        }
        //判断是否修改了logo图片

        int i = enterpriseinfoMapper.updateByPrimaryKeySelective(enterpriseinfo);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        if (enterpriseinfo.getLogofileid() != null && oldEnterpriseInfo != null && oldEnterpriseInfo.getLogofileid() != null) {
            if (oldEnterpriseInfo.getLogofileid() != null) {
                //删除旧logo文件
                deleteFile(accountInfo, DB_LOG_TYPE, oldEnterpriseInfo.getLogofileid(), "EnterpriseInfo", (long) oldEnterpriseInfo.getEnterpriseid());
            }
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 23:37
     * 描述 : 添加企业信息
     *
     * @param accountInfo    当前登陆人员
     * @param enterpriseInfo 要添加的企业信息
     * @throws MyException
     */
    private void inertEnterpriseInfo(AccountInfo accountInfo, Enterpriseinfo enterpriseInfo, Account account) throws MyException {
        enterpriseInfo.setCreaepersonid(accountInfo.getAccount().getAccountid());
        enterpriseInfo.setCreateby(enterpriseInfo.getContactorname());
        enterpriseInfo.setCreatetime(new Date());

        int i = enterpriseinfoMapper.insertSelective(enterpriseInfo);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        // 添加账号和企业关联关系
        Accountenterprise accountenterprise = new Accountenterprise();
        accountenterprise.setAccountid(account.getAccountid());
        accountenterprise.setEnterpriseid(enterpriseInfo.getEnterpriseid());
        i = accountenterpriseMapper.insertSelective(accountenterprise);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }

    @Override
    public Result getEnterpriseList(String search, Integer page, Integer pageSize) {
        search = this.checkSearch(search);

        PageHelper.startPage(page, pageSize);
        List<Enterpriseinfo> list = enterpriseinfoMapper.getEnterpriseList(search);

        PageInfo<Enterpriseinfo> data = new PageInfo<>(list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", data.getList());
        map.put("count", data.getTotal());

        return Result.succee(map);
    }

    @Override
    public Result getEnterpriseAccount(AccountInfo accountInfo, Long accountID) {

        //检测是否是管理员账号
        if (!checkManageAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        Map<String, Object> map = accountMapper.getEnterpriseAccountByManage(accountID);

        return Result.succee(map);
    }

    @Override
    public Result finalDeleteEnterpriseAccount(AccountInfo accountInfo, String authorityCode, String ids) throws MyException {

        //检测权限
        Result result = this.checkAuthority(accountInfo, authorityCode);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        String[] EnterpriseAccountArray = ids.split(",");
        for (String EnterpriseAccountIDStr : EnterpriseAccountArray) {

        }

        return null;
    }

    @Override
    public Result recycleAccount(AccountInfo accountInfo, String authorityCode, String ids, int type) throws MyException {
        //检测权限
        Result result = this.checkAuthority(accountInfo, authorityCode);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        String[] accountIDArray = ids.split(",");
        for (String accountIDStr : accountIDArray) {
            if (!StringUtils.isNumeric(accountIDStr)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }

            //修改账号
            Account account = new Account();
            account.setAccountid(Long.parseLong(accountIDStr));
            account.setStatus(1);
            updateAccount(accountInfo, account);


            String log = "";
            if (type == 1){
                //管理员账号
                Account oldAccount = accountMapper.selectByPrimaryKey(Long.parseLong(accountIDStr));
                log = "回收了账号为[ "+ oldAccount.getUsername()  +" ]的管理员账号";
            }else if(type == 2){
                //个人账号
                Account oldAccount = accountMapper.selectByPrimaryKey(Long.parseLong(accountIDStr));
                log = "回收了手机号为的[ " + oldAccount.getPhone()  + " ]个人账号";
            }else {
                //企业账号
                String enterpriseName = enterpriseinfoMapper.getEnterpriseNameByAccountID(Long.parseLong(accountIDStr));
                log = "回收了[enterpriseName]企业的账号";
            }

            //添加数据库操作日志
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
        }

        return Result.succee();
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 22:30
     * 描述 : 添加数据到简历表
     *
     * @param accountInfo 当前登陆人员
     * @param resumeInfo  要添加的数据
     * @throws MyException
     */
    private void insertResumeInfo(AccountInfo accountInfo, Resumeinfo resumeInfo, Livelocation livelocation) throws MyException {
        resumeInfo.setCreatepersonid(accountInfo.getAccount().getAccountid());
        resumeInfo.setCreateby(accountInfo.getAccount().getName());
        resumeInfo.setCreatetime(new Date());
        resumeInfo.setUpdatetime(new Date());
        int i = resumeinfoMapper.insertSelective(resumeInfo);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        if (livelocation != null) {
            //设置简历表ID
            livelocation.setResumeid(resumeInfo.getResumeid());

            i = livelocationMapper.insertSelective(livelocation);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 22:31
     * 描述 :修改简历信息
     *
     * @param accountInfo  当前登陆人员
     * @param resumeinfo   简历信息
     * @param livelocation 当前居住地址
     * @throws MyException
     */
    private void updateResumeInfo(AccountInfo accountInfo, Resumeinfo resumeinfo, Livelocation livelocation) throws MyException {
        resumeinfo.setUpdateby(accountInfo.getAccount().getName());
        resumeinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        resumeinfo.setUpdatetime(new Date());
        int i;
        if (resumeinfo.getResumeid() == null) {
            ResumeinfoExample example = new ResumeinfoExample();
            ResumeinfoExample.Criteria criteria = example.createCriteria();
            criteria.andAccountidEqualTo(resumeinfo.getAccountid());
            i = resumeinfoMapper.updateByExampleSelective(resumeinfo, example);
        } else {
            i = resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);
        }

        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        if (livelocation != null) {
            //设置简历ID
            livelocation.setResumeid(resumeinfo.getResumeid());

            // 查询是否有居住地址配置
            LivelocationExample example = new LivelocationExample();
            com.jy.entiy.function.person.LivelocationExample.Criteria criteria3 = example.createCriteria();
            criteria3.andResumeidEqualTo(resumeinfo.getResumeid());
            int count = livelocationMapper.countByExample(example);

            if (count > 0) {
                //存在,修改
                i = livelocationMapper.updateByExampleSelective(livelocation, example);
                if (i < 1) {
                    throw new MyException(ResultEnum.INSERT_SQL_ERROR);
                }
            } else {
                //不存在,添加
                i = livelocationMapper.insertSelective(livelocation);
                if (i < 1) {
                    throw new MyException(ResultEnum.INSERT_SQL_ERROR);
                }
            }
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 22:54
     * 描述 : 修改个人信息表
     *
     * @param accountInfo 当前登陆人员
     * @param personinfo  要修改的信息
     */
    private void updatePersonInfo(AccountInfo accountInfo, Personinfo personinfo) throws MyException {

        personinfo.setUpdateby(accountInfo.getAccount().getName());
        personinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        personinfo.setUpdatetime(new Date());
        int i;
        if (personinfo.getId() == null) {
            PersoninfoExample example = new PersoninfoExample();
            PersoninfoExample.Criteria criteria = example.createCriteria();
            criteria.andAccountidEqualTo(personinfo.getAccountid());
            i = personinfoMapper.updateByExampleSelective(personinfo, example);
        } else {
            i = personinfoMapper.updateByPrimaryKeySelective(personinfo);
        }
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 22:09
     * 描述 : 添加个人信息到personInfo 表中
     *
     * @param accountInfo 当前登陆人员
     * @param personInfo  要添加的个人信息
     * @return
     */
    private void insertPersonInfo(AccountInfo accountInfo, Personinfo personInfo) throws MyException {
        personInfo.setCreatepersonid(accountInfo.getAccount().getAccountid());
        personInfo.setCreateby(accountInfo.getAccount().getName());
        personInfo.setCreatetime(new Date());

        int i = personinfoMapper.insertSelective(personInfo);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 20:59
     * 描述 : 修改账号
     *
     * @param accountInfo 当前登陆人员
     * @param account     要修改的账号
     * @return
     */
    private void updateAccount(AccountInfo accountInfo, Account account) throws MyException {

        account.setUpdateby(accountInfo.getAccount().getName());
        account.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        account.setUpdatetime(new Date());

        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
    }

    /**
     * 作者: Cheng Fei
     * 创建日期: 2018/10/29 21:04
     * 描述 : 添加账号
     *
     * @param accountInfo 当前登陆人员
     * @param account     要添加的账号
     * @return
     */
    private void insertAccount(AccountInfo accountInfo, Account account) throws MyException {
        account.setCreateby(accountInfo.getAccount().getName());
        account.setCreatepersonid(accountInfo.getAccount().getAccountid());
        account.setCreatetime(new Date());
        int i = accountMapper.insertSelective(account);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }

    /**
     * 删除账号,修改装好状态为已删除状态
     *
     * @param accountInfo   当前登陆人员
     * @param authorityCode 权限编码
     * @param accountIDS    要删除的ID列表,用","隔开
     * @return
     * @throws MyException
     */
    private Result deleteAccount(AccountInfo accountInfo, String authorityCode, String accountIDS)
            throws MyException {

        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, authorityCode);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        String[] accountIDSArray = accountIDS.split(",");

        for (String accountIDStr : accountIDSArray) {

            // 检测参数格式
            if (!StringUtils.isNumeric(accountIDStr)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }

            // 删除账号为假删除,修改状态没不可用
            Account account = new Account();
            account.setAccountid(Long.parseLong(accountIDStr));
            // 状态: 0不可用,1可用,2删除
            account.setStatus(2);
            account.setUpdatepersonid(accountInfo.getAccount().getAccountid());
            account.setUpdatetime(new Date());

            int i = accountMapper.updateByPrimaryKeySelective(account);
            if (i < 1) {
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }

            // 数据库操作日志
            String log = "删除了ID为[ " + accountIDStr + " ]的账号";
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
        }

        return Result.succee();
    }

}
