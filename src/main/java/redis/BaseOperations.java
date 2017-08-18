package redis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class BaseOperations {

    @Autowired
    private RedisTemplate<String, String>   redisTemplate;

    private ValueOperations<String, String> valueOperations;

    @PostConstruct
    private void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    public void set(String key, String val) {
        valueOperations.set(key, val);
    }

    public String get(String key) {
        return valueOperations.get(key);
    }
}
