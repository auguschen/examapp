package com.airchina.xn.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.airchina.xn.entities.User;
import com.airchina.xn.service.UserService;

/**  
 * 该类从principals中取得用户名称进行匹配,在principals中默认保存了当前登陆人的用户名称,从而将该用户的角色加入到作用域中;  
 */ 
public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userservice;
	
	//登陆第二步,通过用户信息将其权限和角色加入作用域中,达到验证的功能  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 根据用户配置用户与权限  
        if (principals == null) {  
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");  
        }  
        String name = (String) getAvailablePrincipal(principals);  
        List<String> roles = new ArrayList<String>();
        List<String> permissions = new ArrayList<String>();
        // 通过当前登陆用户的姓名查找到相应的用户的所有信息
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);  
        User user = userservice.getUserbyuserName(name);
        if (user.getUsername().equals(name)) {  
        	// 装配用户的角色和权限
//            if (user.getRole() != null) {  
//                roles.add(user.getRole().getName());  
//            }  
        	roles.addAll(userservice.getUserRolesStringbyuserid(user.getId()));
        	permissions.addAll(userservice.getUserPermissonsStringByuserid(user.getId()));
        } else {  
            throw new AuthorizationException();  
        }  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 增加角色  
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;  
	}

    /**  
     * 验证当前登录的Subject  
     * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时  
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
			// 登陆后的操作,此处为登陆有的第一步操作,从LoginController.login中调用了此处的token
	       	UsernamePasswordToken token = (UsernamePasswordToken) authToken;  
	       	System.out.println("token is :" + token);  
	        // 简单默认一个用户,实际项目应User user = userService.getByAccount(token.getUsername());  
	        // 下面通过读取token中的数据重新封装了一个user 
	       	User user = userservice.getUserbyuserName(token.getUsername());
//	        User user = new User("shiro", "123456");  
	        if (user == null) {  
	            throw new AuthorizationException();  
	        }  
	        SimpleAuthenticationInfo info = null;  
	        if (user.getUsername().equals(token.getUsername())) {  
	            info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());  
	        }  
	        //将该User村放入session作用域中  
	        //this.setSession("user", user); 
	        return info;    
	}

	/**  
     * 将一些数据放到ShiroSession中,以便于其它地方使用  
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到  
     */  
    @SuppressWarnings("unused")  
    private void setSession(Object key, Object value) {  
        Subject currentUser = SecurityUtils.getSubject();  
        if (null != currentUser) {  
            Session session = currentUser.getSession();  
            System.out  
                    .println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            if (null != session) {  
                session.setAttribute(key, value);  
            }  
        }  
    }
}
