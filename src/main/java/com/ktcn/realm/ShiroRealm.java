package com.ktcn.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ktcn.entity.Tb_resource;
import com.ktcn.entity.Tb_role;
import com.ktcn.entity.Tb_user;
import com.ktcn.mapper.Login_Mapper;
import com.ktcn.mapper.Login_Resource;
import com.ktcn.mapper.Login_Role;
import com.ktcn.utils.MD5utils;

/**
 * 获取用户的角色和权限信息 Created by bamboo on 2017/5/10.
 */
public class ShiroRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

	// 一般这里都写的是servic，我省略了service的接口和实现方法直接调用的dao
	@Autowired
	private Login_Mapper Tb_userDao;
	@Autowired
	private Login_Role Tb_roleDao;
	@Autowired
	private Login_Resource Tb_resourceDao;

	/**
	 * 登录认证
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		logger.info("验证当前Subject时获取到token为：" + token.toString());

		// 查出是否有此用户
		Tb_user hasUser = Tb_userDao.findByName(token.getUsername());
		System.out.println(hasUser + "查出是否有此用户");

		// 1). principal: 认证的实体信息. 可以是 username,
		// 也可以是数据表对应的用户的实体类对象.存入的是username取的就是username,存的是user对象取的就是user对象
		Md5Hash md5utils = null;
		String account=null;
		// 2). credentials: 密码.
		String credentials = null; // "fc1709d0a95a6be30bc5926fdb7f22f4";
		// 3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		// 4). 盐值.
		ByteSource credentialsSalt = null;
		
		String password= null;
		try {
			if (hasUser != null) {
				 account = hasUser.getAccount();
				 credentials=hasUser.getPassword();
				 System.out.println(credentials+"密码 password");				 
				 String name = hasUser.getName();
				 System.out.println(name);
				 
				 /*md5utils = MD5utils.Md5utils(credentials,name);
                 System.out.println(md5utils.toString()+"+++++md5utils");*/
                /* password = new SimpleHash("MD5", credentials,name, 2).toString();
                 System.out.println(password.toString()+"++++password");*/
                 
				 credentialsSalt=ByteSource.Util.bytes(hasUser.getAccount());
				 System.out.println(credentialsSalt+"账户盐度");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 
		// 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
		return new SimpleAuthenticationInfo(
				account,
				credentials,
				credentialsSalt, 
				realmName);// ByteSource.Util.bytes(hasUser.getName()),

	}

	/**
	 * 权限认证
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("##################执行Shiro权限认证##################");
		System.out.println("授权方法");
		// 获取当前登录输入的用户名，等价于(String)
		// principalCollection.fromRealm(getName()).iterator().next();
		// String loginName = (String)
		// super.getAvailablePrincipal(principalCollection);
		Tb_user user = (Tb_user) principalCollection.getPrimaryPrincipal();
		// //到数据库查是否有此对象
		// User user = null;//
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		// user = userMapper.findByName(loginName);
		if (user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Tb_role> rlist = Tb_roleDao.findRoleByUid(user.getUser_id());// 获取用户角色
			List<Tb_resource> plist = Tb_resourceDao.findPermissionByUid(user.getUser_id());// 获取用户权限
			List<String> roleStrlist = new ArrayList<String>();//// 用户的角色集合
			System.out.println(roleStrlist + "授权...用户角色的集合");
			List<String> perminsStrlist = new ArrayList<String>();// 用户的权限集合
			System.out.println(perminsStrlist + "授权...用户的权限集合");
			for (Tb_role role : rlist) {
				roleStrlist.add(role.getRole_name());
			}
			for (Tb_resource Tb_resource : plist) {
				perminsStrlist.add(Tb_resource.getRes_name());
				// 用户的角色集合
				info.addRoles(roleStrlist);
				// 用户的权限集合
				info.addStringPermissions(perminsStrlist);

				return info;
			}
			// 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
			return null;
		}
		return null;

	}
}
