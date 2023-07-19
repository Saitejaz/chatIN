package com.chatapp.main.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chatapp.main.Models.User;

public interface UserRepository extends MongoRepository<User, String>{
	Boolean existsByEmail(String email);

}
