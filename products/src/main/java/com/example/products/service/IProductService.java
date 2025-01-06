package com.example.products.service;

import com.example.products.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> listProducts();
    public Product getProduct(Long id);
}
