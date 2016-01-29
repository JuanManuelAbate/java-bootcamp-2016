package com.example;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
	private List<User> users;

	public UsersList() {
		users = new ArrayList<User>();
	}

	public boolean contains(String userName) {
		boolean founded = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName))
				founded = true;
		}
		return founded;
	}

	public void addUser(User newUser) {
		users.add(0, newUser);
	}

	public void deleteUser(String userName) {
		users.remove(position(userName));
	}

	public void updateUser(User updateUser) {
		users.get(position(updateUser.getUserName())).setName(updateUser.getName());
		users.get(position(updateUser.getUserName())).setPassword(updateUser.getPassword());
	}

	public List<User> findByName(String name) {
		List<User> usersByName = new ArrayList<User>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name)) {
				usersByName.add(users.get(i));
			}
		}
		return usersByName;
	}

	public User findByUserName(String userName) {
		return users.get(position(userName));
	}

	public List<User> getAllUsers() {
		return this.users;
	}

	// Private Methods

	private int position(String userName) {
		int pos = -1;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userName))
				pos = i;
		}
		return pos;
	}
}
