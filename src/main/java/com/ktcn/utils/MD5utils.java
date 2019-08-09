package com.ktcn.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5utils {
  
	public static Object Md5utils(String password,String account){
		//加密方式
        String hashAlgorithmName = "MD5";
        //明文密码
        Object credentials = password;
        //盐值
        Object salt = ByteSource.Util.bytes(account);
        int hashIterations = 2;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        //加密后的密码
        
		return result;
		
	}
}
