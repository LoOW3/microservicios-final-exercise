package com.example.shopping_cart.repository;

import com.example.shopping_cart.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products")

public interface ProductAPIClient{
    @GetMapping("/list")
    public List<ProductDTO> listProducts ();
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id);
}