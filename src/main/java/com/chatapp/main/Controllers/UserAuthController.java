package com.chatapp.main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.main.Models.User;
import com.chatapp.main.Services.UserService;
import com.chatapp.main.Utilities.PasswordUtils;
import com.chatapp.main.Utilities.Timestamp;

@RestController
@RequestMapping("/users")
public class UserAuthController {
	
    private final UserService userService;

    @Autowired
    public UserAuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String createUser(@RequestBody User user) {
    	if(userService.userAlreadyExists(user.getUserEmail())) {
    		return "User already exists!";
    	}
    	user.setTimeStamp(Timestamp.getTodayDate());
    	user.setPassword(PasswordUtils.hashedPassword(user.getPassword())); 
    	userService.createUser(user);
        return "New User Registered Successfully!!";
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody String userName,String userPassword) {
    	return ""+userName+" "+userPassword;
    }
    
    @GetMapping("/fetchUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    

}