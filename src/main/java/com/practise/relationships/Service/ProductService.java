package com.practise.relationships.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.relationships.Entity.Product;
import com.practise.relationships.Entity.User;
import com.practise.relationships.Repository.ProductRepository;
import com.practise.relationships.Repository.UserRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return productRepository.save(product);
        }).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // public Product addProductToUser(Long userId, Product product) {
    
    //     User user = userRepository.findById(userId).orElse(null);

    //     if (user != null) {
           
    //         product.setUser(user);
           
    //         return productRepository.save(product);
    //     }
    //     return null;  
    // }

    public void addMultipleProductsToUser(Long userId, List<Product> products) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Set user for each product and save
        for (Product product : products) {
            product.setUser(user);
            productRepository.save(product);  // Save each product with the user
        }
    }
}
