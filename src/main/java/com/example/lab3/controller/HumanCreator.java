package com.example.lab3.controller;

import com.example.lab3.model.Human;
import com.example.lab3.model.Sex;

public abstract class HumanCreator {
    public static Human create(String name, String surname, String fatherName, Sex sex) {
        return new Human(name, surname, fatherName, sex);
    }
}
