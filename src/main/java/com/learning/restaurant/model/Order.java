package com.learning.restaurant.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    private String dishName;
    private int quantity;
}
