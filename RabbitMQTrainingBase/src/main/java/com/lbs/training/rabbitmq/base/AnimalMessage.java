package com.lbs.training.rabbitmq.base;

import java.io.Serializable;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.base.
 */
public class AnimalMessage implements Serializable {

	private String behaviour;
	private String color;
	private String kind;

	public String getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "This is a " + behaviour + " " + color + " " + kind;
	}
}
