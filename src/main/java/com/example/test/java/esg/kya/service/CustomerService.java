package com.example.test.java.esg.kya.service;

import com.example.test.java.esg.kya.entity.Customer;
import com.example.test.java.esg.kya.helper.CSVReaderHelper;
import com.example.test.java.esg.kya.helper.ConvertToJsonHelper;
import com.example.test.java.esg.kya.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CSVReaderHelper csvHelper;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ConvertToJsonHelper convertJSONHelper;

    public void saveCustomer(String filePath){
        List<Customer> customers = csvHelper.readCSV(filePath);
        customerRepository.saveAll(customers);
    }

    public String getCustomer(long customerReference){
        Optional<Customer> customer = customerRepository.findById(customerReference);

        if(customer.isPresent()){
            System.out.print("Customer: " + customerReference + " found!");
            return convertJSONHelper.convertToJson( customer.get() );
        }
        else {
            System.out.print("Customer: " + customerReference + " not found!");
            return null;
        }
    }
}
