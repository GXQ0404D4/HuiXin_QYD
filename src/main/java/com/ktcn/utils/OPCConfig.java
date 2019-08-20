package com.ktcn.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.openscada.opc.lib.common.ConnectionInformation;


/**
 * @author 11
 *
 */
/**
 * @author 11
 *
 */
public class OPCConfig {
    private static OPCConfig OPCCONFIG=new OPCConfig();
	
	private OPCConfig(){}
	
	public static OPCConfig  getConnectionInformation2(){	
		
		return OPCCONFIG;		
	}
	public final static ConnectionInformation getConnectionInformation(){
	final ConnectionInformation ci = new ConnectionInformation(); 
	 InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Properties p = new Properties();
		 try {
			p.load(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	    // 获取IP地址         
		    String ip = null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    ci.setHost(ip);                                          // 电脑IP
	    ci.setDomain(p.getProperty("domain"));                   // 域，为空就行
	    ci.setUser(p.getProperty("username"));                   // 电脑上自己建好的用户名
	    ci.setPassword(p.getProperty("password"));               // 密码	     	 
	                                                             // 使用KEPServer的配置
	    ci.setClsid(p.getProperty("clsid"));                     // KEPServer的注册表ID，可以在“组件服务”里看到
		return ci;
     }
	//获取properties 文件内容
	 public static void getPropertiesFromResourceBundleInputStream() throws IOException {	
		 InputStream in = new BufferedInputStream(new FileInputStream("src/main/resources/config.properties"));
		 Properties p = new Properties();
		 p.load(in);
		 System.out.println(p.getProperty("password"));
	        
	 }
}
