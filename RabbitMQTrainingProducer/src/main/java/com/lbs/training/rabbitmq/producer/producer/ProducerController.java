package com.lbs.training.rabbitmq.producer.producer;

import com.lbs.training.rabbitmq.base.AnimalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.producer.producer.
 */
@RestController
@RequestMapping("/queue")
public class ProducerController {

	@Autowired
	private Producer producer;

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public String add(@RequestBody AnimalMessage animalMessage, @RequestParam(name = "routingKey") String routingKey) {
		return producer.sendMessage(animalMessage, routingKey);
	}
}
