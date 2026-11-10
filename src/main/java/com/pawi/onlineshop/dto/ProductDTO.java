package com.pawi.onlineshop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
    private String image;
}
