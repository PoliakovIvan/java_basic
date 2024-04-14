package com.example.lab3;

import com.example.lab3.controller.*;
import com.example.lab3.model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
    }

    public static University createTypicalUniversity() {
        Student student_1 = StudentCreator.create("Ivan", "Poliakov", "Igorovich", Sex.MAN);
        Student student_2 = StudentCreator.create("Emily", "Johnson", "Anne", Sex.WOMAN);
        Student student_3 = StudentCreator.create("John", "Williams", "Michael", Sex.MAN);

        Student[] students = {student_1, student_2, student_3};
                Group group = GroupCreator.create("125-20-1", "David", "Robinson", "George", Sex.MAN, students);

        Group[] groups = {group};
        Department department = DepartmentCreator.create("Department of Computer Science and Engineering", "Sarah", "Thompson", "Elizabeth", Sex.WOMAN, groups);

        Department[] departments = {department};
        Faculty faculty = FacultyCreator.create("Faculty of Information Technology", "Matthew", "Davis", "Robert", Sex.MAN, departments);

        Faculty[] faculties = {faculty};
        University university = UniversityCreator.create("National Technical University Dnipro Polytechnic", "Christopher","Johnson","Andrew", Sex.MAN, faculties);

        return university;
    }
}