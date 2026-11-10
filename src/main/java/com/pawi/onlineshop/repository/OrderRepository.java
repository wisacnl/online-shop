package com.pawi.onlineshop.repository;


import com.pawi.onlineshop.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    //List <OrderEntity> findByQuantityAndPrice(Integer quantity, Double price);
}
