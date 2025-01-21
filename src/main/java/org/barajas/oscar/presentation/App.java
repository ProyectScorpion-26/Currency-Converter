package org.barajas.oscar.presentation;

import org.barajas.oscar.facade.CurrencyExchangeFacade;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    private final CurrencyExchangeFacade facade;
    private static final List<String> VALID_CURRENCY_CODES = Arrays.asList(
            "USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD",
            "ARS", "COP", "BRL", "BOB", "PEN", "MXN", "CLP", "KRW", "INR", "ZAR"
    );

    public App(CurrencyExchangeFacade facade) {
        this.facade = facade;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter");

        while (true) {
            int option = showMenu(scanner);

            if (option == 2) {
                System.out.println("The program has ended");
                break;
            }

            if (option == 1) {
                processCurrencyConversion(scanner);
            } else {
                System.out.println("Invalid option. Please select 1 or 2.");
            }
        }
    }

    private int showMenu(Scanner scanner) {
        System.out.println("Choose an option:");
        System.out.println("1. Convert currency");
        System.out.println("2. Exit");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number (1 or 2).");
            scanner.nextLine();
        }

        return scanner.nextInt();
    }

    private void processCurrencyConversion(Scanner scanner) {
        String sourceCode = promptForCurrencyCode(scanner, "Enter the source currency code (e.g., USD, EUR, GBP):");
        if (sourceCode == null) {
            return;
        }

        String targetCode = promptForCurrencyCode(scanner, "Enter the target currency code (e.g., USD, EUR, GBP):");
        if (targetCode == null) {
            return;
        }

        System.out.println("Enter the amount to convert:");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.nextLine();
        }

        double amount = scanner.nextDouble();

        try {
            double result = facade.convertCurrency(sourceCode, targetCode, amount);
            System.out.printf("Result: %.2f %s\n", result, targetCode);
        } catch (IOException e) {
            System.err.println("Error retrieving exchange rate: " + e.getMessage());
        }
    }

    private String promptForCurrencyCode(Scanner scanner, String prompt) {
        String code;
        while (true) {
            System.out.println(prompt);
            code = scanner.next().toUpperCase();

            if (isValidCurrencyCode(code)) {
                return code;
            } else {
                System.out.println("Invalid currency code. Please enter a valid code.");
            }
        }
    }

    private boolean isValidCurrencyCode(String code) {
        return VALID_CURRENCY_CODES.contains(code);
    }
}
