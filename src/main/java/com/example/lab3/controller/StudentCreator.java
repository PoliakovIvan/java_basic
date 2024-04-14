package com.example.lab3.controller;

import com.example.lab3.model.Student;
import com.example.lab3.model.Sex;
import com.example.lab3.model.Group;
import com.example.lab3.model.Department;
import com.example.lab3.model.Faculty;
import com.example.lab3.model.University;



public abstract class StudentCreator {
    public static Student create(String name, String surname, String fatherName, Sex sex) {
        return new Student(name, surname, fatherName, sex);
    }

    public static Student create(String name, String surname, String fatherName, Sex sex, Group group, Department department, Faculty faculty, University university) {
        return new Student(name, surname, fatherName, sex, group, department, faculty, university);
    }
}
