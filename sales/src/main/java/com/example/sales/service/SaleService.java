package com.example.sales.service;

import com.example.sales.dto.SaleDTO;
import com.example.sales.dto.ShoppingCartDTO;
import com.example.sales.model.Sale;
import com.example.sales.repository.ISaleRepository;
import com.example.sales.repository.ShoppingCartAPIClient;
import com.example.sales.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private ISaleRepository sR;

    @Autowired
    private ShoppingCartAPIClient SCAC;
    @Override
    public SaleDTO getSaleByID(Long id) {
        Sale sale = sR.findById(id).orElse(null);

        //Make SaleDTO
        assert sale != null;
        ShoppingCartDTO shoppingCartDTO = SCAC.getShoppingCart(sale.getShoppingCartID());
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId(sale.getId());
        saleDTO.setDate(sale.getDate());
        saleDTO.setShoppingCartDTO(shoppingCartDTO);
        return saleDTO;
    }

    @Override
    public ResponseEntity<Object> createSale(Sale sale) {
        SCAC.updateStatusShoppingCart(sale.getShoppingCartID(), Status.COMPLETED);
        sR.save(sale);
        return ResponseEntity.ok("Venta guardada exitosamente");
    }
}
