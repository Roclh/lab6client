package com.classes;


import java.util.Scanner;

public class Terminal {
    private static Scanner sc = new Scanner(System.in);

    public static String readLine(String message){
        System.out.println(message);
        return sc.nextLine();
    }
}
