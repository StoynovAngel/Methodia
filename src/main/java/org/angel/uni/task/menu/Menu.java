package org.angel.uni.task.menu;

import org.angel.uni.task.task1.ReverseString;
import org.angel.uni.task.task2.WordCounter;
import org.angel.uni.task.task3.Performance;
import org.angel.uni.task.task4.Duplicate;
import org.angel.uni.task.task5.PriceManager;
import org.angel.uni.task.menu.MenuConstants;

import java.util.Scanner;

public class Menu {

    private Scanner in = new Scanner(System.in);

    public void run() {
        switchCases();
    }

    private void switchCases() {
        while(true) {
            System.out.println("======".repeat(30));
            System.out.println("""
                    0. Exit
                    1. Reverse String
                    2. Words counter
                    3. Performance
                    4. Duplicate
                    5. Excel
                    """);
            int choice = userChoice();
            System.out.println("======".repeat(30));
            switch (choice) {
                case MenuConstants.REVERSE_STRING: {
                    ReverseString.reverseString();
                    break;
                }
                case MenuConstants.WORDS_COUNTER: {
                    WordCounter.wordCounterWithMap();
                    break;
                }
                case MenuConstants.PERFORMANCE: {
                    Performance.displayAll();
                    break;
                }
                case MenuConstants.DUPLICATE: {
                    Duplicate.findDuplicateCharacters();
                    break;
                }
                case MenuConstants.EXCEL: {
                    PriceManager.saveAveragePriceToCSV();
                    break;
                }
                case MenuConstants.EXIT: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private int userChoice() {
        System.out.print("Choose between 0-5: ");
        return in.nextInt();
    }
}
