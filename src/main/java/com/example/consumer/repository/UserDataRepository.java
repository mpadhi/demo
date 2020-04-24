package com.example.consumer.repository;

import com.example.consumer.entity.UserData;

import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, Integer>{

}
