package com.oi.ai.dashboard.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oi.ai.dashboard.model.User;
import com.oi.ai.dashboard.model.UserEntity;
import com.oi.ai.dashboard.service.UserService;

@RestController
public class UserAuthenticationController {
	public static final Logger logger = LoggerFactory.getLogger(UserAuthenticationController.class);
	@Autowired
	UserService userService;

	@PostMapping("/auth")
	private UserEntity authenticate(@RequestBody User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return userService.authenticateUser(user);

	}
}
