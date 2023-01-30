package com.example.demo.controller;

import com.example.demo.dto.TodoDto;
import com.example.demo.service.DemoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value  = "/api/")
public class DemoController {
    @Autowired
    private DemoService demoService;

    private List<TodoDto> todoList = new ArrayList<>();
    @PostConstruct
    public void init() {
        todoList.add(null);
    }

    @GetMapping(value = "hello")
    public String index() {
        return demoService.hello();
    }

    @GetMapping(value = "")
    public List<TodoDto> getTodoList() {
        return todoList;
    }

    @PostMapping(value = "todo")
    public List<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        todoList.add(todoDto);
        return todoList;
    }

    @PutMapping(value = "todo/{todoId}")
    public TodoDto editTodo(@PathVariable("todoId") Integer todoId, @RequestBody TodoDto todoDto) {
        todoList.set(todoId, todoDto);
        return todoDto;
    }

    @DeleteMapping(value = "todo/{todoId}")
    public String deleteTodo(@PathVariable("todoId") Integer todoId) {
        todoList.remove(todoId.intValue());
        return "deleted";
    }

    @GetMapping(value = "todo/getJDBC")
    public List<TodoDto> getJDBC() {
        return demoService.getTodoById();
    }
}
