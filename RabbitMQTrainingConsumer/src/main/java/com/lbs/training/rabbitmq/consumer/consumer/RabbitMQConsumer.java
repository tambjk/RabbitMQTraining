package com.lbs.training.rabbitmq.consumer.consumer;

import com.lbs.training.rabbitmq.base.RabbitMessageWrapper;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Erman.Kaygusuzer on 25.12.2019.
 * RabbitMQTraining / com.lbs.training.rabbitmq.consumer.consumer.
 */
@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "orangeQueue", containerFactory = "rabbitListenerContainerFactory", concurrency = "30")
	public String listenOrange(RabbitMessageWrapper message) {
		if(message != null){
			try{
				Thread.sleep(1100);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Received a orange animal message: " + message.getPayload().toString());
			return "orangeQueue: " + message.getPayload().toString();
		} else{
			System.out.println("Received a orange animal message: Empty");
			throw new AmqpRejectAndDontRequeueException("Empty message");
		}
	}

	@RabbitListener(queues = "lazyRabbitQueue", containerFactory = "rabbitListenerContainerFactory", concurrency = "30")
	public String listenLazyRabbit(RabbitMessageWrapper message) {
		if(message != null){
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Received a lazy rabbit message: " + message.getPayload().toString());
			return "lazyRabbitQueue: " + message.getPayload().toString();
		} else{
			System.out.println("Received a lazy rabbit message: Empty");
			throw new AmqpRejectAndDontRequeueException("Empty message");
		}
	}
}
