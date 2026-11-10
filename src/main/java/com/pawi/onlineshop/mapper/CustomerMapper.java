package com.pawi.onlineshop.mapper;

import com.pawi.onlineshop.dto.CustomerDTO;
import com.pawi.onlineshop.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static CustomerDTO convertToDTO (CustomerEntity customerEntity){
        if (customerEntity == null){
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setCustomerName(customerEntity.getCustomerName());
        customerDTO.setEmail(customerEntity.getEmail());
        customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        customerDTO.setAddress(customerEntity.getAddress());

        return customerDTO;

    }

    public static CustomerEntity convertToEntity (CustomerDTO customerDTO){
        if (customerDTO == null){
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDTO.getId());
        customerEntity.setCustomerName(customerDTO.getCustomerName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        customerEntity.setAddress(customerDTO.getAddress());
        return customerEntity;
    }
}
