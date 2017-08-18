package rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EndPoint {
    private Connection connection;
    protected Channel channel;
    protected String host;

    protected void init() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public void close() throws IOException {
        channel.close();
        connection.close();
    }

}
