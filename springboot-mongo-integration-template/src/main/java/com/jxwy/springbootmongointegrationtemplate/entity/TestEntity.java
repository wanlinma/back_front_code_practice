package com.jxwy.springbootmongointegrationtemplate.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("test")
public class TestEntity {

    @Field("name")
    private String name;

}
