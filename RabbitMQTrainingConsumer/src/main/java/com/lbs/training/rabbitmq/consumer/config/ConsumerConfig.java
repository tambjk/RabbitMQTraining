package com.lbs.training.rabbitmq.consumer.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.producer.
 */

@Configuration
public class ConsumerConfig {

	@Autowired
	private ConsumerProperties consumerProperties;

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		final Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
		factory.setMessageConverter(messageConverter);
		factory.setMaxConcurrentConsumers(consumerProperties.getMaxConcurrentConsumers());
		factory.setConcurrentConsumers(consumerProperties.getConcurrentConsumers());
		factory.setConsecutiveActiveTrigger(1);
		factory.setReceiveTimeout(500L);
		return factory;
	}
}
