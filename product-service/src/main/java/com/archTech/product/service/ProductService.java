package com.archTech.product.service;

import com.archTech.product.entity.Product;
import com.archTech.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Product saveProduct(Product product)
    {
        return  productRepository.save(product);
    }

    public Product findProductById(Long productId) {return productRepository.findByProductId(productId);}

    public List<Product> getAllProducts() {return productRepository.findAll();}
}
