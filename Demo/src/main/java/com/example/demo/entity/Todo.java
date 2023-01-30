package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TODO")
@Setter
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "detail")
    private String detail;
}
