package com.jy.common.utils;
/**
 * @ClassName:  ExcelUtils   
 * @Description:Excel表格工具类 
 * @author: cheng fei
 * @date:   2018-07-09 11:20
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	/**
	 * 写入excel（简单写入，不涉及单元格合并等）
	 * 
	 * @param result
	 *            需要写入的数据，最外层map代表页，外层List代表行，内层List代表具体行中的数据
	 * @param url
	 *            写出的excel的地址（包含文件名，如：E:1.xls）
	 * @param name
	 *            页名
	 */
	public static Boolean writeExcel(Map<String, List<List<String>>> map, String url) {
		// 创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		for (String name : map.keySet()) {
			// 在workbook中创建一个sheet对应excel中的sheet
			HSSFSheet sheet = workbook.createSheet(name);
			// 取得当前页数据
			List<List<String>> result = map.get(name);
			// 写入数据
			for (int i = 0; i < result.size(); i++) {

				List<String> oneData = result.get(i);
				HSSFRow row1 = sheet.createRow(i);
				for (int j = 0; j < oneData.size(); j++) {

					// 创建单元格设值
					row1.createCell(j).setCellValue(oneData.get(j));
				}
			}
		}

		// 将文件保存到指定的位置
		try {
			FileOutputStream fos = new FileOutputStream(url);
			workbook.write(fos);
			System.out.println("写入成功");
			
			fos.close();
			return true;
		} catch (IOException e) {
			System.out.println("写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
			return false;
		}
	}

	/**setCellStyle
	 * 获取Excel的输出流
	 * @param map Excel的内容
	 * key 为Excel的名称
	 * value 为Excel内容
	 * @return
	 */
	public static HSSFWorkbook getExcelFileStream(Map<String, List<List<String>>> map) {
		// 创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		for (String name : map.keySet()) {
			// 在workbook中创建一个sheet对应excel中的sheet
			HSSFSheet sheet = workbook.createSheet(name);
			// 取得当前页数据
			List<List<String>> result = map.get(name);
			// 写入数据
			for (int i = 0; i < result.size(); i++) {

				List<String> oneData = result.get(i);
				HSSFRow row1 = sheet.createRow(i);
				for (int j = 0; j < oneData.size(); j++) {

					// 创建单元格设值
					HSSFCell cell = row1.createCell(j);
					HSSFCellStyle columnHeadStyle = workbook.createCellStyle();
					columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//  左右居中  
					cell.setCellStyle(columnHeadStyle);
					cell.setCellValue(oneData.get(j));
				}
			}
		}
		return workbook;
	}

	/**
	 * 获取Excel中所有数据,默认第一行是目录,不获取
	 * 
	 * @param path
	 *            Excel文件所在地址
	 * @return
	 */
	public static Map<String, List<String[]>> getAllByExcel(String path) {
		Map<String, List<String[]>> map = new HashMap<>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(path);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				map.put(sheet.getSheetName(), getSheetData(sheet, true));
			}
		} catch (IOException e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 获取Excel所有数据,默认第一行是目录,不获取
	 * 
	 * @param in
	 *            Excel文件输入流
	 * @return
	 */
	public static Map<String, List<String[]>> getAllByExcel(InputStream in) {
		Map<String, List<String[]>> map = new HashMap<>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				map.put(sheet.getSheetName(), getSheetData(sheet, true));
			}
		} catch (Exception e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 获取Excel所有数据
	 * 
	 * @param in
	 *            Excel文件输入流
	 * @param hasMenu
	 *            是否获取第一行数据
	 * @return
	 */
	public static Map<String, List<String[]>> getAllByExcel(InputStream in, boolean hasMenu) {
		Map<String, List<String[]>> map = new HashMap<>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				map.put(sheet.getSheetName(), getSheetData(sheet, hasMenu));
			}
		} catch (Exception e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 获取Excel所有数据
	 * 
	 * @param in
	 *            Excel文件输入流
	 * @param hasMenu
	 *            是否获取第一行数据
	 * @return
	 */
	public static Map<String, List<String[]>> getAllByExcel1(InputStream in, boolean hasMenu) {
		Map<String, List<String[]>> map = new HashMap<>();
		try {
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				HSSFSheet sheet = workbook.getSheetAt(i);
				map.put(sheet.getSheetName(), getSheetData1(sheet, hasMenu));
			}
		} catch (Exception e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 获取Excel中所有数据
	 * 
	 * @param path
	 *            Excel文件所在地址
	 * @param hasMenu
	 *            Excel第一行是否是目录
	 * @return
	 */
	public static List<List<String[]>> getAllByExcel(String path, boolean hasMenu) {
		List<List<String[]>> list = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(path);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				list.add(getSheetData(sheet, hasMenu));
			}
		} catch (IOException e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 获取指定sheet的所有数据,默认第一行是目录
	 * 
	 * @param path
	 *            Excel文件所在地址
	 * @param sheet
	 *            Excel 页码
	 * @return
	 */
	public static List<String[]> getSheetAllByExcel(String path, int sheet) {
		List<String[]> list = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			XSSFSheet sh = new XSSFWorkbook(path).getSheetAt(sheet);
			list = getSheetData(sh, true);
		} catch (Exception e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取指定sheet的所有数据
	 * 
	 * @param path
	 *            Excel文件所在地址
	 * @param sheet
	 *            Excel页码
	 * @param hasMenu
	 *            Excel第一行是否是目录
	 * @return
	 */
	public static List<String[]> getSheetAllByExcel(String path, int sheet, boolean hasMenu) {
		List<String[]> list = new ArrayList<>();
		try {
			@SuppressWarnings("deprecation")
			XSSFSheet sh = new XSSFWorkbook(path).getSheetAt(sheet);
			list = getSheetData(sh, hasMenu);
		} catch (Exception e) {
			System.out.println("读取Excel异常");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取sheet中的数据
	 * 
	 * @param sheet
	 * @return
	 */
	private static List<String[]> getSheetData(XSSFSheet sheet, boolean hasMenu) {
		List<String[]> list = new ArrayList<>();
		int maxLastCellNum = getMaxLastCellNum(sheet, hasMenu);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			if (hasMenu && i == 0) {
				continue;
			}
			XSSFRow row = sheet.getRow(i);
			if (row == null) {
				list.add(null);
				continue;
			}
			String s[] = new String[maxLastCellNum];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				s[j] = getValue(row.getCell(j));
			}
			list.add(s);
		}
		return list;
	}

	/**
	 * 获取sheet中的数据
	 * 
	 * @param sheet
	 * @return
	 */
	private static List<String[]> getSheetData1(HSSFSheet sheet, boolean hasMenu) {
		List<String[]> list = new ArrayList<>();
		int maxLastCellNum = getMaxLastCellNum1(sheet, hasMenu);
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			if (hasMenu && i == 0) {
				continue;
			}
			HSSFRow row = sheet.getRow(i);
			if (row == null) {
				list.add(null);
				continue;
			}
			String s[] = new String[maxLastCellNum];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				s[j] = getValue1(row.getCell(j));
			}
			list.add(s);
		}
		return list;
	}

	/**
	 * 获取当前Excel最大列数
	 * 
	 * @param sheet
	 *            当前Excel页
	 * @param hasMenu
	 *            第一行是否是目录
	 */
	private static int getMaxLastCellNum(XSSFSheet sheet, boolean hasMenu) {
		int maxLastCellNum = 0;
		if (hasMenu) {
			return sheet.getRow(0).getLastCellNum();
		}
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			if (sheet.getRow(i) == null) {
				continue;
			}
			if (sheet.getRow(i).getLastCellNum() > maxLastCellNum) {
				maxLastCellNum = sheet.getRow(i).getLastCellNum();
			}
		}
		return maxLastCellNum;
	}

	/**
	 * 获取当前Excel最大列数
	 * 
	 * @param sheet
	 *            当前Excel页
	 * @param hasMenu
	 *            第一行是否是目录
	 */
	private static int getMaxLastCellNum1(HSSFSheet sheet, boolean hasMenu) {
		int maxLastCellNum = 0;
		if (hasMenu) {
			return sheet.getRow(0).getLastCellNum();
		}
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			if (sheet.getRow(i) == null) {
				continue;
			}
			if (sheet.getRow(i).getLastCellNum() > maxLastCellNum) {
				maxLastCellNum = sheet.getRow(i).getLastCellNum();
			}
		}
		return maxLastCellNum;
	}

	/**
	 * 获取value
	 * 
	 * @param cell
	 * @return
	 */
	private static String getValue(XSSFCell cell) {
		if (cell == null || cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			return null;
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}

	/**
	 * 获取value
	 * 
	 * @param cell
	 * @return
	 */
	private static String getValue1(HSSFCell cell) {
		if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return null;
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}
}
