package com.pawi.onlineshop.controller;

import com.pawi.onlineshop.dto.CustomerDTO;
import com.pawi.onlineshop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    //Get All Customers
    @GetMapping
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //Create a Customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }
}
