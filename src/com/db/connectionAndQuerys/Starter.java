package com.db.connectionAndQuerys;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        new cratemaintables().createmain();
        Scanner kbInput = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");

        String userName = kbInput.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input

    }
}
