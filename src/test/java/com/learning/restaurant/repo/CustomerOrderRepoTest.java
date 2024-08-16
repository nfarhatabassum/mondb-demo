package com.learning.restaurant.repo;

import com.learning.restaurant.model.Customer;
import com.learning.restaurant.model.CustomerOrder;
import com.learning.restaurant.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
@ExtendWith(SpringExtension.class)
public class CustomerOrderRepoTest {

    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    private CustomerOrder customerOrder;

    @BeforeEach
    public void setUp(){
//        customerOrder = new CustomerOrder(101,new Customer("Smith","Smith@gmail.com"),
//                Arrays.asList(new Order[]{
//                        new Order("Panner",1)
//                }),1000,"Smith");
//        customerOrderRepo.save(customerOrder);

    }
    @Test
     void givenOrderIdThenReturnOptional(){
        Optional<CustomerOrder> obj = this.customerOrderRepo.findById(101);
     //   System.out.println(obj.get());
        assertTrue(obj.isPresent());
        String customerName = obj.get().getCustomer().getCustomerName();
        assertEquals("Smith",customerName,"Customer Name is not mapped to the DB");
    }



}
