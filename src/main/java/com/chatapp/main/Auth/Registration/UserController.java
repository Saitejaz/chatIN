package com.chatapp.main.Auth.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
	}
	
	@PostMapping("/register")
	public User createUser(@RequestBody User user) {
		user.setPassword(PasswordUtils.hashedPassword(user.getPassword()));
		return userRepository.save(user);
	}
}
