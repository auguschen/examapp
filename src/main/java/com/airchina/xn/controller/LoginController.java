package com.airchina.xn.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airchina.xn.entities.Role;
import com.airchina.xn.entities.User;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(Model model){
		return "/login";
	}
	
	/**  
	 *  处理登陆配置  
	 */  
/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)  
    public String login(String username, String password) {  
        User user = new User("shiro", "123456");  
        user.setRole(new Role("member"));  
        try {  
            // 如果登陆成功  
            if (user.getName().equals(username) && user.getPassword().equals(password)) {  
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user  
                        .getPassword().toString());  
                Subject subject = SecurityUtils.getSubject();  
                subject.login(token);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return "redirect:/member/index";  
    }  
*/	
}
