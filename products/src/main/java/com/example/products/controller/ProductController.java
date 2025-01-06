package com.example.products.controller;

import com.example.products.model.Product;
import com.example.products.service.IProductService;
import com.example.products.utils.IUtilsProduct;
import com.example.products.utils.UtilsProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    IProductService pS;

    @Autowired
    IUtilsProduct uP;

    @Value("${server.port}")
    private int portService;
    @GetMapping("/list")
    public List<Product> listAllProducts(){
        System.out.println("Llamada en el puerto ------- " + portService);
        return pS.listProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return pS.getProduct(id);
    }

    @PostMapping("/init/create-products")
    public ResponseEntity<Object> createInitialProduct(){
        return uP.createInitialProducts();
    }
}
