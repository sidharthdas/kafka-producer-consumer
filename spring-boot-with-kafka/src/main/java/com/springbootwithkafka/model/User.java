package com.springbootwithkafka.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.kafka.common.serialization.Serializer;

public class User implements Serializer{

	private int id;
	private String name;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public byte[] serialize(String topic, Object data) {
		// TODO Auto-generated method stub

	       try {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ObjectOutputStream oos = new ObjectOutputStream(baos);
	            oos.writeObject(data);
	            oos.close();
	            byte[] b = baos.toByteArray();
	            return b;
	        } catch (IOException e) {
	            return new byte[0];
	        }
	}

}
