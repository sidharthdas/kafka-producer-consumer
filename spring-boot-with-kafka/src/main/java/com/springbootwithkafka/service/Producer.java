package com.springbootwithkafka.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.springbootwithkafka.model.User;
import com.springbootwithkafka.model.Userserializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Producer {

	private static final String TOPIC = "users";

	

	@Autowired
	private KafkaTemplate<String, String> kafkaTEmplate;

	@Autowired
	private KafkaTemplate<String, User> kafkaTEmplateUser;

	public void sendMessage(String message) {

		log.info("in send message producer method. Message:", message);
		kafkaTEmplate.send(TOPIC, message);
	}
	
	
	public KafkaProducer<String, User> getKafkaProducer(){
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		return new KafkaProducer<String,User>(props, new StringSerializer(),new Userserializer());
	}

	public void sendMessage(User user) {
		getKafkaProducer().send(new ProducerRecord<String, User>(TOPIC, user));
		
	}

}
