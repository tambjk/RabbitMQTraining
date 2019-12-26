package com.lbs.training.rabbitmq.producer.producer;

import com.lbs.training.rabbitmq.base.AnimalMessage;
import com.lbs.training.rabbitmq.base.RabbitMessageWrapper;
import com.lbs.training.rabbitmq.producer.config.ProducerProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.producer.producer.
 */
@Component
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ProducerProperties producerProperties;

	public String sendMessage(AnimalMessage animalMessage, String routingKey) {
		System.out.println("Sending message = " + animalMessage.toString());

		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(UUID.randomUUID().toString());

		RabbitMessageWrapper rabbitMessageWrapper = new RabbitMessageWrapper();
		rabbitMessageWrapper.setMessageId(UUID.randomUUID());
		rabbitMessageWrapper.setPayload(animalMessage);

		String receive = (String) rabbitTemplate.convertSendAndReceive(producerProperties.getExchangeName(), routingKey, rabbitMessageWrapper, correlationData);
		System.out.println("Received message:" + receive);
		return receive;
	}
}
