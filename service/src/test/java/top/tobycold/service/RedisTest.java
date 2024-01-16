package top.tobycold.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void demo(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("status", 1, 60, TimeUnit.SECONDS);
        System.out.println(redisTemplate.hasKey("status"));
        System.out.println(valueOperations.get("status"));
    }
}
