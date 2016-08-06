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

import com.airchina.xn.entities.Role;
import com.airchina.xn.entities.User;

public class ShiroFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) arg0;  
        HttpServletResponse httpResponse = (HttpServletResponse) arg1;  
        Principal principal = httpRequest.getUserPrincipal();  
  
        if (principal != null) {  
            Subject subjects = SecurityUtils.getSubject();  
            // 为了简单，这里初始化一个用户。实际项目项目中应该去数据库里通过名字取用户：  
            // 例如：User user = userService.getByAccount(principal.getName());  
            User user = new User();  
            user.setName("shiro");  
            user.setPassword("123456");  
            user.setRole(new Role("member"));  
            if (user.getName().equals(principal.getName())) {  
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user  
                        .getPassword());  
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
        arg2.doFilter(httpRequest, httpResponse);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
