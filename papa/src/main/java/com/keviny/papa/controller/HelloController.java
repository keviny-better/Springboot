package com.keviny.papa.controller;

import com.keviny.papa.dao.PersonRepository;
import com.keviny.papa.entity.Person;
import com.keviny.papa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
    @Value("${hi}")
    private String hi;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/hello")
    public String sayHello(){
        Person person=new Person();
        person.setAge(22);
        person.setName("小明");
        stringRedisTemplate.opsForValue().set("hello","hello");
        stringRedisTemplate.opsForValue().set("中文","你好");
        jsonRedisTemplate.opsForValue().set("person",person);
        jsonRedisTemplate.opsForValue().set("测试","你好");

        Person person2=new Person();
        person2= (Person) jsonRedisTemplate.opsForValue().get("person");

//        personService.savePerson(person);
        String pname=personService.findPerson(2);

        return hi+pname;
    }
}
