package my.project.hong.web.controller;

import my.project.hong.model.code.CommonConst;
import my.project.hong.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.PastOrPresent;

/**
 * Created by kiseokhong on 01/03/2020.
 */
@RestController
@RequestMapping(CommonConst.URL_ROOT+"/redis")
public class RedisController {

    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }


    @PostMapping("")
    public void addKey(){
        redisService.addRedisKey();
    }

    @GetMapping("/{key}")
    public ResponseEntity<?> getKey(@PathVariable(value = "key") String key){
        return redisService.getRedisKey(key);
    }

}
