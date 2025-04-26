package com.pluralsight.views;
import com.pluralsight.models.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerView {
    Scanner ledgerScanner = new Scanner(System.in);

    // Save all current transactions in ArrayList for access by reports
    ArrayList<Transaction> transactionHistory = new ArrayList<>();

    // Init ReportView instance
    ReportView reportView = new ReportView(transactionHistory);

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

        createTransactionList();
        boolean ledgerRunning = true;

        while (ledgerRunning) {
            System.out.println("\nPlease make a selection from the following options");
            System.out.println("Use the letters in brackets and hit enter to make a selection");
            System.out.println("[A]    Display All Transactions");
            System.out.println("[D]    Display All Deposits");
            System.out.println("[P]    Display All Payments");
            System.out.println("[R]    See Reports Menu");
            System.out.println("[X]    Return to the Home Screen");
            System.out.println();
            System.out.println("Enter your selection now:    ");
            String optionSelection = ledgerScanner.nextLine();

            if (optionSelection.equalsIgnoreCase("X")) {
                System.out.println("Leaving the Ledger menu - returning to the Home Screen");
                ledgerRunning = false;
            } else {
                switch (optionSelection.toUpperCase()) {
                    case "A":
                        showAllTransactions(transactionHistory);
                        // System.out.println("View all transactions - most recent first");
                        break;
                    case "D":
//                        System.out.println("View the deposit transactions");
                        showAllDeposits(transactionHistory);
                        break;
                    case "P":
//                        System.out.println("View the payment transactions");
                        showAllPayments(transactionHistory);
                        break;
                    case "R":
//                        System.out.println("View the reports menu");
                        reportView.reportMenu(transactionHistory);
                        break;
                    default:
                        System.out.println("Invalid choice - please enter again");
                        break;
                }
            }
        }
    }

    // Retrieve all transactions from transactions.csv file
    public void createTransactionList() {
    //        ArrayList<String> fromCSVfile = new ArrayList<>();

        String fileName = "transactions.csv";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fileReader)) {
            // System.out.println("In File reader method");
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line); // prints out each line from the csv file

                // Create a Transaction object from line
                // public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount)
                String [] lineData = line.split("\\|");

                // Java Enhanced for loop
                // for (String item: lineData) {
                //    System.out.println(item);
                // }

                Transaction transaction = new Transaction();

                transaction.setDate(LocalDate.parse(lineData[0]));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                transaction.setTime(LocalTime.parse(lineData[1], formatter));

                transaction.setDescription(lineData[2]);
                transaction.setVendor(lineData[3]);
                transaction.setAmount(Double.parseDouble(lineData[4]));

                transactionHistory.add(transaction);
                // System.out.println(transaction);
            }
        } catch (IOException ioException) {
            ioException.getLocalizedMessage();
            System.out.println("Error reading file - please try again");
        }

        //        return fromCSVfile;
    }

    public static void showAllTransactions(ArrayList<Transaction> transactionHistory) {
        System.out.println();
        System.out.println("================================");
        System.out.println("||  LIST OF ALL TRANSACTIONS  ||");
        System.out.println("================================");
        System.out.println();

        for (int index = transactionHistory.size() - 1; index >= 0; index--) {
            Transaction currentEntry = transactionHistory.get(index);
            createAndPrintEntry(currentEntry);
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("||   END OF TRANSACTION LIST  ||");
        System.out.println("================================");
        System.out.println();
    }

    public static void showAllDeposits(ArrayList<Transaction> transactionHistory) {
        System.out.println();
        System.out.println("================================");
        System.out.println("||    LIST OF ALL DEPOSITS    ||");
        System.out.println("================================");
        System.out.println();

        for (int index = transactionHistory.size() - 1; index >= 0; index--) {
            if (transactionHistory.get(index).getAmount() > 0) {
                Transaction currentEntry = transactionHistory.get(index);
                createAndPrintEntry(currentEntry);
            }
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("||     END OF DEPOSIT LIST    ||");
        System.out.println("================================");
        System.out.println();
    }

    public static void showAllPayments(ArrayList<Transaction> transactionHistory) {
        System.out.println();
        System.out.println("================================");
        System.out.println("||    LIST OF ALL PAYMENTS    ||");
        System.out.println("================================");
        System.out.println();

        for (int index = transactionHistory.size() - 1; index >= 0; index--) {
            if (transactionHistory.get(index).getAmount() < 0) {
                Transaction currentEntry = transactionHistory.get(index);
                createAndPrintEntry(currentEntry);
            }
        }

        System.out.println();
        System.out.println("================================");
        System.out.println("||     END OF PAYMENT LIST    ||");
        System.out.println("================================");
        System.out.println();
    }

    public static void createAndPrintEntry(Transaction currentEntry) {
        String transaction = String.format("%s|%s|%s|%s|%s",
                currentEntry.getDate(),
                currentEntry.getTime(),
                currentEntry.getDescription(),
                currentEntry.getDescription(),
                currentEntry.getAmount()
        );
        System.out.println(transaction);
    }
}
