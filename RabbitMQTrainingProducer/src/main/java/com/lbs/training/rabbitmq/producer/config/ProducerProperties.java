package com.lbs.training.rabbitmq.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Erman.Kaygusuzer on 31.10.2019.
 * RabbitMQ / com.lbs.queue.com.lbs.queue.RabbitMQServer.config.
 */
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class ProducerProperties {

	private String exchangeName;

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
}
