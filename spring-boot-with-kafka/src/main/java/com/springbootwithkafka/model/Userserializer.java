package com.springbootwithkafka.model;


import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Userserializer implements Serializer<User> {

	@Override
	public byte[] serialize(String topic, User data) {
		byte[] retVal = null;
		final ObjectMapper mapper = new ObjectMapper();

		try {
			retVal = mapper.writeValueAsString(data).getBytes();
		} catch (Exception ee) {
			ee.printStackTrace();

		}

		return retVal;
	}

}