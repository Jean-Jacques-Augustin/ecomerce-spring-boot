package com.me.forum.controller;

import com.me.forum.model.Product;
import com.me.forum.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   @GetMapping
    public Iterable<Product> getAllProduct () {
        return productService.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{productId}")
    public void updateProduct(
            @PathVariable("productId") Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String price,
            @RequestParam String image) {
        productService.updateProduct(id, name, description, price, image);
    }
}
