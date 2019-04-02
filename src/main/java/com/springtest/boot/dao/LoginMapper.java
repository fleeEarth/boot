package com.springtest.boot.dao;

import com.springtest.boot.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

	public UserEntity login();
}
