package com.springtest.boot.service.impl;

import com.springtest.boot.dao.UserMapper;
import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zh
 * @Date: 2019/4/4 14:44
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkName(String username) {
		List<String> names = userMapper.checkName(username);
		if(names!=null && names.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean registryUser(UserEntity user) {

		Long l = userMapper.registry(user);
		if(l==1){
			return true;
		}
		return false;
	}
}
