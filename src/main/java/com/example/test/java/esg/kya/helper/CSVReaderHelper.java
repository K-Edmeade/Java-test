package com.example.test.java.esg.kya.helper;

import com.example.test.java.esg.kya.entity.Customer;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CSVReaderHelper {

    public List<Customer> readCSV(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            List<Customer> customers = new CsvToBeanBuilder<Customer>(reader)
                    .withType(Customer.class)
                    .build()
                    .parse();
            return customers;
        }
        catch (IOException e) {
            System.err.println("An error occurred while reading the CSV file: " + fileName);
            return null;
        }

    }
}
