package com.springtest.boot.controller;

import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.service.LoginService;
import com.springtest.boot.utils.AESUtil;
import com.springtest.boot.utils.CheckCodeUtil;
import com.springtest.boot.utils.MyUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import sun.security.util.KeyUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.UUID;

@RequestMapping(method = RequestMethod.GET)
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;



	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/login");
		String key = MyUIDUtil.UID();//密钥
		String iv = MyUIDUtil.UID();//偏移量
		model.addObject("iv",iv);
		model.addObject("key",key);
		request.getSession().setAttribute("key",key);
		request.getSession().setAttribute("iv",iv);
		return model;
	}

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request){
		Object userInfo = request.getSession().getAttribute("userInfo");
		if(userInfo!=null){
			return new ModelAndView("/user/index");
		}
		ModelAndView model = new ModelAndView("/login");
		String key = MyUIDUtil.UID();//密钥
		String iv = MyUIDUtil.UID();//偏移量
		model.addObject("iv",iv);
		model.addObject("key",key);
		request.getSession().setAttribute("key",key);
		request.getSession().setAttribute("iv",iv);
		return model;
	}

	@RequestMapping(value = "/checkLogin" ,method = RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam String username, @RequestParam String password,@RequestParam String code, HttpServletRequest request) {
		//ModelMap map = new ModelMap();
		ModelAndView model = new ModelAndView();
		if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
			//map.addAttribute("errmsg","请输入用户名和密码！");
			model.setViewName("/login");
			model.addObject("errmsg","请输入用户名和密码!");
			return model;
		}
		String checkCode = (String)request.getSession().getAttribute("checkCode");
		if(checkCode==null || !checkCode.equals(code)){
			model.setViewName("/login");
			model.addObject("errmsg","验证码不正确!");
			return model;
		}
		String key = (String)request.getSession().getAttribute("key");
		String iv = (String)request.getSession().getAttribute("iv");
		String pwd = AESUtil.decrypt(password, key, iv);
		UserEntity user = loginService.login(username, pwd);
		if(user!=null){
			user.setPassword("");
			request.getSession().setAttribute("userInfo",user);
			model.setViewName("/user/index");
			return model;
		}else{
			model.setViewName("/login");
			model.addObject("errmsg","用户名或密码错误!");
			return model;
		}


	}

	@RequestMapping(value = "/getCode" ,produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public void getImg(HttpServletRequest request , HttpServletResponse response) throws Exception{
		BufferedImage img = CheckCodeUtil.drawCode(request);
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

	@RequestMapping(value = "/checkCode" )
	@ResponseBody
	public boolean checkCode(@RequestParam String code,HttpServletRequest request){

		String checkCode =(String) request.getSession().getAttribute("checkCode");
		if(checkCode!=null && checkCode.equals(code)){
			return true;
		}
		return false;
	}



}
