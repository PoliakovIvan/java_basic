import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class JsonManager {

    public void writeToJson(Object object, String filePath) {
        Gson gson = new Gson();
        String json = gson.toJson(object);

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
            System.out.println("Successfully wrote to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
        }
    }

    public Object readFromJson(String filePath, Class<?> objectType) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, objectType);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + filePath);
            e.printStackTrace();
        }

        return null;
    }
}
