package org.angel.uni.task.mapper;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {

    private static final String PATH = "prices.csv";
    private static final String OUTPUT_PATH = "output_average.csv";

    public static List<String[]> getContentFromCSV() {
        try (InputStream inputStream = GsonConverter.class.getClassLoader().getResourceAsStream(PATH)) {
            if (inputStream == null) {
                System.out.println("File not found: " + PATH);
                return new ArrayList<>();
            }

            try (CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {
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

    public static void writeContentToCSV(double average) {
        File file = new File(OUTPUT_PATH);

        try (FileWriter writer = new FileWriter(file);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            String[] headers = {"average_price"};
            csvWriter.writeNext(headers);

            csvWriter.writeNext(new String[]{String.valueOf(average)});

        } catch (IOException e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number format exception occurred when reading the average price: " + e.getMessage());
        }
    }
}
