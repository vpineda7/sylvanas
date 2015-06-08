package demo.jms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Spring Projects Demo
 * 
 * @author subin
 * @version 1.0
 */
//@Component
//@Configuration
public class RabbitTemplate {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		
		System.out.println("Received <" + message + ">");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		
		return latch;
	}
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	final static String queueName = "spring-boot";
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}
	
	@Bean
	RabbitTemplate receiver() {
        return new RabbitTemplate();
    }
	
	@Bean
	MessageListenerAdapter listenerAdapter(RabbitTemplate receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	/**
	 * Messaging with RabbitMQ
	 * 
	 * <p>This Demo walks you through the process of setting up a RabbitMQ AMQP server that publishes and subscribes to messages.
	 * 
	 */
	@Scheduled(fixedRate = 5000)
    public void messageRabbitmq() throws Exception {
		
		System.out.println("Waiting five seconds...");
		
        Thread.sleep(5000);
        
        System.out.println("Sending message...");
        
        rabbitTemplate.convertAndSend(queueName, "Hello from RabbitMQ!");
        
        receiver().getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
