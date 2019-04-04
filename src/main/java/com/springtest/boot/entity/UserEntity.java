package com.springtest.boot.entity;


import java.io.Serializable;
import java.util.Objects;

public class UserEntity implements Serializable {

	private Integer userId;
	private String username;
	private String password;
	private String groupId;
	private String firends;
	private String sex; //0男1女
	private String age;
	private String phone;
	private String email;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFirends() {
		return firends;
	}

	public void setFirends(String firends) {
		this.firends = firends;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserEntity that = (UserEntity) o;
		return userId.equals(that.userId) &&
				       username.equals(that.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, username);
	}
}
