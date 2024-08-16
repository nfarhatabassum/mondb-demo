package com.learning.restaurant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class CustomerOrder {
    @Id
    private int orderId;
    private Customer customer;
    private List<Order> orderList;
    private double totalPrice;
    private String username;

    public CustomerOrder(int orderId, double totalPrice, String username) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.username = username;
    }
}
