package com.ktcn.service;

import java.util.List;
import java.util.Set;

import com.ktcn.entity.Tb_user;


public interface Login_Service {
   
	List<Tb_user> LoginUser();

	Tb_user Login_User(String username);

	Set<String> Permissions(String username);

	Set<String> Roles(String username);

	Tb_user findByUsername(String username);
}
