package com.example.test.java.esg.kya.helper;

import com.example.test.java.esg.kya.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


@Component
public class ConvertToJsonHelper {

    ObjectMapper mapper = new ObjectMapper();

    public String convertToJson(Customer customer) {
        try{
            return mapper.writeValueAsString(customer);
        } catch(JsonProcessingException e){
            System.out.println("Failed to convert customer to json");
            return null;
        }
    }
}
