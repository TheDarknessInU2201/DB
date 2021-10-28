package com.db.connectionAndQuerys;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        new cratemaintables().createmain();
        Scanner kbInput = new Scanner(System.in);
        Boolean answerMS = null;
        System.out.println("""
                                Soll nach neuen Medien Dateien gesucht werden?
                                Für "Ja" geben sie "y" ein.
                                Für "Nein" geben sie "n" ein
                """);


        while (answerMS == null) {
            String answerInput = kbInput.nextLine();
            if (answerInput.equals("y") || answerInput.equals("Y")) {
                answerMS = true;
            } else if (answerInput.equals("n") || answerInput.equals("N")) {
                answerMS = false;
            } else {
                System.out.println("""
                        Falsche Eingabe, bitte geben sie nur "y" für "Ja" oder "n" für "Nein" ein.
                        """);
            }
        }


    }
}
