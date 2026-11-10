package com.pawi.onlineshop.service;

import com.pawi.onlineshop.dto.CustomerDTO;
import com.pawi.onlineshop.mapper.CustomerMapper;
import com.pawi.onlineshop.model.CustomerEntity;
import com.pawi.onlineshop.repository.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pawi.onlineshop.mapper.CustomerMapper.convertToEntity;

@Service
@Getter
@Setter
@RequiredArgsConstructor //creates automatic

public class CustomerService {
    private final CustomerRepository customerRepository;

    //Uses DTO to hide database
    public List<CustomerDTO> getAllCustomers(){
        //Equivalent to SELECT * FROM in SQL
        return customerRepository.findAll()
                //Converts the List into a Stream.
                .stream()
                //Transforms Customer Entity to CustomerDTO
                .map(CustomerMapper::convertToDTO)
                //Collects the converted into List
                .toList();
    }

    //Takes DTO as input
    public CustomerDTO saveCustomer (CustomerDTO customerDTO){
        //Convert DTO → Entity
        CustomerEntity customerEntity = CustomerMapper.convertToEntity (customerDTO);
        //Save to Database
        CustomerEntity saved = customerRepository.save(customerEntity);
        //Convert back Entity → DTO
        return CustomerMapper.convertToDTO(saved);
    }


}
