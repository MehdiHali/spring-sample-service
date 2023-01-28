package com.hali.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner cmdRunner(StudentRepository studentRepo){
        return args->{

            Student mehdi = new Student(
                "mehdi",
                "mehdi.ouledhali@gmail.com",
                LocalDate.of(2001, 6, 26));

            Student noor = new Student(
                "noor",
                "noorhali@gmail.com",
                LocalDate.of(2021, 6,26));

            Student hossam = new Student(
                "hossam",
                "hossam@gmail.com",
                 LocalDate.of(2011, 6,26));

            Student saad = new Student(
                "saad",
                "saad@gmail.com",
                 LocalDate.of(1998, 6,26));

            studentRepo.saveAll(List.of(mehdi,hossam,noor,saad));

            };
    };
}
