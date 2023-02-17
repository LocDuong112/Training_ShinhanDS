package com.example.practice_config.controller;

import com.example.practice_config.dto.DepartmentDto;
import com.example.practice_config.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("validate")
    public ResponseEntity<DepartmentDto> validateDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        departmentService.getDepartmentDto(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
