package com.pawi.onlineshop.service;

import com.pawi.onlineshop.dto.OrderDTO;
import com.pawi.onlineshop.mapper.OrderMapper;
import com.pawi.onlineshop.model.OrderEntity;
import com.pawi.onlineshop.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class OrderService {
    public final OrderRepository orderRepository;

    //Get all orders
    //List returns multiple items
    public List<OrderDTO> getAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::convertToDTO)
                .toList();
    }

    //Get order by ID
    //Returns one item
    public OrderDTO getOrderById(Long id){
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("Order not found with id: " + id));
        return OrderMapper.convertToDTO(order);
    }

    //Create Order
    //Returns one item
    public OrderDTO createOrder(OrderDTO orderDTO){
        OrderEntity entity = OrderMapper.convertToEntity(orderDTO);
        OrderEntity saved = orderRepository.save(entity);
        return OrderMapper.convertToDTO(saved);
    }

    //Update Order
    //Returns one item
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO){
        OrderEntity existing = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException ("Order not found with id: " + id));

        existing.setOrderDate(orderDTO.getOrderDate());
        existing.setStatus(orderDTO.getStatus());
        existing.setTotalAmount(orderDTO.getTotalAmount());

        OrderEntity updated = orderRepository.save(existing);
        return OrderMapper.convertToDTO(updated);
    }

    //Delete Order
    //Void means it does not return anything
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }

}
