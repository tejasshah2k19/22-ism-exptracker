package com.controller.publicapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.AccountRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class SessionController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	AccountRepository accountRepo;

	@PostMapping("/signup")
	public ResponseEntity<ResponseBean<UserBean>> signup(@RequestBody UserBean user) {

		// public ResponseEntity<?> signup(@RequestBody UserBean user) {

		UserBean dbUser = userRepo.findByEmail(user.getEmail());
		ResponseBean<UserBean> res = new ResponseBean<>();

		if (dbUser == null) {
			RoleBean role = roleRepo.findByRoleName("user");
			user.setRole(role);
			userRepo.save(user);
			

			AccountBean account = new AccountBean();
			account.setAccountName("cash");
			account.setBalance(0f);
			account.setCurrency("INR");
			account.setUser(user);
			user.getAccounts().add(account); 

			accountRepo.save(account);
			res.setData(user);
			
			
			res.setMsg("Signup done...");

			return ResponseEntity.ok(res);
		} else {
			res.setData(user);
			res.setMsg("Email Already Taken");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean login) {
		UserBean dbUser = userRepo.findByEmail(login.getEmail());

		if (dbUser == null || !dbUser.getPassword().equals(login.getPassword())) {
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		} else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(dbUser);
			res.setMsg("Login done...");
			return ResponseEntity.ok(res);
		}
	}

}
