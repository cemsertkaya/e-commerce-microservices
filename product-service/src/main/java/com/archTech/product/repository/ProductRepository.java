package com.archTech.product.repository;


import com.archTech.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{
    Product findByProductId(Long productId);
}
