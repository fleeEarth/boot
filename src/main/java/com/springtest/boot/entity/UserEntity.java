package com.springtest.boot.entity;


import java.io.Serializable;
import java.util.Objects;

public class UserEntity implements Serializable {

	private Integer userId;
	private String username;
	private String password;
	private String groupId;
	private String friends;
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

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
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

	@Override
	public String toString() {
		return "UserEntity{" +
				       "userId=" + userId +
				       ", username='" + username + '\'' +
				       ", password='" + password + '\'' +
				       ", groupId='" + groupId + '\'' +
				       ", friends='" + friends + '\'' +
				       ", sex='" + sex + '\'' +
				       ", age='" + age + '\'' +
				       ", phone='" + phone + '\'' +
				       ", email='" + email + '\'' +
				       '}';
	}
}
