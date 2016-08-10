package com.airchina.xn.service;

import java.util.List;

import com.airchina.xn.entities.User;
import com.airchina.xn.entities.UserRoles;
import com.airchina.xn.entities.UserRolesPermissions;

public interface UserService {

	public User getUserbyuserName(String username);
	
	public User getUserbyId(Integer id);
	
	public List<UserRoles> getUserRolesbyusername(String username);
	
	public List<UserRoles> getUserRolesbyuserid(Integer id);
	
	public List<String> getUserRolesStringbyusername(String username);
	
	public List<String> getUserRolesStringbyuserid(Integer id);
	
	public List<UserRolesPermissions> getUserPermissonsByusername(String username);
	
	public List<UserRolesPermissions> getUserPermissonsByuserid(Integer id);
	
	public List<String> getUserPermissonsStringByusername(String username);
	
	public List<String> getUserPermissonsStringByuserid(Integer id);
}
