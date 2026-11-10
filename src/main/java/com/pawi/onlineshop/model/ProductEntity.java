package com.pawi.onlineshop.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

}
