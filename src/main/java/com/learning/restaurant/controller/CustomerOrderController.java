package com.learning.restaurant.controller;

import com.learning.restaurant.exception.CustomerOrderAlreadyExistException;
import com.learning.restaurant.exception.NoOrderFoundException;
import com.learning.restaurant.model.CustomerOrder;
import com.learning.restaurant.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService orderService;
    ResponseEntity<?> responseEntity;

    @PostMapping("/addCustomerOrder")
    public ResponseEntity<?> addCustomerOrder(@RequestBody CustomerOrder customerOrder){
        try {
            CustomerOrder customerOrderObj = orderService.addCustomerOrder(customerOrder);
            responseEntity = new ResponseEntity<String>("CustomerOrder Added Successfully", HttpStatus.CREATED);
        } catch (CustomerOrderAlreadyExistException e) {
           responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllCustomerOrder(){
        try {
            List<CustomerOrder> customerOrders = orderService.getAllCustomerOrders();
            responseEntity = new ResponseEntity<List<CustomerOrder>>(customerOrders,HttpStatus.ACCEPTED);
        } catch (NoOrderFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
