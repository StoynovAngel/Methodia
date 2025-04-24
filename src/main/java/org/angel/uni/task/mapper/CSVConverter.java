package org.angel.uni.task.mapper;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {

    private static final String PATH = "src/main/java/org/angel/uni/task/files/prices.csv";

    public static List<String[]> getContentFromCSV() {
        try (Reader reader = Files.newBufferedReader(Path.of(PATH))) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            } catch (CsvException e) {
                System.out.println("Unexpected error happened in CsvReader: " + e.getMessage());
                return new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
