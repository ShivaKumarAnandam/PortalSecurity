package com.springboot.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String wish() {
		return "<h1>Welcome to Spring Security</h1>"+
			   "<br><a href='/admin'>Click here for Admin Portal</a>"+
			   "<br><a href='/user'>Click here for User Portal</a>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1WELCOME TO ADMIN PORTAL</h1>"+
			   "<br><a href='/logout'>Click here to logout</a>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "WELCOME TO USER PORTAL";
	}
}

//Project is a Spring-based application focused on 
//implementing security measures and providing different portals for administrators and users.





