package com.springbootwithkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootwithkafka.model.User;
import com.springbootwithkafka.service.Producer;

@RestController
@RequestMapping("/kafka/")
public class KafkaController {
	
	@Autowired
	private Producer producer;
	
	@PostMapping("publish/{mess}")
	public void sendMessageToKafkaTopic(@PathVariable("mess")String message) {
		producer.sendMessage(message);
	}
	
	@PostMapping("add-user")
	public User addUser(@RequestBody User user) {
		producer.sendMessage(user);
		return user;
	}

}
