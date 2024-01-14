package com.project.openlibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.openlibrary.model.Admin;
import com.project.openlibrary.repository.AdminRepository;

@Controller
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	

	@PostMapping("/admin_login")
	public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

		Admin dbAdmin = adminRepository.findByUsername(username);

		// Check if the user exists
		if (dbAdmin == null) {
			return "User not found";
		}

	// Compare the passwords
		if (dbAdmin.getPassword().equals(password)) {
			return "redirect:/admin";
		} else {
			return "adminLoginPage";
		}
	}

	@GetMapping("/admin_team_profile")
	public String viewTeam(Admin admin) {
		return "teamProfile";
	}
	
	

}