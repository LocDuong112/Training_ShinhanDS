package com.example.practice_config.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long employeeId;

    @NotBlank
    @Size(min = 5, max = 10)
    private String name;

    private String birthDate;
    private boolean gender;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com$", message = "wrong email")
    @NotBlank
    private String email;
}
