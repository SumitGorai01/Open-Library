package com.project.openlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.openlibrary.model.Admin;
import com.project.openlibrary.model.User;


@Controller
public class IndexController {
	
	
	@GetMapping("/")
	public String getIndexPage() {
		
		return "index";
	}

	@GetMapping("/register_page")
	public String getRegisterPage(User user) {
		return "registerPage";
	}
	
	@GetMapping("/user_login_page")
	public String getLoginPage(User user) {
		return "userLoginPage";
		
	}
	
	@GetMapping("/admin_login_page")
	public String getAdminPage(Admin admin) {
		return "adminLoginPage";
		
	}
	
	@GetMapping("/admin")
	public String getAdminDashboardPage(Admin admin) {
		return "adminDashboard";
		
	}
	
	

}
