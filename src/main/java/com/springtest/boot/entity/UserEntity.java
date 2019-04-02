package com.springtest.boot.entity;


import java.util.Objects;

public class UserEntity {
	private String userId;
	private String username;
	private String password;
	private String groupId;
	private String firends;
	private String blacks;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getBlack() {
		return blacks;
	}

	public void setBlack(String blacks) {
		this.blacks = blacks;
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
