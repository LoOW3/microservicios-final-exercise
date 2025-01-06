package com.example.sales.repository;

import com.example.sales.dto.ShoppingCartDTO;
import com.example.sales.utils.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "shopping-cart")
public interface ShoppingCartAPIClient {
    @GetMapping("/{id}")
    public ShoppingCartDTO getShoppingCart(@PathVariable("id") Long id);
    @PutMapping("/update-status")
    public void updateStatusShoppingCart(@RequestParam("shopping-cart") Long id,
                                         @RequestParam("status") Status status);
}
