package com.example.sales.service;

import com.example.sales.dto.SaleDTO;
import com.example.sales.model.Sale;
import org.springframework.http.ResponseEntity;

public interface ISaleService {

    public SaleDTO getSaleByID(Long id);
    public ResponseEntity<Object> createSale(Sale sale);

}
