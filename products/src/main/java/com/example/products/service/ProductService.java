package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository pR;

    @Override
    public List<Product> listProducts() {
        return pR.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return pR.findById(id).orElse(null);
    }

}
