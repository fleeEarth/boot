package com.springtest.boot.service;

import com.springtest.boot.entity.UserEntity;

/**
 * @Author: zh
 * @Date: 2019/4/4 14:44
 */
public interface UserService {

	/**
	 * 检查用户名是否已经存在
	 * @param username
	 * @return
	 */
	public boolean checkName(String username);

	/**
	 * 注册新用户
	 * @param user
	 * @return
	 */
	public boolean registryUser(UserEntity user);

}
