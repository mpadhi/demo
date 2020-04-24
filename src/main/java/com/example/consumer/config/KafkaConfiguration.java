package com.example.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer2;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.consumer.entity.UserData;
import com.example.consumer.model.User;
@EnableKafka
@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ConsumerFactory<String, String>  consumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<String, String>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String>  factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;		
	}
	
	@Bean
	public ConsumerFactory<String, UserData> userConsumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		/*
		 * config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
		 * config.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 300000);
		 * config.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
		 * config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		 * config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		 */
		
		
		return new DefaultKafkaConsumerFactory<String, UserData>(config, new StringDeserializer(), 
				 new ErrorHandlingDeserializer2(new JsonDeserializer<>(UserData.class))  );		
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserData> userKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UserData>  factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;		
	}

}
