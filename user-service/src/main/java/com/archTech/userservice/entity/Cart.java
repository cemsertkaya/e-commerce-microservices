package com.archTech.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Long cardId;
    private Long userId;

    private Set<AddedProduct> addedProducts;

    public Cart(Long cardId, Long userId) {
        this.userId = userId;
        this.cardId = cardId;
        this.addedProducts = Collections.emptySet();
    }

}
