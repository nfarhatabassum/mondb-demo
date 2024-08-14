package com.learning.restaurant.service;

import com.learning.restaurant.exception.CustomerOrderAlreadyExistException;
import com.learning.restaurant.exception.NoOrderFoundException;
import com.learning.restaurant.model.CustomerOrder;
import com.learning.restaurant.repo.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
    @Autowired
    private CustomerOrderRepo customerOrderRepo;
    @Override
    public List<CustomerOrder> getAllCustomerOrders() throws NoOrderFoundException {
        List<CustomerOrder> customerOrders = customerOrderRepo.findAll();
        if(customerOrders.size()==0){
            throw new NoOrderFoundException("No Order For Today");
        }
        return customerOrders;
    }

    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) throws CustomerOrderAlreadyExistException {
        Optional<CustomerOrder> customerOrderOptional =customerOrderRepo.findByOrderIdAndUsername(customerOrder.getOrderId(),customerOrder.getUsername());
        if(customerOrderOptional.isEmpty()){
            customerOrderRepo.save(customerOrder);
            return customerOrder;

        }
        throw new CustomerOrderAlreadyExistException("Order already Exist");



    }
}
