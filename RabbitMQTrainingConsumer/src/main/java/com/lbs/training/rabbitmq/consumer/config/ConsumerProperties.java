package com.lbs.training.rabbitmq.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Erman.Kaygusuzer on 31.10.2019.
 * RabbitMQ / com.lbs.queue.com.lbs.queue.RabbitMQServer.config.
 */
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class ConsumerProperties {

	private Integer maxConcurrentConsumers;
	private Integer concurrentConsumers;

	public Integer getMaxConcurrentConsumers() {
		return maxConcurrentConsumers;
	}

	public void setMaxConcurrentConsumers(Integer maxConcurrentConsumers) {
		this.maxConcurrentConsumers = maxConcurrentConsumers;
	}

	public Integer getConcurrentConsumers() {
		return concurrentConsumers;
	}

	public void setConcurrentConsumers(Integer concurrentConsumers) {
		this.concurrentConsumers = concurrentConsumers;
	}
}
