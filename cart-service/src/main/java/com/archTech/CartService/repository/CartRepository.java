package com.archTech.CartService.repository;
import com.archTech.CartService.entity.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart,Long>
{
    Cart findByUserId(Long userId);


}
