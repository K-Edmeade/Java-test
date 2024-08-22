package com.example.test.java.esg.kya.service;

import com.example.test.java.esg.kya.entity.Customer;
import com.example.test.java.esg.kya.helper.CSVReaderHelper;
import com.example.test.java.esg.kya.helper.ConvertToJsonHelper;
import com.example.test.java.esg.kya.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceTest {
    @Mock
    CSVReaderHelper csvReaderHelper;

    @Mock
    ConvertToJsonHelper jsonHelper;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService service;

    String fileName = "test-file";
    Customer customer1 = new Customer(1234L, "TEST NAME", "TEST ADDRESS 1", "TEST ADDRESS 2",
            "TEST TOWN", "TEST COUNTY", "TEST COUNTRY", "TEST POST CODE");
    Customer customer2 = new Customer(5678L, "TEST NAME 2", "TEST ADDRESS 3", "TEST ADDRESS 4",
            "TEST TOWN 2", "TEST COUNTY 2", "TEST COUNTRY 2", "TEST POST CODE 2");
    List<Customer> customerList = new ArrayList<>();


    @Test
    public void when_saveCustomer_called_then_readCSV_called_once(){
        customerList.add(customer1);
        customerList.add(customer2);

        when(csvReaderHelper.readCSV(fileName)).thenReturn(customerList);
        when(customerRepository.saveAll(customerList)).thenReturn(customerList);

        service.saveCustomer(fileName);

        verify(csvReaderHelper, times(1)).readCSV(fileName);
    }

    @Test
    public void when_saveCustomer_called_then_saveAll_called_once(){
        customerList.add(customer1);
        customerList.add(customer2);

        when(csvReaderHelper.readCSV(fileName)).thenReturn(customerList);
        when(customerRepository.saveAll(customerList)).thenReturn(customerList);

        service.saveCustomer(fileName);

        verify(customerRepository, times(1)).saveAll(customerList);
    }

    @Test
    public void when_getCustomer_called_then_findById_called_once(){
        Optional<Customer> customerOptional = Optional.of(customer1);

        when(customerRepository.findById(1234L)).thenReturn(customerOptional);
        when(jsonHelper.convertToJson(any())).thenReturn("'customerReference': 'TEST-1234'," +
                "    'name': 'TEST NAME',\n" +
                "    'addressLine1': 'TEST ADDRESS 1',\n" +
                "    'addressLine2': 'TEST ADDRESS 2',\n" +
                "    'town': 'TEST TOWN',\n" +
                "    'county': 'TEST COUNTY',\n" +
                "    'country': 'TEST COUNTRY',\n" +
                "    'postcode': 'TEST POST CODE'");

        service.getCustomer(1234L);
        verify(customerRepository, times(1)).findById(1234L);
    }

    @Test
    public void when_getCustomer_called_then_convertToJson_called_once(){
        Optional<Customer> customerOptional = Optional.of(customer1);

        when(customerRepository.findById(1234L)).thenReturn(customerOptional);
        when(jsonHelper.convertToJson(any())).thenReturn("'customerReference': 'TEST-1234'," +
                "    'name': 'TEST NAME',\n" +
                "    'addressLine1': 'TEST ADDRESS 1',\n" +
                "    'addressLine2': 'TEST ADDRESS 2',\n" +
                "    'town': 'TEST TOWN',\n" +
                "    'county': 'TEST COUNTY',\n" +
                "    'country': 'TEST COUNTRY',\n" +
                "    'postcode': 'TEST POST CODE'");

        service.getCustomer(1234L);
        verify(jsonHelper, times(1)).convertToJson(customerOptional.get());
    }

    @Test
    public void when_getCustomer_givenNull_then_(){
        Optional<Customer> customerOptional = Optional.empty();

        when(customerRepository.findById(1234L)).thenReturn(customerOptional);

        service.getCustomer(1234L);
        verify(jsonHelper, times(0)).convertToJson(any());

    }
}
