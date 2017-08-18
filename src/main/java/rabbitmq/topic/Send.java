package rabbitmq.topic;

import java.io.IOException;

import rabbitmq.EndPoint;

public class Send extends EndPoint {

    private String queueName;

    public Send(String host, String queueName) {
        this.host = host;
        this.queueName = queueName;
    }

    public void publish() throws IOException {
        init();

        channel.queueDeclare(queueName, false, false, true, null); // durable, exclusive, auto-delete

        String exchangeName = "my_exchange";
        channel.exchangeDeclare(exchangeName, "direct", false, true, null); // durable, auto-delete

        // if set auto-delete to be true, then queues/exchanges will be deleted when no consumers connect to them
        // anymore

        String routingKey = "sos";
        channel.queueBind(queueName, exchangeName, routingKey);

        String msg = "sos, I'm in trouble...";
        for (int i = 0; i < 10000; i++) {

            String myMsg = msg + i;
            channel.basicPublish(exchangeName, routingKey, null, myMsg.getBytes());
            System.out.println("Sent message [" + i + "] : " + myMsg);
        }

    }

    public static void main(String[] args) throws IOException {
        Send send = new Send("localhost", "my_queue");
        send.publish();

        // pub.init();
        // pub.channel.exchangeDelete("my_exchange");
    }

}
