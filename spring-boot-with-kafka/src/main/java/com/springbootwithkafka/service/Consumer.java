package com.springbootwithkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springbootwithkafka.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class Consumer {


	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) {

		log.info("in send message producer method. Message:", message);
		System.out.println(message);
		System.out.println(String.format("#### -> Consumed message -> %s", message));

	}
	
	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(User user) {

		log.info("in send message producer method. User:", user.toString());
		System.out.println(user.toString());
		System.out.println(String.format("#### -> Consumed User -> %s", user.toString()));

	}

}
