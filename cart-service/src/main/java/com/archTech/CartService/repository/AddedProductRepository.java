package com.archTech.CartService.repository;
import com.archTech.CartService.entity.Cart.AddedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedProductRepository extends JpaRepository<AddedProduct,Long>
{

}
