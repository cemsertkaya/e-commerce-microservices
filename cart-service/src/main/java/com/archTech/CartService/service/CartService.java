package com.archTech.CartService.service;
import com.archTech.CartService.VO.ResponseTemplateVO;
import com.archTech.CartService.entity.Cart;
import com.archTech.CartService.repository.CartRepository;
import com.archTech.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Cart addCart(Cart cart) {return  cartRepository.save(cart);}

    public Cart findCartById(Long cartId) {return cartRepository.findByCartId(cartId);}

    public ResponseTemplateVO getCartWithProducts(Long cartId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Cart cart = cartRepository.findByCartId(cartId);

        List<Product> products = new ArrayList<>();

        for (String id : cart.getProductIds().split(",")) {
            Product product = restTemplate.getForObject("http://localhost:9001/carts/" + id, Product.class);
            products.add(product);
        }

        vo.setCart(cart);
        vo.setProducts(products);

        return vo;
    }
}
