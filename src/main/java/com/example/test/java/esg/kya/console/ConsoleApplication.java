package com.example.test.java.esg.kya.console;
import com.example.test.java.esg.kya.controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private CustomerController customerController;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Save customer data from file");
            System.out.println("2. Retrieve customer data by reference");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the file path to save customer data: ");
                    String filePath = scanner.nextLine();
                    customerController.saveCustomer(filePath);
                    break;
                case 2:
                    System.out.print("Enter the customer reference: ");
                    long customerReference = Long.parseLong(scanner.nextLine());

                    String result = customerController.getCustomer(customerReference);
                    System.out.println("Customer Data: " + result);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

}
