package com.example.demo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private String title;
    private String detail;
}
