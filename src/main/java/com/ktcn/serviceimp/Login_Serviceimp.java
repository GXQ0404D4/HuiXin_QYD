package com.ktcn.serviceimp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktcn.entity.Tb_user;
import com.ktcn.mapper.Login_Mapper;
import com.ktcn.service.Login_Service;

@Service
public class Login_Serviceimp implements Login_Service{
	
	
	
	
	@Autowired (required=true)
	Login_Mapper Login_Mapper;


	@Override
	public Tb_user Login_User(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Tb_user> LoginUser() {
		// TODO Auto-generated method stub
		List<Tb_user> loginUser = Login_Mapper.LoginUser();
		System.out.println(loginUser+"+++++++++user查询");
		return null;
	}


	@Override
	public Set<String> Permissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Set<String> Roles(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Tb_user findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
