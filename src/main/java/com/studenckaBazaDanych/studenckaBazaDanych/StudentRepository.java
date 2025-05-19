package com.studenckaBazaDanych.studenckaBazaDanych;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {
}
