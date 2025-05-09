package com.pluralsight.views;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    public UserInterface () {

    }

    public void addDeposit() {
        // init Scanner for user input
        Scanner user_input = new Scanner(System.in);

        // init StringBuilder to match the entry format as the info comes in
        // StringBuilder entry = new StringBuilder();

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00

        //        user enters description
        System.out.println("Please write a short description of the deposit:    ");
        String depositDescription = user_input.nextLine().trim();

        //        // user enter vendor
        System.out.println("Who is the vendor associated with the deposit?    ");
        String depositVendor = user_input.nextLine().trim();

        //        // user enters amount - check that it's positive
        System.out.println("What is the amount of the deposit? (example: ####.## - only positive values)   ");
        String depositAmount = user_input.nextLine().trim();

        //        // Build string based on the variables above
        //        String entry = createEntry(depositDescription, depositVendor, depositAmount);

        // Create the entry for a deposit type
        String entry = createEntry("deposit");

        // Show success message once the entry is created
        System.out.println("You have completed your deposit entry");
        System.out.println("Here is a copy of the deposit entry:   " + entry);

        //Write the entry into transactions.csv
    }

    public void addPayment() {
        // init Scanner for user input
         Scanner user_input = new Scanner(System.in);

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50

        // user enters description
        System.out.println("Please write a short description of the payment:    ");
        String paymentDescription = user_input.nextLine().trim();

        // user enter vendor
        System.out.println("Who is the vendor associated with the payment?    ");
        String paymentVendor = user_input.nextLine().trim();

        // user enters amount - check that it's positive
        System.out.println("What is the amount of the payment? (example: -####.## - only negative values)   ");
        String paymentAmount = user_input.nextLine().trim();

        // Create the entry for a payment type
        String entry = createEntry("payment");

        //Add the entry to the ledger
        System.out.println("You have completed your payment entry");
        System.out.println("Here is a copy of the payment entry:   " + entry);

        //Write the entry into transactions.csv
    }

    private String generateFormattedDateTime() {
        // use .now() for date and time with required format then append to entry variable
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFormatted = LocalDate.now().format(dateFormat);

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = LocalTime.now().format(timeFormat);

        return String.format("%s|%s", dateFormatted, timeFormatted);
    }

    private String createEntry(String transactionType) {
        Scanner user_input = new Scanner(System.in);
        String entryType = transactionType.equals("deposit") ? "positive" : "negative";

        // Get date and time formatted
        String dateTime = generateFormattedDateTime();

        // user enters description
        System.out.printf("Please write a short description of the %s:    ", transactionType);
        String description = user_input.nextLine().trim();
        System.out.println();

        // user enter vendor
        System.out.printf("Who is the vendor associated with the %s?    ", transactionType);
        String vendor = user_input.nextLine().trim();
        System.out.println();

        // user enters amount - check that it's positive
        System.out.printf("What is the amount of the %s? (example: ####.## - only %s values)   ", transactionType, entryType);
        String amount = user_input.nextLine().trim();
        System.out.println();

        return String.format("%s|%s|%s|%s",
                dateTime,
                description,
                vendor,
                amount
        );
    }
}
