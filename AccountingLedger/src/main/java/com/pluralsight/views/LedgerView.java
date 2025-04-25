package com.pluralsight.views;
import com.pluralsight.models.Transaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerView {
    Scanner ledgerScanner = new Scanner(System.in);

    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    // Ledger Menu
    //    A) All - Display all entries
    //    o D) Deposits - Display only the entries that are deposits into the
    //            account
    //    o P) Payments - Display only the negative entries (or payments)
    //    o R) Reports - A new screen that allows the user to run pre-defined
    //    reports or to run a custom search

    public void ledgerMenu () {
        System.out.println();
        System.out.println("===================");
        System.out.println("||  LEDGER MENU  ||");
        System.out.println("===================");
        System.out.println();

        System.out.println("\nPlease make a selection from the following options");
        System.out.println("Use the letters in brackets and hit enter to make a selection");
        System.out.println("[A]    Display All Transactions");
        System.out.println("[D]    Display All Deposits");
        System.out.println("[P]    Display All Payments");
        System.out.println("[R]    See Reports");
        System.out.println("[X]    Return to the Home Screen");
        System.out.println();
        System.out.println("Enter your selection now:    ");

        String optionSelection = ledgerScanner.nextLine();
        boolean ledgerRunning = true;

        while (ledgerRunning) {
            if (optionSelection.equalsIgnoreCase("X")) {
                System.out.println("Exit the reports menu - back to the HomeView");
                ledgerRunning = false;
            } else {
                switch (optionSelection.toUpperCase()) {
                    case "A":
                        System.out.println("View all transactions - most recent first");
                        break;
                    case "D":
                        System.out.println("View the deposit transactions");
                        break;
                    case "P":
                        System.out.println("View the payment transactions");
                        break;
                    case "R":
                        System.out.println("View the reports menu");
                        break;
                    default:
                        System.out.println("Invalid choice - please enter again");
                        break;
                }
            }
        }
    }

    // Retrieve all transactions from transactions.csv file
    public ArrayList<String> getAllTransactions() {
        ArrayList<String> fromCSVfile = new ArrayList<>();
        String fileName = "transactions.csv";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fileReader)) {
            System.out.println("In File reader method");
        } catch (IOException ioException) {
            ioException.getLocalizedMessage();
            System.out.println("Error reading file - please try again");
        }
        return fromCSVfile;
    }
}
