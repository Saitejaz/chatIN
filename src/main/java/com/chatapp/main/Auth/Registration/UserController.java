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
    public String createUser(@RequestBody User user) {
    	if(userService.userAlreadyExists(user.getUserEmail())) {
    		return "User already exists!";
    	}
    	user.setPassword(PasswordUtils.hashedPassword(user.getPassword())); 
    	userService.createUser(user);
        return "New User Registered a user successfully!!";
    }

    @GetMapping("/fetchUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    

}