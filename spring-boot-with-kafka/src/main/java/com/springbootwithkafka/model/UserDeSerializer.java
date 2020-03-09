/*
 * package com.springbootwithkafka.model;
 * 
 * import java.util.List;
 * 
 * import org.apache.kafka.common.serialization.Deserializer;
 * 
 * import com.fasterxml.jackson.core.type.TypeReference; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * public class UserDeSerializer implements Deserializer<User>{
 * 
 * @Override public User deserialize(String topic, byte[] data) {
 * 
 * final ObjectMapper mapper = new ObjectMapper();
 * 
 * User user = null; try {
 * 
 * user = mapper.readValue(data, new TypeReference<User>() { });
 * 
 * }catch(Exception ee) { ee.printStackTrace(); }
 * 
 * return user; }
 * 
 * }
 */