package com.archTech.CartService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthSignUp
{
    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
