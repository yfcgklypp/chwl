package com.chwl.cn.utils.encryp;

import java.security.MessageDigest;

/**
 * @author ypp
 */
public class MD5Utils {

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}
	
	/**
	 * MD5 32位小写加密
	 * @param encryptStr
	 * @return
	 */
	public static String encrypt32(String encryptStr) {  
	       MessageDigest md5;  
	       try {  
	           md5 = MessageDigest.getInstance("MD5");  
	           byte[] md5Bytes = md5.digest(encryptStr.getBytes());  
	           StringBuffer hexValue = new StringBuffer();  
	           for (int i = 0; i < md5Bytes.length; i++) {  
	               int val = ((int) md5Bytes[i]) & 0xff;  
	               if (val < 16)  
	                   hexValue.append("0");  
	               hexValue.append(Integer.toHexString(val));  
	           }  
	           encryptStr = hexValue.toString();  
	       } catch (Exception e) {  
	           throw new RuntimeException(e);  
	       }  
	       return encryptStr;  
	   } 
}
