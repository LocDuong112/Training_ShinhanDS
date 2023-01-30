package com.example.demo.service;

import com.example.demo.dto.TodoDto;

import java.util.List;

public interface DemoService {
    public String hello();

    public List<TodoDto> getTodoById();
}
