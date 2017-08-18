package redis.listener;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class SubListener extends MessageListenerAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    private void init() {
        System.out.println("SubListener is listening...");
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        byte[] body = message.getBody();// 请使用valueSerializer
        byte[] channel = message.getChannel();

        String msg = (String) redisTemplate.getValueSerializer().deserialize(body);
        String topic = (String) redisTemplate.getStringSerializer().deserialize(channel);

        System.out.println("Receiving message: " + msg + ", topic: " + topic);
    }
}
