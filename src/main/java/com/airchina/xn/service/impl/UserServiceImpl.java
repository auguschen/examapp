package com.airchina.xn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.UserMapper;
import com.airchina.xn.dao.UserRolesMapper;
import com.airchina.xn.dao.UserRolesPermissionsMapper;
import com.airchina.xn.entities.User;
import com.airchina.xn.entities.UserRoles;
import com.airchina.xn.entities.UserRolesPermissions;
import com.airchina.xn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private UserRolesMapper userrolesmapper;
	
	@Autowired
	private UserRolesPermissionsMapper userrolespermissionsmapper;
	
	@Override
	public User getUserbyuserName(String username) {
		return usermapper.selectByUserName(username);
	}

	@Override
	public User getUserbyId(Integer id) {
		return usermapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserRoles> getUserRolesbyusername(String username) {
		return userrolesmapper.selectByUserName(username);
	}

	@Override
	public List<UserRoles> getUserRolesbyuserid(Integer id) {
		return userrolesmapper.selectByUserID(id);
	}

	@Override
	public List<String> getUserRolesStringbyusername(String username) {
		List<String> r = new ArrayList<String>();
		List<UserRoles> roles = userrolesmapper.selectByUserName(username);
		for(UserRoles ur: roles){
			r.add(ur.getRoleName());
		}
		return r;
	}

	@Override
	public List<String> getUserRolesStringbyuserid(Integer id) {
		List<String> r = new ArrayList<String>();
		List<UserRoles> roles = userrolesmapper.selectByUserID(id);
		for(UserRoles ur: roles){
			r.add(ur.getRoleName());
		}
		return r;
	}

	@Override
	public List<UserRolesPermissions> getUserPermissonsByusername(String username) {
		return userrolespermissionsmapper.selectByUserName(username);
	}

	@Override
	public List<UserRolesPermissions> getUserPermissonsByuserid(Integer id) {
		return userrolespermissionsmapper.selectByUserID(id);
	}

	@Override
	public List<String> getUserPermissonsStringByusername(String username) {
		List<String> p = new ArrayList<String>();
		List<UserRolesPermissions> permissions = userrolespermissionsmapper.selectByUserName(username);
		for(UserRolesPermissions urp: permissions){
			p.add(urp.getPermissionName());
		}
		return p;
	}

	@Override
	public List<String> getUserPermissonsStringByuserid(Integer id) {
		List<String> p = new ArrayList<String>();
		List<UserRolesPermissions> permissions = userrolespermissionsmapper.selectByUserID(id);
		for(UserRolesPermissions urp: permissions){
			p.add(urp.getPermissionName());
		}
		return p;
	}

}
