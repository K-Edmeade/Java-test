package com.example.test.java.esg.kya.controller;

import com.example.test.java.esg.kya.entity.Customer;

import com.example.test.java.esg.kya.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerControllerTest {

    @Mock
    CustomerService service;

    @InjectMocks
    CustomerController customerController;

    String fileName = "test-file";
    Customer customer1 = new Customer(1234L, "TEST NAME", "TEST ADDRESS 1", "TEST ADDRESS 2",
            "TEST TOWN", "TEST COUNTY", "TEST COUNTRY", "TEST POST CODE");
    Customer customer2 = new Customer(5678L, "TEST NAME 2", "TEST ADDRESS 3", "TEST ADDRESS 4",
            "TEST TOWN 2", "TEST COUNTY 2", "TEST COUNTRY 2", "TEST POST CODE 2");
    List<Customer> customerList = new ArrayList<>();


    @Test
    public void when_saveCustomer_called_then_serviceSaveCustomer_called_once(){

        customerController.saveCustomer(fileName);

        verify(service, times(1)).saveCustomer(fileName);
    }


    @Test
    public void when_getCustomer_called_then_findById_called_once(){

        customerController.getCustomer(1234L);
        verify(service, times(1)).getCustomer(1234L);
    }


    @Test
    public void when_getCustomer_givenNull_then_(){

       String getCustomer = customerController.getCustomer(null);

        assert(getCustomer == null);
    }
}
