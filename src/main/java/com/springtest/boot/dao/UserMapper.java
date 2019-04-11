package com.springtest.boot.dao;

import com.springtest.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zh
 * @Date: 2019/4/4 14:45
 */
@Mapper
public interface UserMapper {

	public List<String> checkName(@Param("username") String username);

	public Long registry(@Param("user") UserEntity user);

	public Long update(@Param("user") UserEntity user);
}
