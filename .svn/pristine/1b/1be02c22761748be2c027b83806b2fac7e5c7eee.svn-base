package com.jy.service.system.select;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.system.select.SelectMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.SelectConstant;
import com.jy.entiy.system.select.Select;
import com.jy.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SelectServiceImpl
 * @Description:配置表统一处理接口实现类
 * @author: cheng fei
 * @date: 2018-09-18 17:18
 */

@Service
public class SelectServiceImpl extends BaseService implements SelectService {

    @Resource
    private SelectMapper selectMapper;

    @Override
    public Result insert(AccountInfo accountInfo, String AUTHORITY_CODE, Select select) throws MyException {

        //检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != 200) {
            return checkAuthority;
        }
        //补全参数
        select.setCreatePersonID(accountInfo.getAccount().getAccountid());
        select.setCreateBy(accountInfo.getAccount().getName());
        select.setCreateTime(new Date());
        // 设置状态,1可用 0 不可用
        select.setStatus(1);

        String table_name = selectMapper.getTableName(select.getTableID());
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        String column_id = tableColumn[0];
        String column_name = tableColumn[1];

        if (!(boolean) checkCode(select.getCode(), select.getTableID(), null).getData()) {
            return Result.build(ResultEnum.CODE_EXIST);
        }

        int i = selectMapper.insertSelect(table_name, column_id, column_name, select);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        return Result.succee();
    }

    @Override
    public Result getSelectByID(Integer table_id) {

        String table = selectMapper.getTableName(table_id);
        String[] tableColumn = SelectConstant.getTableColumn(table);
        String id = tableColumn[0];
        String name = tableColumn[1];
        List<Map<String, Object>> select = selectMapper.getSelect(id, name, table);

        return Result.succee(select);
    }

    @Override
    public Result getSelectByName(String table_Name) {

        String[] tableColumn = SelectConstant.getTableColumn(table_Name);
        String id = tableColumn[0];
        String name = tableColumn[1];
        List<Map<String, Object>> select = selectMapper.getSelect(id, name, table_Name);

        return Result.succee(select);
    }

    @Override
    public Result getSelectList(AccountInfo accountInfo, Integer table_id) {

        String table_name = selectMapper.getTableName(table_id);
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        if(tableColumn == null || tableColumn.length == 0) {
        	return Result.build(ResultEnum.DB_CONSTRUCTION_ERROR);
        }else {
        	String column_id = tableColumn[0];
        	String column_name = tableColumn[1];
        	List<Map<String, Object>> select = selectMapper.getSelectList(column_id, column_name, table_name);
        	return Result.succee(select);
		}
}


    @Override
    public Result updateSelect(AccountInfo accountInfo, String AUTHORITY_CODE, Select select) throws MyException {

        //检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != 200) {
            return checkAuthority;
        }

        // 补全参数
        select.setUpdateBy(accountInfo.getAccount().getName());
        select.setCreatePersonID(accountInfo.getAccount().getAccountid());
        select.setUpdateTime(new Date());

        String table_name = selectMapper.getTableName(select.getTableID());
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        String column_id = tableColumn[0];
        String column_name = tableColumn[1];

        if (select.getCode() != null && !(boolean) checkCode(select.getCode(), select.getTableID(), select.getId()).getData()) {
            return Result.build(ResultEnum.CODE_EXIST);
        }

        int i = selectMapper.updateSelect(table_name, column_id, column_name, select);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        return Result.succee();
    }

    @Override
    public Result deleteSelect(AccountInfo accountInfo, String AUTHORITY_CODE, Integer table_id, Integer id) throws MyException {

        //检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != 200) {
            return checkAuthority;
        }

        String table_name = selectMapper.getTableName(table_id);
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        String column_id = tableColumn[0];

        int i = selectMapper.deleteSelect(table_name, column_id, id);
        if (i < 1) {
            throw new MyException(ResultEnum.DELETE_SQL_ERROR);
        }
        return Result.succee();
    }

    @Override
    public Result getSelect(AccountInfo accountInfo, Integer table_id, Integer id) throws MyException {

        //检测账号类型
        if (!this.checkManageAccount(accountInfo.getAccount())){
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        String table_name = selectMapper.getTableName(table_id);
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        String column_id = tableColumn[0];
        String column_name = tableColumn[1];

        Map<String, Object> one = selectMapper.getOne(column_id, column_name, table_name, id);

        return Result.succee(one);
    }

    @Override
    public Result checkCode(String code, Integer table_id, Integer id) {

        String table_name = selectMapper.getTableName(table_id);
        String[] tableColumn = SelectConstant.getTableColumn(table_name);
        String column_id = tableColumn[0];
        int i = selectMapper.checkCode(table_name, code, column_id, id);

        return Result.succee(i == 0 ? true : false);
    }

}
