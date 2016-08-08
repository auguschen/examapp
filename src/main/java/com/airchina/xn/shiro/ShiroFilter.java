package com.airchina.xn.shiro;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.airchina.xn.dao.UserMapper;
import com.airchina.xn.entities.Role;
import com.airchina.xn.entities.User;
import com.airchina.xn.service.UserService;

public class ShiroFilter implements Filter {

	@Autowired
	private UserService userservice;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain filterchain)
			throws IOException, ServletException {
		System.out.println("启用filter........");
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) respone;  
        Principal principal = httpRequest.getUserPrincipal();  
  
        if (principal != null) {  
            Subject subjects = SecurityUtils.getSubject();  
            // 为了简单，这里初始化一个用户。实际项目项目中应该去数据库里通过名字取用户：  
            // 例如：User user = userService.getByAccount(principal.getName());  
            
            User user = userservice.getUserbyuserName(principal.getName());
/*
            User user = new User();  
            user.setName("shiro");  
            user.setPassword("123456");  
            user.setRole(new Role("member"));  
*/
            if (user.getUsername().equals(principal.getName())) {  
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());  
                subjects = SecurityUtils.getSubject();  
                subjects.login(token);  
                subjects.getSession();  
            } else {  
                // 如果用户为空，则subjects信息登出  
                if (subjects != null) {  
                    subjects.logout();  
                }  
            }  
        }  
        filterchain.doFilter(httpRequest, httpResponse);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
