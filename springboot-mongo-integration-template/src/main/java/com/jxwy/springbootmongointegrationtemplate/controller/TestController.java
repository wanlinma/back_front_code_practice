package com.jxwy.springbootmongointegrationtemplate.controller;

import com.jxwy.springbootmongointegrationtemplate.entity.TestEntity;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("findAllUser")
    public List<TestEntity> findAllUser() {
        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(), "test2");
        List<TestEntity> test = mongoTemplate.find(query, TestEntity.class, "test");
        Query query = new Query();
        return test;
    }

}
