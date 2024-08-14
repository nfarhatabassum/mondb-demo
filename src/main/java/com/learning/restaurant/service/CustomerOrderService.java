package com.learning.restaurant.service;

import com.learning.restaurant.exception.CustomerOrderAlreadyExistException;
import com.learning.restaurant.exception.NoOrderFoundException;
import com.learning.restaurant.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {
    List<CustomerOrder> getAllCustomerOrders() throws NoOrderFoundException;
    CustomerOrder addCustomerOrder(CustomerOrder customerOrder) throws CustomerOrderAlreadyExistException;
}
