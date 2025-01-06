package com.example.sales.controller;

import com.example.sales.dto.SaleDTO;
import com.example.sales.model.Sale;
import com.example.sales.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleController {

    @Autowired
    private ISaleService sS;
    @GetMapping("/{id}")
    public SaleDTO getSaleByID(@PathVariable("id") Long id){
        return sS.getSaleByID(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSale(@RequestBody Sale sale){
        return sS.createSale(sale);
    }
}
