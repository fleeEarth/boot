package com.springtest.boot.socket;


import org.springframework.stereotype.Component;


import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageService {

	public static ConcurrentHashMap<String, Session> users = new ConcurrentHashMap();

	/**
	 * 获取指定ID的Seesion
	 * @param userId
	 * @return
	 */
	public static Session getSession(String userId) {
		return users.get(userId);
	}


	public static void  removeSession(String userId){
		users.remove(userId);
	}

	/**
	 * 向集合里添加用户Session
	 * @param session
	 * @param userId
	 */
	public static void addSession(Session session,String userId) {
		users.put(userId,session);
	}

	/**
	 * 向指定ID的用户发送信息
	 * @param msg
	 * @param userId
	 * @throws IOException
	 */
	public static void sendMsgToUser(String msg, String userId) throws IOException {
		Session session = users.get(userId);
		session.getBasicRemote().sendText(msg);
	}

	/**
	 * 向所有在线用户推送消息
	 * @param msg
	 * @throws IOException
	 */
	public static void sendMsgToOnlineUser(String msg) throws IOException{
		Collection<Session> all = users.values();
		for (Session s:all) {
			s.getBasicRemote().sendText(msg);
		}

	}

	public static void sendMsgToGroupUser(String msg, String groupId) {

	}
}
