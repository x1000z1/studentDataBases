package com.studenckaBazaDanych.studenckaBazaDanych;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NonNull
    private String email;
    @NonNull
    private String telephone;
}