package org.angel.uni.task.mapper;

import com.google.gson.Gson;
import org.angel.uni.task.wrapper.DataWrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class GsonConverter {

    private static final String PATH = "src/main/java/org/angel/uni/task/files/data.json";

    public static DataWrapper getContentFromJson() {
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                throw new FileNotFoundException("No such file found");
            }
            String content = new String(Files.readAllBytes(file.toPath()));
            Gson gson = new Gson();

            return gson.fromJson(content, DataWrapper.class);
        } catch (IOException e) {
            System.out.println("Unexpected error, occurred: " + e.getMessage());
            return new DataWrapper();
        }
    }
}