package com.practise.relationships.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practise.relationships.Entity.Product;
import com.practise.relationships.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // @PostMapping("/user/{userId}")
    // public Product addProductToUser(@PathVariable Long userId, @RequestBody Product product) {
    //     return productService.addProductToUser(userId, product);
    // }

    @PostMapping("/user/{userId}")
    public String addMultipleProductsToUser(@PathVariable Long userId, @RequestBody List<Product> products) {
         productService.addMultipleProductsToUser(userId, products);
         return "product added succesfully";
    }
}