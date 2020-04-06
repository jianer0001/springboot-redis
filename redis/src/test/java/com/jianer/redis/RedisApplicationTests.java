package com.jianer.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","jianer",2, TimeUnit.MINUTES);
        Object name = valueOperations.get("name");
        System.out.println(name);
    }

    @Test
    public void test3() {
        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
        value.set("age","29",2,TimeUnit.MINUTES);
        String age = value.get("age");
        System.out.println(age);
    }

    @Test
    public void test1() {
        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
        String age = value.get("age");
        System.out.println(age);
    }

    @Test
    public void test2() {
        ValueOperations value = redisTemplate.opsForValue();
        Object name = value.get("name");
        System.out.println(name);
    }

}
