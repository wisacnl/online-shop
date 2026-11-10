package com.pawi.onlineshop.mapper;

import com.pawi.onlineshop.dto.OrderDTO;
import com.pawi.onlineshop.model.CustomerEntity;
import com.pawi.onlineshop.model.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public static OrderDTO convertToDTO (OrderEntity orderEntity){
        if (orderEntity == null){
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setOrderNumber(orderEntity.getOrderNumber());
        orderDTO.setCustomerName(orderEntity.getCustomerName());
        orderDTO.setTotalAmount(orderEntity.getTotalAmount());
        orderDTO.setStatus(orderEntity.getStatus());
        orderDTO.setOrderDate(orderEntity.getOrderDate());

        return orderDTO;
    }

    public static OrderEntity convertToEntity (OrderDTO orderDTO){
        if (orderDTO == null){
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setOrderNumber(orderDTO.getOrderNumber());
        orderEntity.setCustomerName(orderDTO.getCustomerName());
        orderEntity.setTotalAmount(orderDTO.getTotalAmount());
        orderEntity.setStatus(orderDTO.getStatus());
        orderEntity.setOrderDate(orderDTO.getOrderDate());

        return orderEntity;
    }

}
