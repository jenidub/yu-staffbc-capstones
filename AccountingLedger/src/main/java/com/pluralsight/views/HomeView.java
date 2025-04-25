package com.pluralsight.views;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomeView {
    Scanner homeScanner = new Scanner(System.in);

    // Constructor definition
    public HomeView () {}

    // Class Methods
    public void addDeposit() {
        // init Scanner for user input
        // Scanner user_input = new Scanner(System.in);

        // init StringBuilder to match the entry format as the info comes in
        StringBuilder entry = new StringBuilder();

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00\

        // use .now() for date and time with required format then append to entry variable
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFormatted = LocalDate.now().format(dateFormat);
        entry.append(dateFormatted);
        entry.append("|");

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = LocalTime.now().format(timeFormat);
        entry.append(timeFormatted);
        entry.append("|");

        // user enters description
        System.out.println("Please write a short description of the deposit:    ");
        String depositDescription = homeScanner.nextLine().trim();
        entry.append(depositDescription);
        entry.append("|");

        // user enter vendor
        System.out.println("Who is the vendor associated with the deposit?    ");
        String depositVendor = homeScanner.nextLine().trim();
        entry.append(depositVendor);
        entry.append("|");

        // user enters amount - check that it's positive
        System.out.println("What is the amount of the deposit? (example: ####.## - only positive values)   ");
        String depositAmount = homeScanner.nextLine().trim();
        entry.append(depositAmount);

        //Write the entry into transactions.csv
        if (saveTransaction(String.valueOf(entry))) {
            // Show success message if entry was successful
            System.out.println("\n***********\n");
            System.out.println("You have completed your deposit entry!\n");
            System.out.println("Here are your transaction details:");
            System.out.println(entry);
            System.out.println("\n ==== Now returning to home screen... ==== ");
            System.out.println();
        } else {
            // Show error message if entry was successful
            System.out.println("***********\n");
            System.out.println("Something went wrong with the deposit entry");
            System.out.println("Please try again");
            System.out.println("\n***********");
            System.out.println("\n ==== Now returning to home screen... ==== ");
        }
    }

    public void addPayment() {
        // init Scanner for user input
        // Scanner user_input = new Scanner(System.in);

        // init StringBuilder to match the entry format as the info comes in
        StringBuilder entry = new StringBuilder();

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50

        // use .now() for date and time with required format then append to entry variable
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFormatted = LocalDate.now().format(dateFormat);
        entry.append(dateFormatted);
        entry.append("|");

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = LocalTime.now().format(timeFormat);
        entry.append(timeFormatted);
        entry.append("|");

        // user enters description
        System.out.println("Please write a short description of the payment:    ");
        String paymentDescription = homeScanner.nextLine().trim();
        entry.append(paymentDescription);
        entry.append("|");

        // user enter vendor
        System.out.println("Who is the vendor associated with the payment?    ");
        String paymentVendor = homeScanner.nextLine().trim();
        entry.append(paymentVendor);
        entry.append("|");

        // user enters amount - check that it's positive
        System.out.println("What is the amount of the payment? (example: ####.## - only negative values)   ");
        String paymentAmount = homeScanner.nextLine().trim();
        entry.append(paymentAmount);

        //Add the entry to the ledger
        System.out.println("You have completed your payment entry");
        System.out.println("Here is a copy of the payment entry:   " + entry);

        //Write the entry into transactions.csv
        boolean success = saveTransaction(String.valueOf(entry));
    }

    // saveTransaction() method - write the transaction to given csv file
    public boolean saveTransaction(String transaction) {
        String fileName = "transactions.csv";
        try (
            // list of resources used - does not require close() at the end
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            // logic of the try() block
            bufferedWriter.write(transaction + "\n");
            return true;
        } catch (IOException error) {
            System.out.println(error.getLocalizedMessage());
            return false;
        }
    }
}
