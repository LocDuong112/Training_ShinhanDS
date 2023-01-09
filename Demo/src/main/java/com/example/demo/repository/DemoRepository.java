package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
    public String hello() {
        return "Hello, World!";
    }
}
