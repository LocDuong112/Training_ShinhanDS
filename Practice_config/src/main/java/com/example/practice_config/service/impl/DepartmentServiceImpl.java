package com.example.practice_config.service.impl;

import com.example.practice_config.dto.DepartmentDto;
import com.example.practice_config.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Override
    public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
        logger.info("In department service " + departmentDto.toString());
        return departmentDto;
    }
}
