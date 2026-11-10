package com.pawi.onlineshop.controller;

import com.pawi.onlineshop.dto.OrderDTO;
import com.pawi.onlineshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    //Get all orders
    @GetMapping
    public List<OrderDTO> getOrders(){
        return orderService.getAllOrders();
    }

    //Get order by id
    @GetMapping("/{id}")
    public OrderDTO getOrderByID(@PathVariable("id") Long id){
        return orderService.getOrderById(id);
    }

    // Create an order
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    //Update order
    @PutMapping
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(id, orderDTO);
    }

    //Delete Order
    @DeleteMapping
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

}
