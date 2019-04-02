package com.springtest.boot.service;

import com.springtest.boot.entity.UserEntity;


public interface LoginService {

	public UserEntity login(String username , String password);

}
