package rabbitmq.topic;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import rabbitmq.EndPoint;

import java.io.IOException;

public class Recv extends EndPoint {
    private String queueName;

    private Recv(String host, String queueName) {
        this.host = host;
        this.queueName = queueName;
    }

    private void consume(Consumer consumer) throws IOException {
        init();

        channel.queueDeclare(queueName, false, false, true, null); // durable, exclusive, auto-delete

        channel.basicConsume(queueName, false, consumer);
    }

    public static void main(String[] args) throws IOException {

        Recv myConsumer = new Recv("localhost", "my_queue");

        Consumer consumer = new DefaultConsumer(myConsumer.channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("Consuming msg: " + msg + "consumerTag:[" + consumerTag + "]");
            }
        };

        myConsumer.consume(consumer);



    }
}
