package my.project.hong.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by kiseokhong on 2021/04/18.
 */
@Service
public class RedisServiceImpl implements RedisService{

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public ResponseEntity<?> addRedisKey() {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(UUID.randomUUID().toString(), "key");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getRedisKey(String key) {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        String data = value.get(key);
        boolean result = false;
        if(null != data) {
            redisTemplate.delete(key);
            result = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
