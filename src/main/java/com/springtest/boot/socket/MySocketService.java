package com.springtest.boot.socket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/websocket")
@Component
public class MySocketService {

	private Session session;

	@OnOpen
	public void onOpen(Session session) throws IOException {
		this.session = session;
		MessageService.addSession(session,"1");
	}

	@OnClose
	public void onClose() throws IOException{
		MessageService.removeSession("1");
	}

}
