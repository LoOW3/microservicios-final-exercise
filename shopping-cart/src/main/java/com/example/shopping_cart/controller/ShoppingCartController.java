package com.example.shopping_cart.controller;

import com.example.shopping_cart.dto.ProductDTO;
import com.example.shopping_cart.dto.ShoppingCartDTO;
import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.service.IShoppingCartService;
import com.example.shopping_cart.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {
    @Autowired
    IShoppingCartService sS;
    @GetMapping("/products/list")
    public List<ProductDTO> listProducts(){
        return sS.listProducts();
    }


    @PostMapping("/create")
    public String createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return sS.createShoppingCart(shoppingCart);
    }

    @PutMapping("/update-status")
    public String updateStatusShoppingCart(@RequestParam("shopping-cart") Long id,
                                           @RequestParam("status")Status status){
        return sS.updateStatusShoppingCart(id, status);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getShoppingCartWithProducts(@PathVariable("id") Long id){
        return sS.getShoppingCartWithProducts(id);
    }
    @DeleteMapping("/delete/{id}")
    public String createShoppingCart(@PathVariable("id") Long id){
        return sS.deleteShoppingCart(id);
    }

    @PutMapping("/add-product")
    public ResponseEntity<Object> addProductToShoppingCart(@RequestParam ("shopping-cart") Long shoppingCartID,
                                                           @RequestParam ("product-id") Long productID){
        return sS.addProductToShoppingCart(shoppingCartID, productID);
    }

    @PutMapping("/remove-product")
    public String removeProductFromShoppingCart(@RequestParam ("shopping-cart") Long shoppingCartID,
                                                           @RequestParam ("product-id") Long productID){
        return sS.removeProductFromShoppingCart(shoppingCartID, productID);
    }
}
