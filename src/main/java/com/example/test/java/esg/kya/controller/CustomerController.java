package com.example.test.java.esg.kya.controller;


import com.example.test.java.esg.kya.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/{filePath}")
    public void saveCustomer(@PathVariable("filePath") String filePath){
        service.saveCustomer(filePath);
    }

    @GetMapping("/")
    public String getCustomer(@RequestParam Long customerReference){
        return service.getCustomer(customerReference);
    }

}
