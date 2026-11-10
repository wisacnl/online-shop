package com.pawi.onlineshop.service;


import com.pawi.onlineshop.dto.ProductDTO;
import com.pawi.onlineshop.mapper.ProductMapper;
import com.pawi.onlineshop.model.ProductEntity;
import com.pawi.onlineshop.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ProductService {
    public final ProductRepository productRepository;

    //Get all products
    public List<ProductDTO> getAllProducts (){
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::convertToDTO)
                .toList();
    }

    //Get product by ID
    public ProductDTO getProductByID (Long id){
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return ProductMapper.convertToDTO(product);
    }

    //Create product
    public  ProductDTO createProduct (ProductDTO productDTO){
        ProductEntity productEntity = ProductMapper.convertToEntity(productDTO);
        ProductEntity saved = productRepository.save(productEntity);
        return ProductMapper.convertToDTO(saved);
    }

    //Update product
    public ProductDTO updateProduct (Long id, ProductDTO productDTO){
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + id));

        existing.setProductName(productDTO.getProductName());
        existing.setPrice(productDTO.getPrice());
        existing.setQuantity(productDTO.getQuantity());
        existing.setImage(productDTO.getImage());

        ProductEntity updated = productRepository.save(existing);

        return ProductMapper.convertToDTO(updated);
    }

    //Delete Product
    public void deleteProduct (Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        productRepository.deleteById(id);

    }






}
