package com.springtest.boot.controller;

import com.springtest.boot.socket.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MsgController {

	@RequestMapping("/send")
	@ResponseBody
	public String send(@RequestParam String msg) {
		try {
			MessageService.sendMsgToUser(msg, "1");
			return "发送成功！";
		} catch (IOException e) {
			return "发送失败！";
		}
	}


}
