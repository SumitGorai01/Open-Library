package com.project.openlibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.openlibrary.model.User;
import com.project.openlibrary.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save_user")
	public String saveUser(@Valid @ModelAttribute("user") User user , BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result);

			return "registerPage";
		}		
		
		userService.saveUser(user);

		return "userLoginPage";
	}

	@PostMapping("/user_login") //write @Valid for validation
	public String userLogin( @ModelAttribute("user") User user, BindingResult result,
			@RequestParam("email") String email, @RequestParam("password") String password) {

		if (result.hasErrors()) {
			System.out.println(result);

			return "userLoginPage";
		}

		User dbUser = userService.findByEmail(email);

		// Check if the user exists
		if (dbUser == null) {
			return "redirect:/user_login_page";
		}

		// Compare the passwords
		if (dbUser.getPassword().equals(password)) {
			System.out.println("Email and Password Matched.");
			return "userDashBoard";
		} else {
			System.out.println("Email and Password Not Matched.");
			return "userLoginPage";
		}
	}

	// display list of user
	@GetMapping("/showAllUser")
	public String showAll(Model model) {
		model.addAttribute("userList", userService.getAllUserRecords());

		return "showRegisterUser";

	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value = "id") Integer id) {
		// call delete employee method
		this.userService.deleteUserbyId(id);
		return "redirect:/showAllUser";

	}

	@GetMapping("/userProfile")
	public String userProfile(User user) {
		return "userProfile";
	}

}
