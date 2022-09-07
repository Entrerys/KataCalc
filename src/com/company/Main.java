package com.company;

import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static String calc(String input) {

        Roman[] romanNumb = Roman.values();

        String answer = null;

        Roman romanA = null;
        Roman romanB = null;

        int a = 0;
        int b = 0;
        int d = 0;

        char c = 0;
        char[] chars = input.toCharArray();

        for (int i = 0; i <= chars.length - 1; i++)
            switch (chars[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                    c = chars[i];
                    break;

            }

        String operator = c + "";

        switch (operator) {
            case "*":
                operator = "\\*";
                break;
            case "+":
                operator = "\\+";
                break;
        }


        switch (chars[0]) {
            case '-':
                input = input.replaceFirst("-", "");
        }
        String[] strings = input.split(operator);


        String string1 = strings[0];
        String string2 = strings[1];


        for (Roman romans : Roman.values()) {
            if (romans.toString().equals(string1)) {
                romanA = Roman.valueOf(string1);
            }
            if (romans.toString().equals(string2)) {
                romanB = Roman.valueOf(string2);
            }
        }

        if (romanA == null) {
            try {
                a = Integer.parseInt(string1);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        if (romanA != null) {

            a = romanA.getDigit();
        }
        if (romanA == null & romanB != null | romanA != null & romanB == null) {
            throw new IllegalArgumentException("Необходимо использовать только арабские или римски цифры");
        }


        if (romanB == null) {
            try {
                b = Integer.parseInt(string2);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        if (romanB != null) {
            b = romanB.getDigit();
        }

        if (chars[0] == '-') {
            a = a * -1;
        }

        if (a <= -11 | a >= 11) {
            throw new IllegalArgumentException("Значение вне диапазона");
        }
        if (b <= -11 | b >= 11) {
            throw new IllegalArgumentException("Значение вне диапазона");
        }


        switch (c) {
            case '+':
                d = a + b;

                break;
            case '-':
                d = a - b;
                break;
            case '/':
                d = a / b;
                break;
            case '*':
                d = a * b;
        }


        if (romanA != null & romanB != null) {
            answer = String.valueOf(romanNumb[d - 1]);
        } else {
            answer = d + "";
        }


        return answer;
    }

    public static void main(String[] args) {

        System.out.println("Введите пример в формате 5-2 или I+II : ");
        String input = scanner.nextLine().replaceAll(" ", "");

        System.out.println(calc(input));
    }
}
