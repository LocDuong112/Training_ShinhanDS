package com.example.practice_config.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long departmentId;

    @NotBlank
    @Size(min = 10, max = 50)
    private String deptName;

    @NotBlank
    private String description;

    @Valid
    private List<EmployeeDto> employeeDtoList;
}
