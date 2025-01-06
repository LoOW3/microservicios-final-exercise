package com.example.shopping_cart.service;

import com.example.shopping_cart.dto.ProductDTO;
import com.example.shopping_cart.dto.ShoppingCartDTO;
import com.example.shopping_cart.model.ShoppingCart;
import com.example.shopping_cart.repository.IShoppingCartRepository;
import com.example.shopping_cart.repository.ProductAPIClient;
import com.example.shopping_cart.utils.Status;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService{

    @Autowired
    IShoppingCartRepository sR;
    @Autowired
    private ProductAPIClient PAC;
    @Override
    public List<ProductDTO> listProducts() {
        return PAC.listProducts();
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return PAC.getProduct(id);
    }

    @Override
    public String createShoppingCart(ShoppingCart shoppingCart) {
        sR.save(shoppingCart);
        return "Carrito de compras creado";
    }

    @Override
    public String deleteShoppingCart(Long id) {
        sR.deleteById(id);
        return "Carrito de compras ID " + id + " eliminado.";
    }

    @Override
    public String updateStatusShoppingCart(Long id, Status status) {
        ShoppingCart shoppingCart = sR.findById(id).orElse(null);
        if(shoppingCart == null) return "No existe un carrito con el ID " + id;

        shoppingCart.setStatus(status);
        sR.save(shoppingCart);
        return "Carrito ID " + id + " actualizado. Nuevo estado: " + status;
    }

    @Override
    @CircuitBreaker(name="products", fallbackMethod = "fallbackAddProductToShoppingCart")
    public ResponseEntity<Object> addProductToShoppingCart(Long shoppingCartID, Long productID) {
        //return simulateError(shoppingCartID, productID);
        ShoppingCart shoppingCartByIDRecieved = sR.findById(shoppingCartID).orElse(null);
        if (shoppingCartByIDRecieved == null) {
            return ResponseEntity.badRequest().body("El carrito con el ID " + shoppingCartID + " no existe.");
        }


        List<Long> listProductsID = shoppingCartByIDRecieved.getProductIDs();


        List<ProductDTO> listProducts = new ArrayList<>();

        ProductDTO productFromParam = PAC.getProduct(productID);
        Double newTotalPrice = productFromParam.getPrice();
        for(Long item: listProductsID){
            ProductDTO product = PAC.getProduct(item);
            newTotalPrice += product.getPrice();
            listProducts.add(product);
        }
        listProducts.add(productFromParam);
        ShoppingCartDTO scDTO = new ShoppingCartDTO();
        scDTO.setId(shoppingCartByIDRecieved.getId());
        scDTO.setName(shoppingCartByIDRecieved.getName());
        //Falta total price y lista de productos
        scDTO.setTotalPrice(newTotalPrice);
        scDTO.setProducts(listProducts);

        listProductsID.add(productID);
        shoppingCartByIDRecieved.setProductIDs(listProductsID);
        shoppingCartByIDRecieved.setTotalPrice(newTotalPrice);
        sR.save(shoppingCartByIDRecieved);

        return ResponseEntity.ok(scDTO);
    }

    @Override
    public String removeProductFromShoppingCart(Long shoppingCartID, Long productID) {
        ShoppingCart shoppingCartByIDRecieved = sR.findById(shoppingCartID).orElse(null);
        if (shoppingCartByIDRecieved == null) {
            return "El carrito con el ID " + shoppingCartID + " no existe.";
        }
        List<Long> listProductsFiltered = shoppingCartByIDRecieved.getProductIDs();

        listProductsFiltered.removeIf(num -> num.equals(productID));

        Double newTotalPrice = 0.0;
        for(Long item: listProductsFiltered){
            ProductDTO productDTO = PAC.getProduct(item);
            newTotalPrice += productDTO.getPrice();
        }
        shoppingCartByIDRecieved.setProductIDs(listProductsFiltered);
        shoppingCartByIDRecieved.setTotalPrice(newTotalPrice);
        sR.save(shoppingCartByIDRecieved);

        return "Se elimino del carrito " + shoppingCartID + " el producto " + productID;
    }

    @Override
    public ResponseEntity<Object> getShoppingCartWithProducts(Long shoppingCartID) {
        ShoppingCart shoppingCartByIDRecieved = sR.findById(shoppingCartID).orElse(null);
        if (shoppingCartByIDRecieved == null) {
            return ResponseEntity.badRequest().body("El carrito con el ID " + shoppingCartID + " no existe.");
        }
        List<ProductDTO> listProducts = new ArrayList<>();
        for(Long item: shoppingCartByIDRecieved.getProductIDs()){
            listProducts.add(PAC.getProduct(item));
        }
        System.out.println(shoppingCartByIDRecieved.getTotalPrice());
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setId(shoppingCartByIDRecieved.getId());
        shoppingCartDTO.setName(shoppingCartByIDRecieved.getName());
        shoppingCartDTO.setTotalPrice(shoppingCartByIDRecieved.getTotalPrice());
        shoppingCartDTO.setStatus(shoppingCartByIDRecieved.getStatus());
        shoppingCartDTO.setProducts(listProducts);

        return ResponseEntity.ok(shoppingCartDTO);
    }


    //FALLBACKS
    public ResponseEntity<Object> fallbackAddProductToShoppingCart(Long shoppingCartID, Long productID, Throwable t) {
        System.out.println("Error en el servicio de productos: " + t.getMessage());

        // Return a meaningful fallback response
        return ResponseEntity.status(503).body("No se pudo agregar el producto al carrito debido a problemas con el servicio de productos.");
    }

    //SIMULATE ERROR
    public ResponseEntity<Object> simulateError(Long shoppingCartID, Long productID) {
        throw new RuntimeException("Error simulado: el servicio de productos está caído.");
    }


}
