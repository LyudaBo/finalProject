package com.gojava.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Utils {

    private Utils() {
    }

    public static void printBorder() {
        System.out.println("-----------------------------------------------");
    }

    public static Integer provideIntInputStream() {
        System.out.print("Select choice (confirm Enter): ");
        String line;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
            return Integer.valueOf(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String provideStringInputStream(String enterData) {
        System.out.print(enterData);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
