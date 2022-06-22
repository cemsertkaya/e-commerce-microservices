package com.archTech.CartService.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

    @Id
    private Long userId;
    private Double totalPrice = Double.valueOf(0);

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "userId")
    private Set<AddedProduct> addedProducts;


    public void calculateTotalPrice()
    {
        Double price = 0.0;
        for (AddedProduct addProduct : addedProducts)
        {
            price += addProduct.getPrice() * addProduct.getQuantity();
        }
        totalPrice = price;
    }

    public void addProduct(AddedProduct newProduct)
    {
        for (AddedProduct addedProduct : addedProducts)
        {
            if (newProduct.getProductId() == addedProduct.getProductId())
            {
                Long newQuantity = addedProduct.getQuantity() + newProduct.getQuantity();
                addedProduct.setQuantity(newQuantity);
                return;
            }

        }

        addedProducts.add(newProduct);

    }


}
