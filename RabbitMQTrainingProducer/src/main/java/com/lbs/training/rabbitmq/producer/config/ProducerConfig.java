package com.lbs.training.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.producer.
 */

@Configuration
public class ProducerConfig {

	@Autowired
	private ProducerProperties producerProperties;

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public RabbitTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setReceiveTimeout(15000);
		rabbitTemplate.setReplyTimeout(15000);
		return rabbitTemplate;
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(producerProperties.getExchangeName());
	}

	@Bean
	Queue orangeQueue() {
		Map<String, Object> args = new HashMap<>();
		return new Queue("orangeQueue", true, false, false, args);
	}

	@Bean
	Queue lazyRabbitQueue() {
		Map<String, Object> args = new HashMap<>();
		return new Queue("lazyRabbitQueue", true, false, false, args);
	}

	@Bean
	Binding orangeBinding(@Qualifier("orangeQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("*.orange.*");
	}

	@Bean
	Binding rabbitBinding(@Qualifier("lazyRabbitQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("*.*.rabbit");
	}

	@Bean
	Binding lazyAnimalBinding(@Qualifier("lazyRabbitQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("lazy.#");
	}
}
