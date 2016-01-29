package com.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "User Information")
public class User {

	@ApiModelProperty(value = "Name of the User", required = true)
	private String name;

	@ApiModelProperty(value = "Username of the User", required = true)
	private String userName;

	@ApiModelProperty(value = "Password of the User", required = true)
	private String password;

	public User() {
	}

	public User(String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
