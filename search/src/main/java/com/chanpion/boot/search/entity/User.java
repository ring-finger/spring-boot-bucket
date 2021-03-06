package com.chanpion.boot.search.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author April Chen
 * @date 2019/9/17 14:29
 */
@Document(indexName = "user")
public class User {

    private String username;
    private int age;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

