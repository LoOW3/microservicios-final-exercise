package com.example.shopping_cart.model;

import com.example.shopping_cart.utils.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    private List<Long> productIDs;
}
