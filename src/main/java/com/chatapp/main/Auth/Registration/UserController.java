package com.chatapp.main.Auth.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody User user) {	
    	user.setPassword(PasswordUtils.hashedPassword(user.getPassword())); 
        return userService.createUser(user);
    }

    @GetMapping("/fetchUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}