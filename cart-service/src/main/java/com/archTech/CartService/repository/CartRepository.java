package com.archTech.CartService.repository;
import com.archTech.CartService.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart,Long>
{
    Cart findByCartId(Long orderId);
}