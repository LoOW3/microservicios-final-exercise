package com.example.shopping_cart.service;

import com.example.shopping_cart.dto.ProductDTO;
import com.example.shopping_cart.dto.ShoppingCartDTO;
import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.utils.Status;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IShoppingCartService {
    public List<ProductDTO> listProducts();
    public ProductDTO getProduct(Long id);
    public String createShoppingCart(ShoppingCart shoppingCart);
    public String deleteShoppingCart(Long id);
    public String updateStatusShoppingCart(Long id, Status status);
    public ResponseEntity<Object> addProductToShoppingCart(Long shoppingCartID, Long productID);
    public String removeProductFromShoppingCart(Long shoppingCartID, Long productID);
    public ResponseEntity<Object> getShoppingCartWithProducts(Long shoppingCartID);
}
