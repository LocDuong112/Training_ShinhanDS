package com.example.practice_config.service.impl;

import com.example.practice_config.dto.EmployeeDto;
import com.example.practice_config.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) throws Exception {
        logger.info("In employee service " + employeeDto.toString());

        if (employeeDto.getName().equals("virus")) {
            throw new Exception("This is a virus");
        }

        return employeeDto;
    }
}
