package org.angel.uni.task.mapper;

import com.google.gson.Gson;
import org.angel.uni.task.wrapper.DataWrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class GsonConverter {

    private static final String PATH = "data.json";

    public static DataWrapper getContentFromJson() {
        try (InputStream inputStream = GsonConverter.class.getClassLoader().getResourceAsStream(PATH)) {
            if (inputStream == null) {
                System.out.println("File not found: " + PATH);
                return new DataWrapper();
            }

            String content = new String(inputStream.readAllBytes());
            Gson gson = new Gson();

            return gson.fromJson(content, DataWrapper.class);
        } catch (IOException e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            return new DataWrapper();
        }
    }
}