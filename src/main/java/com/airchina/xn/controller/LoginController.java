package com.airchina.xn.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airchina.xn.entities.User;
import com.airchina.xn.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(Model model){
		model.addAttribute("message", "欢迎登陆");
		return "/login";
	}
	
	/**  
	 *  处理登陆配置  
	 */  

	@RequestMapping(value = "/login", method = RequestMethod.POST)  
    public String login(String username, String password) {  
        User user = userservice.getUserbyuserName(username); 
//        user.setRole(new Role("member"));  
        try {  
            // 如果登陆成功  
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {  
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user  
                        .getPassword().toString());  
                Subject subject = SecurityUtils.getSubject();  
                subject.login(token);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return "redirect:/member/index";  
    }  
	
}
