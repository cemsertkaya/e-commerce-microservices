package com.archTech.product.controller;



import com.archTech.product.entity.Product;
import com.archTech.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product) {return productService.saveProduct(product);}

    @GetMapping("/{id}")
    public Product getProductWithId(@PathVariable("id") Long productId) {return productService.findProductById(productId);}

    @GetMapping("/")
    public List<Product> getAllProducts()  {return productService.getAllProducts();}


}
