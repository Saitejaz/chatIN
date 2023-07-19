package com.chatapp.main.Services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.chatapp.main.Models.User;
import com.chatapp.main.Repositories.UserRepository;

@Service
public class UserService {
	
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;
    
    @Autowired
    public UserService(UserRepository userRepository,MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    
    
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public boolean userAlreadyExists(String email) {
    	return userRepository.existsByEmail(email);
    }
    
    public User getUserByEmail(Object email) {
    	Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        System.out.println(query.toString());
        return mongoTemplate.findOne(query, User.class);
    }

}

