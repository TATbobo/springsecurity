package com.tucker.securitydemo.entity;

import com.tucker.securitydemo.annotation.MyConstrain;

import javax.validation.constraints.Null;

public class User {
    @Null
    private Integer id;

    @MyConstrain(message = "测试")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
