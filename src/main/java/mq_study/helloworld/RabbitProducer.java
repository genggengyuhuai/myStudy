package mq_study.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 * @author lihaoyu
 * @date 2019/12/30 19:14
 */
public class RabbitProducer {
    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = "routing_key_demo";
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 5672;

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
//        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
//        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTING_KEY);
        for (int i = 0; i < 1000; i++)
        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,
                MessageProperties.PERSISTENT_TEXT_PLAIN,("hello world "+i).getBytes());
        channel.close();
        connection.close();
    }
}
