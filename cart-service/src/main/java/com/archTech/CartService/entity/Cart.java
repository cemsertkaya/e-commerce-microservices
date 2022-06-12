package com.archTech.CartService.entity;

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


    @OneToMany(cascade=CascadeType.ALL, mappedBy = "userId")
    private Set<AddedProduct> addedProducts;

}
