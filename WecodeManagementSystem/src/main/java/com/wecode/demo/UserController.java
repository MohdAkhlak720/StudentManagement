package com.wecode.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/")
	public UserModel createUser(@RequestBody UserModel model) {
		UserModel addUser = service.addUser(model);
		return addUser;
	}

	@GetMapping("/")
	public List<UserModel> getAllUser() {
		List<UserModel> allUserModels = service.getAllUserModels();
		return allUserModels;
	} 

	@GetMapping("/{userName}")
	public UserModel getModel(@PathVariable String userName) throws Exception {
		UserModel singleUser = service.getSingleUser(userName);
		return singleUser;
	}
}