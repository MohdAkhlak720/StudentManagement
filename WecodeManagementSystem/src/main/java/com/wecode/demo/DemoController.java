package com.wecode.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public")
public class DemoController {
	
	@GetMapping("/login")
	public String sayHello() {
		String str="Welcome to java";
		return str+=" login page";
	}
	@GetMapping("/home")
	public String sayHello1() {
		String str="Welcome to java";
		return str+=" home page";
	}

}
