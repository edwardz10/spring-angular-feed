package com.example.springangularfeed.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springangularfeed.model.User;
import com.example.springangularfeed.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
    @RequestMapping(method = GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/start", method = POST)
    public ResponseEntity<?> startFeed() {
    	userService.startFeed();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/stop", method = POST)
    public ResponseEntity<?> stopFeed() {
    	userService.stopFeed();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/reset", method = POST)
    public ResponseEntity<?> reset() {
    	userService.reset();
        return new ResponseEntity(HttpStatus.OK);
    }

}
