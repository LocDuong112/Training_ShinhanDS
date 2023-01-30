package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PERSON")
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Full_Name", length = 64, nullable = false)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Of_Birth", nullable = false)
    private Date dateOfBirth;

}
