package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.repository.UserRepository;

/**
 * Rest controller which is responsible for retrieving {@link User}s.
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    
    @Autowired
    public UserResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        logger.info("Get Users Total Users: "+users.size());
        return users;
    }

    @PostMapping(path="/save", produces = "application/JSON")
    public User createUser(@RequestBody User user) {
        logger.info("Create User: " + user);
        return userRepository.save(user);
    }

    @GetMapping(value = "/{id}", produces = "application/JSON")
    public Optional<User> findById(@PathVariable("id") String userID) {
    	logger.info("Get User By Id : "+userID);
        return userRepository.findById(userID);
    }
}