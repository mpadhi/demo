package com.example.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consumer.entity.UserData;

import com.example.consumer.repository.UserDataRepository;

@Service
public class UserDataService {
	
	@Autowired
	UserDataRepository repository;
	
	public List<UserData> getAllData(){
		List<UserData> data = new ArrayList<UserData>();
		repository.findAll().forEach(data::add);		
		return data;	
	}
	
	public  void addData(UserData data) {
		
		repository.save(data);
	}

}
