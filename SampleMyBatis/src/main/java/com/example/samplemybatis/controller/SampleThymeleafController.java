package com.example.samplemybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleThymeleafController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);

        List<String> testArr = new ArrayList<>();
        testArr.add("test 1");
        testArr.add("test 2");
        testArr.add("test 3");

        model.addAttribute("arr", testArr);

        return "hello";
    }
}
