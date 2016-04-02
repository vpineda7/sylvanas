package org.gandalf.reference.apache;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQSender {
	
	public static void main(String[] args) throws JMSException {
		
		//
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		
		//
		Destination destination = session.createQueue("subin");
		
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		for (int i = 1; i <= 10; i++) {
            TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
            
            producer.send(message);
        }
		
        session.commit();
        
        connection.close();
	}
}
