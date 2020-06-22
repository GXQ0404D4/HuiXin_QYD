package com.ktcn.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MD5Util  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 16位MD5
	 */
	public static String encodeByMd5_16(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString().substring(8,24); // 返回16位MD5
	}
	
	/**
	 * 32位λMD5
	 */
	public static String encodeByMd5_32(String plainText) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i = 0;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString(); // 返回32位MD5
	}
	
	/**
	 * 获取UUID
	 */
	public static String getUUID() {
		// 获取UUID
		String uuid =(String) UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 获取当前格式化时间
	 */
	public static String getNowDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String nowDate = format.format(date);
		return nowDate;
	}
	
	/**
	 * 获取维保码, 当天有效
	 */
	public static String getAppointMaintenanceCode(String nowDate) {
		String maintenanceCode = encodeByMd5_16(nowDate+"qyd").toUpperCase();
		return maintenanceCode;
	}
	
	/**
	 * 获取维保码, 当天有效
	 */
	public static String getMaintenanceCode() {
		String maintenanceCode = encodeByMd5_16(getNowDate()+"qyd").toUpperCase();
		return maintenanceCode;
	}
	
	/**
	 * 获取维保码, 获取当日起三天内有效
	 */
	public static String[] getMaintenanceCode3Days() {
		String nowDate = getNowDate();
		String maintenanceCode1 = encodeByMd5_16(nowDate+"qyd").toUpperCase();
		String maintenanceCode2 = encodeByMd5_16(Integer.parseInt(nowDate)-1+"qyd").toUpperCase();
		String maintenanceCode3 = encodeByMd5_16(Integer.parseInt(nowDate)-2+"qyd").toUpperCase();
		String [] maintenanceCode = new String[] {maintenanceCode1,maintenanceCode2,maintenanceCode3};
		return maintenanceCode;
	}
}
