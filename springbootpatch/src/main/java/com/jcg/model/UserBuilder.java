package com.jcg.model;

public class UserBuilder {

	private User user;

	public UserBuilder() {
		this.user = new User();
	}

	public UserBuilder fullName(String newName) {
		user.setFullName(newName);
		return this;
	}

	public UserBuilder age(int newAge) {
		user.setAge(newAge);
		return this;
	}

	public User build() {
		return user;
	}
}
