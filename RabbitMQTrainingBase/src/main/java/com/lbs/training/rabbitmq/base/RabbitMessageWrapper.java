package com.lbs.training.rabbitmq.base;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.base.
 */
public class RabbitMessageWrapper implements Serializable {

	private UUID messageId;
	private AnimalMessage payload;

	public UUID getMessageId() {
		return messageId;
	}

	public void setMessageId(UUID messageId) {
		this.messageId = messageId;
	}

	public AnimalMessage getPayload() {
		return payload;
	}

	public void setPayload(AnimalMessage payload) {
		this.payload = payload;
	}
}
