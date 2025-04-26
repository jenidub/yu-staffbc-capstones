package com.pluralsight;

import com.pluralsight.views.HomeView;
import com.pluralsight.views.LedgerView;

import java.util.Scanner;

public class App {
    // init Scanner for user input
    static Scanner user_input = new Scanner(System.in);

    // init HomeView for
    static HomeView homeView = new HomeView();
    static LedgerView ledgerView = new LedgerView();

    public static void main(String[] args) {
        // Introduction Screen
        displayHomeScreen();

        // Init instance of UserInterface
        // UserInterface app = new UserInterface();
        // UserInterfaceBasic app = new UserInterfaceBasic();

        // while loop - keep showing the user the options until they exit the program
        while (true) {
            displayUserOptions();
            String user_selection = user_input.nextLine();
            if (user_selection.equalsIgnoreCase("X")) {
                break;
            } else {
                switch(user_selection.toUpperCase()) {
                    case "D":
                        homeView.addDeposit();
                        break;
                    case "P":
                        homeView.addPayment();
                        break;
                    case "L":
                        ledgerView.ledgerMenu();
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
