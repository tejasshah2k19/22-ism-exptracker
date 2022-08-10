package com.controller.publicapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@PostMapping("/signup")
	public String signup(UserBean user) {
		RoleBean role = roleRepo.findByRoleName("user");
		user.setRole(role);
		userRepo.save(user);
		return "Signup";
	}

}
