package com.airchina.xn.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.airchina.xn.entities.Role;
import com.airchina.xn.entities.User;

public class ShiroRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // 根据用户配置用户与权限  
        if (arg0 == null) {  
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");  
        }  
        String name = (String) getAvailablePrincipal(arg0);  
        List<String> roles = new ArrayList<String>();  
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);  
        User user = new User("shiro", "123456");  
        Role role = new Role("member");  
        user.setRole(role);  
        if (user.getName().equals(name)) {  
            if (user.getRole() != null) {  
                roles.add(user.getRole().getName());  
            }  
        } else {  
            throw new AuthorizationException();  
        }  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 增加角色  
        info.addRoles(roles);  
        return info;  
	}

	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
	       UsernamePasswordToken token = (UsernamePasswordToken) arg0;  
	        // 简单默认一个用户,实际项目应User user = userService.getByAccount(token.getUsername());  
	        User user = new User("shiro", "123456");  
	        if (user == null) {  
	            throw new AuthorizationException();  
	        }  
	        SimpleAuthenticationInfo info = null;  
	        if (user.getName().equals(token.getUsername())) {  
	            info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());  
	        }  
	        return info;    
	}

}
