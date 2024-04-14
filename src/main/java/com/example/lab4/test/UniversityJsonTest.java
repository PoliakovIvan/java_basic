package src.main.java.com.example.lab4.test;

import src.main.java.com.example.lab4.JsonManager;
import src.main.java.com.example.lab4.controller.UniversityCreator;
import src.main.java.com.example.lab4.model.University;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UniversityJsonTest {
    @Test
    public void testUniversitySerialization() {
        String filePath = ".src/main/java/com/example/lab4/university.json";

        JsonManager jsonManager = new JsonManager();
        UniversityCreator universityCreator = new UniversityCreator();
        University oldUniversity = universityCreator.createTypicalUniversity();

        jsonManager.writeToJson(oldUniversity, filePath);
        University newUniversity = (University) jsonManager.readFromJson(filePath);

        assertEquals(newUniversity, oldUniversity);
    }
}
