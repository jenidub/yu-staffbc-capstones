package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // VARIABLE DEFINITIONS
        // Init new scanner for user input
        Scanner user_input = new Scanner(System.in);

        // Introduction Screen
        displayHomeScreen();

        // while loop - keep showing the user the options until they exit the program
        while (true) {
            displayUserOptions();
            String user_selection = user_input.nextLine();
            if (user_selection.equalsIgnoreCase("X")) {
                break;
            } else {
                switch(user_selection.toUpperCase()) {
                    case "D":
                        System.out.println("You would like to make a deposit");
                        break;
                    case "P":
                        System.out.println("You would like to make a payment");
                        break;
                    case "L":
                        System.out.println("Here is the ledger to date:");
                        break;
                    default:
                        System.out.println("Invalid choice - please enter again");
                        break;
                }
            }
        };

        // End of program thank you message
        System.out.println("Thank you for using the Accounting Ledger app - Have a great day!");
    }

    public static void displayHomeScreen() {
        System.out.println("The Mighty Accounting Ledger by JeniDubTech");
        System.out.println();
        System.out.println("***************");
        System.out.println("MAIN MENU");
        System.out.println("***************");
        System.out.println();
    }

    public static void displayUserOptions() {
        // AVAILABLE OPTIONS
        //  D) Add Deposit - prompt user for the deposit information and save it to the csv file
        //  P) Make Payment (Debit) - prompt user for the debit information and save it to the csv file
        //  L) Ledger - display the ledger screen
        //  X) Exit - exit the application
        System.out.println("\nPlease make a selection from the following options");
        System.out.println("Use the letters in brackets and hit enter to make a selection");
        System.out.println("[D]    Add Deposit");
        System.out.println("[P]    Make a Payment");
        System.out.println("[L]    Display the Ledger Screen");
        System.out.println("[X]    Exit the App");
        System.out.println();
        System.out.println("Enter your selection now:    ");
    }

}
