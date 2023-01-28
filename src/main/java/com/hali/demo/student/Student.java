package com.hali.demo.student;

import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table
public class Student {


    @Id
    @SequenceGenerator(
        name= "student_sequence",
        sequenceName= "student_sequence",
        allocationSize= 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator= "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    @Transient
    private int age;
    private LocalDate dob;

    public Student(){

    }
    public Student( String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", dob=" + dob + "]";
    } 
    
}
