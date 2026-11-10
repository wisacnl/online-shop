package com.pawi.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {
    private Long id;
    private String orderNumber;
    private String customerName;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;


}
