package com.ktcn.common;

public class ByteUtils {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] sdfsd={(byte) 28.8,(byte) 58.6,(byte) 78.9};
		byte asd=(byte)99.99;
		// 返回无符号的2进制表示 1110011
		String hex = Integer.toBinaryString(115);
		System.out.println(hex);
		// 返回2进制的字符串1110011对应的值 115
		System.out.println(Integer.valueOf("1110011", 2));
		 
		// 16进制值转换成二进制
		System.out.println(Long.parseLong("49", 16));
		System.out.println(Long.parseLong("2F", 16));
		String byteToBit = ByteUtils.byteToBit(asd);
		System.out.println(byteToBit);
		String intb = ByteUtils.IntToBit(2);
		System.out.println(intb);
	}
	/**
	 * Byte转Bit
	 */
	public static String byteToBit(byte b) {
		return "" +(byte)((b >> 7) & 0x1) + 
		(byte)((b >> 6) & 0x1) + 
		(byte)((b >> 5) & 0x1) + 
		(byte)((b >> 4) & 0x1) + 
		(byte)((b >> 3) & 0x1) + 
		(byte)((b >> 2) & 0x1) + 
		(byte)((b >> 1) & 0x1) + 
		(byte)((b >> 0) & 0x1);
	}
	 
	/**
	 * Bit转Byte
	 */
	public static byte BitToByte(String byteStr) {
		int re, len;
		if (null == byteStr) {
			return 0;
		}
		len = byteStr.length();
		if (len != 4 && len != 8) {
			return 0;
		}
		if (len == 8) {// 8 bit处理
			if (byteStr.charAt(0) == '0') {// 正数
				re = Integer.parseInt(byteStr, 2);
			} else {// 负数
				re = Integer.parseInt(byteStr, 2) - 256;
			}
		} else {//4 bit处理
			re = Integer.parseInt(byteStr, 2);
		}
		return (byte) re;
	}
	
	public static String IntToBit(int b) {
		return "" +(int)((b >> 31) & 0x1) + 
				(int)((b >> 30) & 0x1) + 
				(int)((b >> 29) & 0x1) + 
				(int)((b >> 28) & 0x1) + 
				(int)((b >> 27) & 0x1) + 
				(int)((b >> 26) & 0x1) + 
				(int)((b >> 25) & 0x1) + 
				(int)((b >> 24) & 0x1) + 
				(int)((b >> 23) & 0x1) + 
				(int)((b >> 22) & 0x1) + 
				(int)((b >> 21) & 0x1) + 
				(int)((b >> 20) & 0x1) + 
				(int)((b >> 19) & 0x1) + 
				(int)((b >> 18) & 0x1) + 
				(int)((b >> 17) & 0x1) + 
				(int)((b >> 16) & 0x1) + 
				(int)((b >> 15) & 0x1) + 
				(int)((b >> 14) & 0x1) + 
				(int)((b >> 13) & 0x1) + 
				(int)((b >> 12) & 0x1) + 
				(int)((b >> 11) & 0x1) + 
				(int)((b >> 10) & 0x1) + 
				(int)((b >> 9) & 0x1) + 		
				(int)((b >> 8) & 0x1) + 
				(int)((b >> 7) & 0x1) + 
				(int)((b >> 6) & 0x1) + 
				(int)((b >> 5) & 0x1) + 
				(int)((b >> 4) & 0x1) + 
				(int)((b >> 3) & 0x1) + 
				(int)((b >> 2) & 0x1) + 
				(int)((b >> 1) & 0x1) + 
				(int)((b >> 0) & 0x1);
	}
}
