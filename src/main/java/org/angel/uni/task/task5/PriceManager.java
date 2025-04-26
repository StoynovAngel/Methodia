package org.angel.uni.task.task5;

import org.angel.uni.task.mapper.CSVConverter;

import java.util.ArrayList;
import java.util.List;

public class PriceManager {

    public static void saveAveragePriceToCSV() {
        List<String[]> rows = CSVConverter.getContentFromCSV();
        List<Integer> prices = new ArrayList<>();
        double sum = 0;
        int price;

        try {
            for (int i = 1; i < rows.size(); i++) {
                price = Integer.parseInt(rows.get(i)[0]);
                prices.add(price);
                sum += price;
            }
        } catch (NumberFormatException e) {
            System.out.println("String cannot be converted to integer. " + e.getMessage());
            return;
        }
        System.out.println(prices);
        CSVConverter.writeContentToCSV(sum / prices.size());
    }
}
