package com.example.sales.dto;

import com.example.sales.utils.Status;
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
