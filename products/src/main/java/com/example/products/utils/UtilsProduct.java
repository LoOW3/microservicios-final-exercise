package com.example.products.utils;

import com.example.products.model.Product;
import com.example.products.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UtilsProduct implements IUtilsProduct{
    @Autowired
    IProductRepository pR;

    @Override
    public ResponseEntity<Object> createInitialProducts() {
        long productsLengthOnDB = pR.count();
        if(productsLengthOnDB != 0) return ResponseEntity.badRequest().body("Los productos ya han sido creados.");
        List<Product> products = Arrays.asList(
                new Product(null, "Smartphone Galaxy S23", "El nuevo modelo de Samsung con pantalla AMOLED de 6.1 pulgadas.", "Samsung", 799.99),
                new Product(null, "Laptop MacBook Pro 16", "Laptop potente de Apple con procesador M1 Pro, pantalla Retina de 16 pulgadas.", "Apple", 2399.99),
                new Product(null, "Auriculares WH-1000XM4", "Auriculares de Sony con cancelación de ruido activa y batería de 30 horas.", "Sony", 349.99),
                new Product(null, "Smartwatch Series 8", "Reloj inteligente de Apple con GPS, monitorización de salud y hasta 18 horas de batería.", "Apple", 399.99),
                new Product(null, "Televisor OLED 55\"", "Televisor 4K OLED de LG con soporte para Dolby Vision y HDR10+", "LG", 1299.99),
                new Product(null, "Tablet Galaxy Tab S7", "Tableta de Samsung con pantalla de 11 pulgadas y S Pen incluido.", "Samsung", 649.99),
                new Product(null, "Cámara EOS 90D", "Cámara réflex de Canon con resolución de 32.5 MP y grabación en 4K.", "Canon", 1199.99),
                new Product(null, "Smartphone iPhone 14 Pro", "iPhone 14 Pro con chip A16 Bionic y cámara triple de 48 MP.", "Apple", 999.99),
                new Product(null, "Laptop Dell XPS 13", "Laptop ultradelgada de Dell con procesador Intel i7 y pantalla InfinityEdge.", "Dell", 1499.99),
                new Product(null, "Auriculares Bose QuietComfort 45", "Auriculares con cancelación de ruido de Bose, ideales para viajar.", "Bose", 329.99),
                new Product(null, "Smartphone Pixel 8", "Teléfono inteligente de Google con cámara avanzada y Android puro.", "Google", 799.99),
                new Product(null, "Consola PlayStation 5", "Consola de videojuegos Sony PlayStation 5 con compatibilidad 4K y nuevos títulos.", "Sony", 499.99),
                new Product(null, "Tablet iPad Air", "Tableta ligera de Apple con chip A14 Bionic y pantalla de 10.9 pulgadas.", "Apple", 599.99),
                new Product(null, "Monitor UltraWide 34\"", "Pantalla curva UltraWide de Samsung de 34 pulgadas, ideal para multitarea.", "Samsung", 799.99),
                new Product(null, "Cámara Mirrorless A7 IV", "Cámara sin espejo de Sony con resolución de 33 MP y grabación 4K.", "Sony", 2499.99),
                new Product(null, "Smartphone OnePlus 11", "Smartphone con pantalla Fluid AMOLED y carga rápida de 100W.", "OnePlus", 749.99),
                new Product(null, "Smartwatch Galaxy Watch 5", "Reloj inteligente de Samsung con seguimiento de salud y batería de larga duración.", "Samsung", 299.99),
                new Product(null, "Laptop HP Spectre x360", "Laptop convertible con pantalla táctil 4K y procesador Intel i7.", "HP", 1599.99),
                new Product(null, "Auriculares Beats Studio Buds", "Auriculares inalámbricos de Beats con cancelación de ruido activa.", "Beats", 149.99),
                new Product(null, "Consola Xbox Series X", "Consola de videojuegos Xbox Series X con soporte para 4K a 120Hz.", "Microsoft", 499.99),
                new Product(null, "Televisor QLED 65\"", "Televisor 4K QLED de Samsung con soporte para Dolby Vision y HDR10+", "Samsung", 1799.99),
                new Product(null, "Cámara DSLR EOS Rebel T7", "Cámara DSLR de Canon ideal para principiantes, con lente de 18-55mm.", "Canon", 549.99),
                new Product(null, "Tablet Microsoft Surface Pro 8", "Tableta de Microsoft con pantalla táctil de 13 pulgadas y procesador Intel i7.", "Microsoft", 1299.99),
                new Product(null, "Smartphone Xiaomi Mi 12", "Smartphone de Xiaomi con pantalla AMOLED y procesador Snapdragon 8 Gen 2.", "Xiaomi", 699.99),
                new Product(null, "Refrigerador LG InstaView", "Refrigerador de 28 pies cúbicos con tecnología InstaView y dispensador de agua.", "LG", 2199.99),
                new Product(null, "Cámara de Seguridad Nest Cam", "Cámara de seguridad de Google Nest con visión nocturna y audio bidireccional.", "Google", 129.99),
                new Product(null, "Auriculares Jabra Elite 75t", "Auriculares deportivos inalámbricos con buen ajuste y resistencia al agua.", "Jabra", 199.99),
                new Product(null, "Smartphone Motorola Edge 30", "Motorola Edge 30 con pantalla OLED y carga rápida de 68W.", "Motorola", 699.99),
                new Product(null, "Laptop Lenovo ThinkPad X1 Carbon", "Laptop de alto rendimiento con pantalla de 14 pulgadas y teclado cómodo.", "Lenovo", 1799.99),
                new Product(null, "Smartwatch Fitbit Sense 2", "Reloj inteligente Fitbit con monitoreo avanzado de salud y sueño.", "Fitbit", 249.99),
                new Product(null, "Televisor Sony Bravia 65\"", "Televisor 4K de Sony con HDR y Android TV integrado.", "Sony", 1599.99),
                new Product(null, "Consola Nintendo Switch", "Consola híbrida Nintendo Switch con juegos como Zelda y Mario Kart.", "Nintendo", 299.99),
                new Product(null, "Smartphone Oppo Find X5 Pro", "Smartphone Oppo con pantalla AMOLED curva y carga rápida de 80W.", "Oppo", 899.99),
                new Product(null, "Cámara de Seguridad Arlo Pro 4", "Cámara de seguridad Arlo Pro 4 con visión 2K y audio bidireccional.", "Arlo", 199.99)
        );

        pR.saveAll(products);
        return ResponseEntity.ok("Productos iniciales creados");
    }
}
