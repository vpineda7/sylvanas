package reference.mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQReceiver {
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(Boolean.FALSE,
                Session.AUTO_ACKNOWLEDGE);
		
		
		Destination destination = session.createQueue("subin");
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		while (true) {
			
            //设置接收者接收消息的时间，为了便于测试，这里谁定为100s
            TextMessage message = (TextMessage) consumer.receive(100000);
            if (null != message) {
                System.out.println("收到消息" + message.getText());
            } else {
                break;
            }
        }
		
		connection.close();
	}
}
