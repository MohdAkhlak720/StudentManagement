package com.wecode.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	List<UserModel> list = new ArrayList<>();

	public UserService() {
		list.add(new UserModel("abc", "abc", "ABC@gmail.com"));
		list.add(new UserModel("xyz", "abcxyz", "XYZ@gmail.com"));
	}

	public List<UserModel> getAllUserModels() {
		return list;
	}

	public UserModel getSingleUser(String userName) throws Exception {
		UserModel model = null;
		if (userName != null) {
			for (UserModel user : list) {
				if (userName.equalsIgnoreCase(user.getUserName())) {
					model = new UserModel();
					model = user;
				}
			}
			return model;
		} else {
			throw new Exception(userName + " not found");
		}
	}

	public UserModel addUser(UserModel model) {
		boolean add = list.add(model);
		System.out.println(add);
		return model;
	}
}