package com.jy.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5加密
 * @author chengfei
 * @date 2018年4月24日
 *
 */
public class MD5Utils {
	
	/**
	 * 对字符串进行MD5加密,字符串编码为utf-8
	 * @param text
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String MD5(String data){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(data.getBytes("utf-8"));
			byte[] digest = md5.digest();
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				int val = ((int) digest[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			throw new RuntimeException("MD5加密异常");
		}
	}
	
	public static void main(String[] args) {
		String md5 = MD5("");
		System.out.println("md5==>"+md5);
	}
}
