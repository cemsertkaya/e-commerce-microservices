package com.archTech.CartService.service;
import com.archTech.CartService.entity.Cart.AddedProduct;
import com.archTech.CartService.entity.Cart.Cart;
import com.archTech.CartService.entity.Cart.Product;
import com.archTech.CartService.entity.Order.Order;
import com.archTech.CartService.entity.Payment.Payment;
import com.archTech.CartService.entity.Payment.PaymentInfo;
import com.archTech.CartService.entity.Payment.PaymentPostBody;
import com.archTech.CartService.repository.AddedProductRepository;
import com.archTech.CartService.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AddedProductRepository addedProductRepository;


    @Autowired
    private RestTemplate restTemplate;

    public Cart addCart(Cart cart)
    {
        return cartRepository.save(cart);
    }


    public List<Cart> getAllCarts() {return cartRepository.findAll();}

    public void deleteAllCarts() {cartRepository.deleteAll();}

    public void addProductToCart(AddedProduct addedProduct)
    {
        Cart cart = cartRepository.findByUserId(addedProduct.getUserId());


        Product product = restTemplate.getForObject("http://localhost:9001/products/" + addedProduct.getProductId(), Product.class);


        if (cart.getTotalPrice() == null)
        {
            cart.setTotalPrice(product.getPrice());
        }
        else
        {
            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
        }

        cart.getAddedProducts().add(addedProduct);

        cartRepository.save(cart);
    }

    public Order payCart(PaymentInfo payInfo)
    {
        Cart cart = cartRepository.findByUserId(payInfo.getUserId());

        if (cart.getAddedProducts().isEmpty())
        {
            log.info("null");
            return null;
        }
        else
        {
            Payment payment = new Payment(payInfo.getUserId(), payInfo.getCreditCardNumber(),payInfo.getPrice());

            HttpEntity<PaymentPostBody> request = new HttpEntity<>(new PaymentPostBody(payment,payInfo.getAddedProduct()));

            Order order = restTemplate.postForObject("http://localhost:9003/payments/makePayment/", request, Order.class);

            assert order != null;

            addedProductRepository.deleteAllInBatch(cart.getAddedProducts());
            cart.getAddedProducts().clear();
            return order;

        }


    }
}
