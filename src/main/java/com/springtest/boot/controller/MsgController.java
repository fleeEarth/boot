package com.springtest.boot.controller;

import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.socket.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MsgController {

	@RequestMapping("/send")
	@ResponseBody
	public String send(@RequestParam String msg, HttpServletRequest request) {
		try {
			UserEntity userInfo = (UserEntity)request.getSession().getAttribute("userInfo");
			MessageService.sendMsgToUser(msg, userInfo.getUserId().toString());
			return "发送成功！";
		} catch (IOException e) {
			return "发送失败！";

		}
	}


}
