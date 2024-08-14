package com.learning.restaurant.exception;

public class CustomerOrderAlreadyExistException extends Throwable {
    public CustomerOrderAlreadyExistException(String orderAlreadyExist) {
        super(orderAlreadyExist);
    }
}
