package com.studenckaBazaDanych.studenckaBazaDanych;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/subpages/adminPanel.html";
    }

    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "adminPanel";
    }
}
