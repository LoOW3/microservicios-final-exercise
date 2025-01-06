package com.example.shopping_cart.dto;

import com.example.shopping_cart.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {
    private Long id;
    private String name;
    private Double totalPrice;
    private Status status;
    private List<ProductDTO> products;
}
