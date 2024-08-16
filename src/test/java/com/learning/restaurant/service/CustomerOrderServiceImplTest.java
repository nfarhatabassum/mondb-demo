package com.learning.restaurant.service;

import com.learning.restaurant.exception.NoOrderFoundException;
import com.learning.restaurant.model.CustomerOrder;
import com.learning.restaurant.repo.CustomerOrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerOrderServiceImplTest {
    @Mock
    private CustomerOrderRepo customerOrderRepo;

    @InjectMocks
    private CustomerOrderServiceImpl customerOrderService;

    private List<CustomerOrder> customerOrders;

    private CustomerOrder customerOrder;

    @BeforeEach
    public void setUp(){
        customerOrders = new ArrayList<>();
        customerOrders.add(new CustomerOrder(101,1000,"Smith"));
        customerOrders.add(new CustomerOrder(102,100,"Anne"));
        customerOrders.add(new CustomerOrder(103,1500,"John"));
        customerOrders.add(new CustomerOrder(104,2000,"Dave"));
        customerOrders.add(new CustomerOrder(105,3000,"Mario"));
    }

    @Test
    public void testGetAllCustomerOrderDetails() throws NoOrderFoundException {
        when(customerOrderRepo.findAll()).thenReturn(customerOrders);
        List<CustomerOrder> customerOrderList = customerOrderService.getAllCustomerOrders();
       // List<CustomerOrder> customerOrderList1 = customerOrderService.getAllCustomerOrders();
        assertEquals(5,customerOrderList.size(),"Number of records are not mapped to the expected output");
        assertEquals("Anne",customerOrderList.get(1).getUsername(),"Username is not mapped to the expected output");
        verify(customerOrderRepo,times(1)).findAll();
    }


}
