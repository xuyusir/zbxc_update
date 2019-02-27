package com.jy.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 工具类
 * 
 * @ClassName:LiuUtils
 * @Description:TODO
 * @author:liuhong
 * @date:2018年8月14日
 */
public class LiuUtils {
	
	private final static int[] li_SecPosValue = { 1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212,
			3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5590 };
	private final static String[] lc_FirstLetter = { "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "w", "x", "y", "z" };
	
	/**
	 * 获取中文汉字拼音首字母
	 * @param chinese1 汉字字符串
	 * @return
	 */
	public static String getChineseAbbreviation(String chinese1) {
		StringBuffer result = new StringBuffer();
		for(int j = 0;j<chinese1.length(); j++) {
			String chinese = chinese1.substring(j, j+1);
			if (chinese == null || chinese.trim().length() == 0) {
				System.out.println("cascc");
			}
			// chinese = String("GB2312", );
			try {
				chinese = new String(chinese.getBytes("GB2312"), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (chinese.length() > 1) // 判断是不是汉字
			{
				int li_SectorCode = (int) chinese.charAt(0); // 汉字区码
				int li_PositionCode = (int) chinese.charAt(1); // 汉字位码
				li_SectorCode = li_SectorCode - 160;
				li_PositionCode = li_PositionCode - 160;
				int li_SecPosCode = li_SectorCode * 100 + li_PositionCode; // 汉字区位码
				if (li_SecPosCode > 1600 && li_SecPosCode < 5590) {
					for (int i = 0; i < 23; i++) {
						if (li_SecPosCode >= li_SecPosValue[i] && li_SecPosCode < li_SecPosValue[i + 1]) {
							chinese = lc_FirstLetter[i];
							break;
						}
					}
				} else // 非汉字字符,如图形符号或ASCII码
				{
					chinese = chinese.substring(0, 1);
				}
			}
			result.append(chinese);
		}
		return result.toString();
	}
	
	/**
	 * 将时间日期转为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param time
	 * @return
	 */
	public static String timeFormatChange(Object time) {
		if (time != null) {
			try {
				Long  t = Long.valueOf(time.toString());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return format.format(t);
			} catch (Exception e) {
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					return format.format((Date)time);
				}catch (Exception a) {
					try {
						return (String)time;
					}catch (Exception d) {
						// TODO: handle exception
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 将字符串转为时间
	 * @param time
	 * @return
	 */
	public static Date timeFormatChanges(String time) {
		if (time != null && !time.equals("")) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				return format.parse(time);
			} catch (Exception e) {
				
			}
		}
		return null;
	}
	
	/**
	 * 将字符串转为时间
	 * @param time
	 * @return
	 */
	public static Date timeFormatChange(String time) {
		if (time != null && !time.equals("")) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return format.parse(time);
			} catch (Exception e) {
				
			}
		}
		return null;
	}


	/**
	 * 根据前台传来的id组格式id1,id2,id3.....转格式为能在sql中查询的id组
	 * 
	 * @param param
	 * @return
	 */
	public static List<String> getIDS(String param) {
		
		//处理连续两个逗号
		String temp = "";
		for(int i =0;i<param.length();i++) {
			if (temp.equals(",") && temp.equals(param.substring(i,i+1))) {
				param = param.substring(0,i)+param.substring(i+1,param.length());
			}
			temp = param.substring(i,i+1);
		}
		
		List<String> list = new ArrayList<>();
		if (param==null || param.equals("")) {
			return list;
		}
		param = param.replace(" ", "");// 去空格
		boolean flag = true;
		
		while (flag) {
			
			if (param == null || param.equals(",") || param.equals("")) {
				flag =false;
				break;
			}
			
			//处理逗号开头
			boolean flag1 = true;
			while(flag1) {
				if (param.substring(0,1).equals(",")) {
					param = param.substring(1,param.length());
				}else {
					flag1 = false;
				}
			}
			
			int index = param.indexOf(",");
			
			if (index > 0) {
				String s = param.substring(0,index);
				param = param.substring(index + 1, param.length());
				if (s != null && !s.equals("")) {
					list.add(s);
				}
				
			} else {
				String s = param;
				if (s != null && !s.equals("")) {
					list.add(s);
				}
				flag = false;
			}

		}

		return list;
	}

	/**
	 * 生成订单号
	 * @return
	 */
	public static String getOrderIdByUUId() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
		String time = format.format(date);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		String Ordercode = time + String.format("%05d", hashCodeV);
		return Ordercode.substring(0,20);
	}
	
	/**
	 * 生成服务单号
	 * @return
	 */
	public static String getServeIdByUUId() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMdd");
		String time = format.format(date);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return time + String.format("%07d", hashCodeV);
	}
	
	/**
	 * 生成简历编号
	 * @return
	 */
	public static String getResumeIdByUUId() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMdd");
		String time = format.format(date);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return time + String.format("%04d", hashCodeV);
	}
	
	/**
	 * 生成任务编号
	 * @return
	 */
	public static String getWorkNoByUUId() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String time = format.format(date);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return time + String.format("%04d", hashCodeV);
	}
	
	public static String getDownNameByUUId(Long AccountID) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmmssSSS");
		String time = format.format(date);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return "/usr/local/excel/"+AccountID+time+".xls";
	}
	
	/**
	 * 时间日期字符串转星期几
	 * @param datetime
	 * @return
	 */
	public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

}
