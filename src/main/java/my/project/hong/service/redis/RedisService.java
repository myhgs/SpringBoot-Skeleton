package my.project.hong.service.redis;

import org.springframework.http.ResponseEntity;

/**
 * Created by kiseokhong on 2021/04/18.
 */
public interface RedisService {

    ResponseEntity<?> addRedisKey();

    ResponseEntity<?> getRedisKey(String key);

}
