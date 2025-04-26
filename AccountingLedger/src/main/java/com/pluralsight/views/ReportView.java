package com.pluralsight.views;

import com.pluralsight.App;
import com.pluralsight.models.Transaction;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportView {
    // init transactionList variable for class
    ArrayList<Transaction> transactionList;

    // init HomeView to return to main screen
    String[] args;

    // init Scanner reportScanner
    Scanner reportScanner = new Scanner(System.in);

    // Constructor
    public ReportView (ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    // Report Menu
    public void reportMenu (ArrayList<Transaction> transactionHistory) {
        System.out.println();
        System.out.println("===================");
        System.out.println("||  REPORTS MENU  ||");
        System.out.println("===================");
        System.out.println();

        // Report Menu Options
        // 1) Month To Date
        // 2) Previous Month
        // 3) Year To Date
        // 4) Previous Year
        // 5) Search by Vendor - prompt the user
        // 0) Back - go back to the report page
        // H) Home - go back to the home page
        boolean reportsRunning = true;

        while (reportsRunning) {
            System.out.println("\nPlease make a selection from the following options");
            System.out.println("Use the numbers or letter in brackets and hit enter to make a selection");
            System.out.println("[1]    Show the Month To Date");
            System.out.println("[2]    Show the Previous Month");
            System.out.println("[3]    Show Year To Date");
            System.out.println("[4]    Show Previous Year");
            System.out.println("[5]    Search by Vendor");
            System.out.println("[0]    Return to the Ledger Menu");
            System.out.println("[H]    Return to the Home Screen");

            System.out.println();
            System.out.println("Enter your selection now:    ");
            String optionSelection = reportScanner.nextLine();

            if (optionSelection.equalsIgnoreCase("0")) {
                System.out.println("Returning to the Ledger menu");
                reportsRunning = false;
            } else if (optionSelection.equalsIgnoreCase("h")) {
                System.out.println("Returning to the Home Screen");
                App.main(args);
            } else {
                switch (optionSelection.toUpperCase()) {
                    case "1":
                        System.out.println("Month to Date Report");
                        monthToDateReport();
                        break;
                    case "2":
                        System.out.println("Previous Month Report");
                        previousMonthReport();
                        break;
                    case "3":
                        System.out.println("Year to Date Report");
                        yearToDateReport();
                        break;
                    case "4":
                        System.out.println("Previous Year Report");
                        previousYearReport();
                        break;
                    case "5":
                        System.out.println("Search by Vendor Report");
                        searchByVendorReport();
                        break;
                    default:
                        System.out.println("Invalid choice - please enter again");
                        break;
                }
            }
        }
    }

    public void monthToDateReport() {
        // get the current month
        Month thisMonth = LocalDate.now().getMonth();

        // Report Title Screen
        System.out.println();
        System.out.println("================================");
        System.out.println("||    MONTH TO DATE REPORT    ||");
        System.out.println("================================");
        System.out.println();

        // iterate through the transactions to find transactions with the same month
        for (var index = this.transactionList.size() - 1; index >= 0; index--) {
            Transaction currentTransaction = this.transactionList.get(index);

            // print if thisMonth == currentEntry month
            if (currentTransaction.getDate().getMonth() == thisMonth) {
                createAndPrintEntry(currentTransaction);
            }
        }

        // Report End Screen
        System.out.println();
        System.out.println("========================================");
        System.out.println("||     END OF MONTH TO DATE REPORT    ||");
        System.out.println("========================================");
        System.out.println();
    }

    public void previousMonthReport() {
        // get the current month
        Month lastMonth = LocalDate.now().minusMonths(1).getMonth();

        // Report Title Screen
        System.out.println();
        System.out.println("=================================");
        System.out.println("||    PREVIOUS MONTH REPORT    ||");
        System.out.println("=================================");
        System.out.println();

        // iterate through the transactions to find transactions with the same month
        for (var index = this.transactionList.size() - 1; index >= 0; index--) {
            Transaction currentTransaction = this.transactionList.get(index);

            // print if thisMonth == currentEntry month
            if (currentTransaction.getDate().getMonth() == lastMonth) {
                createAndPrintEntry(currentTransaction);
            }
        }

        // Report End Screen
        System.out.println();
        System.out.println("=========================================");
        System.out.println("||     END OF PREVIOUS MONTH REPORT    ||");
        System.out.println("=========================================");
        System.out.println();
    }

    public void yearToDateReport() {
        // get the current month
        int thisYear = LocalDate.now().getYear();

        // Report Title Screen
        System.out.println();
        System.out.println("=================================");
        System.out.println("||     YEAR TO DATE REPORT     ||");
        System.out.println("=================================");
        System.out.println();

        // iterate through the transactions to find transactions with the same month
        for (var index = this.transactionList.size() - 1; index >= 0; index--) {
            Transaction currentTransaction = this.transactionList.get(index);

            // print if thisMonth == currentEntry month
            if (currentTransaction.getDate().getYear() == thisYear) {
                createAndPrintEntry(currentTransaction);
            }
        }

        // Report End Screen
        System.out.println();
        System.out.println("=========================================");
        System.out.println("||      END OF YEAR TO DATE REPORT     ||");
        System.out.println("=========================================");
        System.out.println();
    }

    public void previousYearReport() {
        // get the current month
        int lastYear = LocalDate.now().minusYears(1).getYear();

        // Report Title Screen
        System.out.println();
        System.out.println("=================================");
        System.out.println("||     PREVIOUS YEAR REPORT    ||");
        System.out.println("=================================");
        System.out.println();

        // iterate through the transactions to find transactions with the same month
        for (var index = this.transactionList.size() - 1; index >= 0; index--) {
            Transaction currentTransaction = this.transactionList.get(index);

            // print if thisMonth == currentEntry month
            if (currentTransaction.getDate().getYear() == lastYear) {
                createAndPrintEntry(currentTransaction);
            }
        }

        // Report End Screen
        System.out.println();
        System.out.println("=========================================");
        System.out.println("||     END OF PREVIOUS YEAR REPORT     ||");
        System.out.println("=========================================");
        System.out.println();
    }

    public void searchByVendorReport() {
        // prompt the user to enter the vendor they are looking for
        System.out.println("What vendor are you searching for today?    ");
        String vendorName = reportScanner.nextLine();

        // Report Title Screen
        System.out.println();
        System.out.println("====================================");
        System.out.println("||     SEARCH BY VENDOR REPORT    ||");
        System.out.println("====================================");
        System.out.println();

        // iterate through the transaction list to find matches to the user vendor name - most recent first
        for (var index = this.transactionList.size() - 1; index >= 0; index--) {
            Transaction currentEntry = this.transactionList.get(index);
            if (currentEntry.getVendor().equalsIgnoreCase(vendorName)) {
                createAndPrintEntry(currentEntry);
            }
        }

        // Report End Screen
        System.out.println();
        System.out.println("=========================================");
        System.out.println("||    END OF SEARCH BY VENDOR REPORT   ||");
        System.out.println("=========================================");
        System.out.println();
    }

    public static void createAndPrintEntry(Transaction currentEntry) {
        String transaction = String.format("%s|%s|%s|%s|%s",
                currentEntry.getDate(),
                currentEntry.getTime(),
                currentEntry.getDescription(),
                currentEntry.getVendor(),
                currentEntry.getAmount()
        );
        System.out.println(transaction);
    }
}
