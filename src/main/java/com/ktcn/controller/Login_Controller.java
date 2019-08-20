package com.ktcn.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktcn.service.Login_Service;
import com.ktcn.utils.MD5utils;

@Controller
public class Login_Controller {

	@Autowired
	Login_Service Login_Serviceimp;
	
	@RequestMapping("/Login")
	public String login(HttpServletRequest request, @RequestParam ("password") String password, @RequestParam ("account")String account) throws Exception{
	    System.out.println("HomeController.login()"+password+account);
	    Object md5utils = MD5utils.Md5utils(password, account);
	    System.out.println(md5utils+"加密后密码++++++"+md5utils.toString());
	    
        Subject subject = SecurityUtils.getSubject();
        //数据库的密码我进行了Md5加密。如果没有进行加密的无需这个
        //Tb_user.setUserPassword(MD5Util.getPwd(Tb_user.getPassword()));
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try {
            subject.login(token);
            //System.out.println(getSession().getId());
 
        } catch (UnknownAccountException e){
        }

	    return "page/index";
	}
	
}
