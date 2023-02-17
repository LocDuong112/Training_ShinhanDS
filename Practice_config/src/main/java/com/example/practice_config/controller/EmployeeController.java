package com.example.practice_config.controller;

import com.example.practice_config.dto.EmployeeDto;
import com.example.practice_config.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("validate")
    public ResponseEntity<EmployeeDto> validateEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        try {
            employeeService.getEmployeeDto(employeeDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
