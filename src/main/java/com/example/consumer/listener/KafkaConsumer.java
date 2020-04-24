package com.example.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumer.entity.UserData;
import com.example.consumer.model.User;
import com.example.consumer.service.UserDataService;

@Service
public class KafkaConsumer {
	
	@Autowired
	UserDataService userDataService;
	
	
	@KafkaListener(topics = "TestTopic", groupId = "group_id")
	public void consume(String message) {
		System.out.println("consumed message: "  +	message);
	}
	
	@KafkaListener(topics = "TestTopicJson", groupId = "group_json", 
			containerFactory = "userKafkaListenerContainerFactory")
	public void consumeJson(UserData user) {
		System.out.println("consumed JSON message: "  +	user);
		userDataService.addData(user);
	}

}
