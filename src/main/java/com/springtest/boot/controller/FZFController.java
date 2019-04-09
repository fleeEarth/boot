package com.springtest.boot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 404
 * @Author: zh
 * @Date: 2019/4/4 15:25
 */
@Controller
public class FZFController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(ERROR_PATH)
	public String error(){
		return "/excep/404";
	}
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@ExceptionHandler
	public ModelAndView excep(Exception e){
		ModelAndView model = new ModelAndView();
		System.out.println("Excep:"+ e.getMessage());
		model.setViewName("/excep/500");
		return model;
	}

}
