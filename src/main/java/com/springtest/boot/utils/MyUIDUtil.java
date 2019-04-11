package com.springtest.boot.utils;

import java.util.UUID;

/**
 * @Author: zh
 * @Date: 2019/4/11 14:12
 */
public class MyUIDUtil {


	/**
	 * 生成16位字符串
	 * @return
	 */
	public static String UID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-","").substring(0,16);
	}

}
