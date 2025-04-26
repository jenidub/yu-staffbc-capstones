//package com.pluralsight;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner user_input = new Scanner(System.in);
//
//        System.out.println("Welcome to Our Java Boot Camp!");
//        System.out.println("What's your name?   ");
//        String username = user_input.nextLine();
//        ifConditional(username);
//        forConditional();
//
//        System.out.println("What is your favorite color?    ");
//        String userColor = user_input.nextLine();
//        String computerResponse = switchConditional(userColor);
//        System.out.println("Here is the program's response to your choice:   " + computerResponse);
//        System.out.println("End of application - Have a nice day!");
//    }
//
//    public static void ifConditional(String userName) {
//        if (userName.length() > 6) {
//            System.out.println("That's a pretty long name!");
//        } else {
//            System.out.println("Short and sweet - nice!");
//        }
//    }
//
//    static void forConditional() {
//        int counter = 5;
//
//        System.out.println("\n");
//        for (int i = counter; i > 0; i--) {
//            System.out.println("Current index: " + i);
//            System.out.println("Current counter value: " + counter);
//        }
//    }
//
//    static String switchConditional(String favColor) {
//        switch(favColor) {
//            case "red":
//                System.out.println("If that's what you want to do... lol");
//                return "You can do better than red";
//            case "blue":
//                System.out.println("You have great taste!");
//                return "Blue is the best color - well done!";
//            case "purple":
//                System.out.println("Great combo of my favorite color - ");
//                return "Why not just go all the way and pick blue?";
//            default:
//                return "What did you put in?!!!! If that's what you want to do... lol";
//        }
//    }
//
//}