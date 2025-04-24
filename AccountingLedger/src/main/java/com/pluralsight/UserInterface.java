package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
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
        StringBuilder entry = new StringBuilder();

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00

        // use .now() for date and time with required format then append to entry variable
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String depositDateFormatted = LocalDate.now().format(dateFormat);
        entry.append(depositDateFormatted + "|");

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String depositTimeFormatted = LocalTime.now().format(timeFormat);
        entry.append(depositTimeFormatted + "|");

        // user enters description
        System.out.println("Please write a short description of the deposit:    ");
        String depositDescription = user_input.nextLine().trim();
        entry.append(depositDescription + "|");

        // user enter vendor
        System.out.println("Who is the vendor associated with the deposit?    ");
        String depositVendor = user_input.nextLine().trim();
        entry.append(depositVendor + "|");

        // user enters amount - check that it's positive
        System.out.println("What is the amount of the deposit? (example: ####.## - only positive values)   ");

        String depositAmount = user_input.nextLine().trim();
        entry.append(depositAmount + "|");

        //Add the entry to the ledger
        System.out.println("final entry:    " + entry);

        //Write the entry into transactions.csv
    }

    public void addPayment() {
        // init Scanner for user input
        Scanner user_input = new Scanner(System.in);

        // entry format: date|time|description|vendor|amount
        // deposit example: 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50

        // use .now() for date and time with required format then append to entry variable
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String depositDateFormatted = LocalDate.now().format(dateFormat);

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String depositTimeFormatted = LocalTime.now().format(timeFormat);

        // user enters description
        System.out.println("Please write a short description of the payment:    ");
        String paymentDescription = user_input.nextLine().trim();

        // user enter vendor
        System.out.println("Who is the vendor associated with the payment?    ");
        String paymentVendor = user_input.nextLine().trim();

        // user enters amount - check that it's positive
        System.out.println("What is the amount of the payment? (example: -####.## - only negative values)   ");
        String paymentAmount = user_input.nextLine().trim();

        // Build string based on the variables above
        String entry = String.format("%s|%s|%s|%s|%s",
                depositDateFormatted,
                depositTimeFormatted,
                paymentDescription,
                paymentVendor,
                paymentAmount
        );

        System.out.println("entry:  " + entry);

        //Add the entry to the ledger
        System.out.println("You have completed your payment entry");
        System.out.println("Here is a copy of the payment entry:   " + entry);

        //Write the entry into transactions.csv
    }

}
