package com.studenckaBazaDanych.studenckaBazaDanych;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDefaultData(
            UserRepository userRepository,
            StudentRepository studentRepository
    ) {
        return args -> {
            // Tworzenie domyślnego użytkownika
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User(null, "admin", "admin");
                userRepository.save(admin);
                System.out.println("Utworzono użytkownika admin/admin");
            }

            // Tworzenie domyślnych studentów
            if (studentRepository.count() == 0) {
                studentRepository.save(new Student("Jan", "Kowalski", "ul. Lipowa 12", "jan.kowalski@example.com", "+48 123 456 789"));
                studentRepository.save(new Student("Anna", "Nowak", "ul. Kwiatowa 5", "anna.nowak@example.com", "+48 987 654 321"));
                studentRepository.save(new Student("Piotr", "Wiśniewski", "ul. Szkolna 7", "piotr.wisniewski@example.com", "+48 777 888 999"));
                studentRepository.save(new Student("Jakub", "Malina", "ul. Kwarcowa 52", "jakub.malina@example.com", "+48 727 618 009"));
                studentRepository.save(new Student("Anna", "Nowak", "ul. Słoneczna 14", "anna.nowak@example.com", "+48 512 345 678"));

                System.out.println("Dodano 5 domyślnych studentów");
            }
        };
    }
}