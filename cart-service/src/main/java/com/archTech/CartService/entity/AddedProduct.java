package com.archTech.CartService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name="addedProduct")
public class AddedProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long addedProductId;


    private Long productId;
    private Long quantity;

    public AddedProduct(Long productId, Long quantity)
    {
        this.productId = productId;
        this.quantity = quantity;
    }

}
