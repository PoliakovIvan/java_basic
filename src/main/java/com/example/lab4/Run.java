package src.main.java.com.example.lab4;

import src.main.java.com.example.lab4.controller.UniversityCreator;
import src.main.java.com.example.lab4.model.University;

public class Run {
    public static void main(String[] args) {
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createTypicalUniversity();

        System.out.println(university.toString());
    }
}
