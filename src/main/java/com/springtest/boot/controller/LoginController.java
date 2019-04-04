package com.springtest.boot.controller;

import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.service.LoginService;
import com.springtest.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(method = RequestMethod.GET)
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;



	@RequestMapping("/login")
	public ModelAndView login(){

		return new ModelAndView("/user/login");
	}

	@RequestMapping(value = "/checkLogin" ,method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		//ModelMap map = new ModelMap();
		ModelAndView model = new ModelAndView();
		UserEntity user = loginService.login(username, password);
		if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
			//map.addAttribute("errmsg","请输入用户名和密码！");
			model.setViewName("/user/login");
			model.addObject("errmsg","请输入用户名和密码!");
			return model;
		}
		if(user!=null){
			request.getSession().setAttribute("userInfo",user);
			model.setViewName("/index");
			return model;
		}else{
			model.setViewName("/user/login");
			model.addObject("errmsg","用户名或密码错误!");
			return model;
		}


	}



	@ExceptionHandler
	public ModelAndView excep(Exception e){
		ModelAndView model = new ModelAndView();
		System.out.println("LoginController Excep:"+ e.getMessage());
		model.setViewName("/excep/500");
		return model;
	}

}
