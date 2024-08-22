package com.example.test.java.esg.kya.helper;

import com.example.test.java.esg.kya.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ConvertToJsonHelperTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private ConvertToJsonHelper service;

    @Test
    public void when_convertToJson_then_writeValueAsString_called_once() throws JsonProcessingException {
        Customer customer = new Customer(1234L, "TEST NAME", "TEST ADDRESS 1", "TEST ADDRESS 2",
                "TEST TOWN", "TEST COUNTY", "TEST COUNTRY", "TEST POST CODE");

        when(objectMapper.writeValueAsString(customer)).thenReturn("""
                'customerReference': '1234L',\
                    'name': 'TEST NAME',
                    'addressLine1': 'TEST ADDRESS 1',
                    'addressLine2': 'TEST ADDRESS 2',
                    'town': 'TEST TOWN',
                    'county': 'TEST COUNTY',
                    'country': 'TEST COUNTRY',
                    'postcode': 'TEST POST CODE'""");

        service.convertToJson(customer);

        verify(objectMapper, times(1)).writeValueAsString(customer);
    }

    @Test
    public void when_convertToJson_given_null() {

        service.convertToJson(null);

        assert(service.convertToJson(null) == null);
    }
}
