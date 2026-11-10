package com.pawi.onlineshop.mapper;

import com.pawi.onlineshop.dto.ProductDTO;
import com.pawi.onlineshop.model.ProductEntity;
import com.sun.security.auth.PrincipalComparator;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDTO convertToDTO (ProductEntity productEntity){
        if (productEntity == null){
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setQuantity(productEntity.getQuantity());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setImage(productEntity.getImage());

        return productDTO;
    }

    public static ProductEntity convertToEntity (ProductDTO productDTO){
        if (productDTO == null){
            return null;
        }

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productEntity.getId());
        productEntity.setProductName(productEntity.getProductName());
        productEntity.setQuantity(productEntity.getQuantity());
        productEntity.setPrice(productEntity.getPrice());
        productEntity.setImage(productEntity.getImage());

        return productEntity;
    }

}
