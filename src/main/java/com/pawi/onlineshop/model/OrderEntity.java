package com.pawi.onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String customerName;
    private Double totalAmount;
    private String status;
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<ProductEntity> items;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private List<CustomerEntity> customer;

}
