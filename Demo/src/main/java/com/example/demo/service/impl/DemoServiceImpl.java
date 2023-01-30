package com.example.demo.service.impl;

import com.example.demo.dto.TodoDto;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.TodoJDBCRepository;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private TodoJDBCRepository todoJDBCRepository;

    @Override
    public String hello() {
        return demoRepository.hello();
    }

    @Override
    public List<TodoDto> getTodoById() {
        return todoJDBCRepository.getTodoById();
    }
}
