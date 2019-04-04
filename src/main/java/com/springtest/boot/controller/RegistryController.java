package com.springtest.boot.controller;

import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

/**
 * @Author: zh
 * @Date: 2019/4/4 14:59
 */
@Controller
public class RegistryController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registry",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView registry(){
		ModelAndView model = new ModelAndView();
		model.setViewName("/user/registry");
		return model;
	}

	/**
	 * 注册用户服务
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/checkRegistry",method = {RequestMethod.POST})
	public ModelAndView checkRegistry(UserEntity user){
		ModelAndView model = new ModelAndView();
		boolean b = this.checkUser(user);
		if(!b){
			model.addObject("errmsg","注册信息有误！");
			model.setViewName("/user/registry");
		}
		model.setViewName("/user/login");
		return model;
	}

	/**
	 * 检查用户填的信息是否规范
	 * @param user
	 * @return
	 */
	public boolean checkUser(UserEntity user){
		if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
			return false;
		}
		boolean b = userService.checkName(user.getUsername());
		if(b){
			return false;
		}

		return true;
	}
}
