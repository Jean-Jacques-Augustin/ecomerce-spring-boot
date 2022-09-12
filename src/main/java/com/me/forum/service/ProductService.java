package com.me.forum.service;


import com.me.forum.model.Product;
import com.me.forum.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Product with id " + id + " does not exists");
        }
        System.out.println(true);
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id, String name, String description, String price, String image) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Product with id " + id + " does not exists")
        );
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        productRepository.save(product);
    }
}