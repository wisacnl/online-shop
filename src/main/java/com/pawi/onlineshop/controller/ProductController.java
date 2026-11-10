package com.pawi.onlineshop.controller;

import com.pawi.onlineshop.dto.ProductDTO;
import com.pawi.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //Get all products
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    //Get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        return productService.getProductByID(id);
    }

    //Create product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    //Update product
    @PutMapping
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    //Delete product
    @DeleteMapping
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

}
