package com.example.lab3.controller;

import com.example.lab3.model.Sex;
import com.example.lab3.model.Faculty;
import com.example.lab3.model.University;

public abstract class UniversityCreator {
    public static University create(String universityName, String headmasterName, String headmasterSurname, String headmasterFatherName, Sex headmasterSex) {
        return new University(
            universityName,
            HumanCreator.create(headmasterName, headmasterSurname, headmasterFatherName,headmasterSex)
        );
    }

    public static University create(String universityName, String headmasterName, String headmasterSurname, String headmasterFatherName, Sex headmasterSex, Faculty[] faculties) {
        return new University(
            universityName,
            HumanCreator.create(headmasterName, headmasterSurname, headmasterFatherName, headmasterSex),
            faculties
        );
    }
}
