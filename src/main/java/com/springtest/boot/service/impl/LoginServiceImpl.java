package com.springtest.boot.service.impl;

import com.springtest.boot.dao.LoginMapper;
import com.springtest.boot.entity.UserEntity;
import com.springtest.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginMapper loginMapper;

	@Override
	public UserEntity login(String username, String password) {
		UserEntity user = loginMapper.login(username, password);
		return user;
	}
}
