package com.example.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumer.entity.UserData;

import com.example.consumer.service.UserDataService;

@RestController 
@RequestMapping("/UserData")
public class UserController {
	
	@Autowired
	UserDataService data;
	
	@GetMapping(path = "/get", produces = "application/json")
	public List<UserData> get()  {
		
	return data.getAllData();
		
	}
	 
}
