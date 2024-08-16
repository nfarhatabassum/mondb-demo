package com.learning.restaurant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.restaurant.exception.CustomerOrderAlreadyExistException;
import com.learning.restaurant.exception.NoOrderFoundException;
import com.learning.restaurant.model.Customer;
import com.learning.restaurant.model.CustomerOrder;
import com.learning.restaurant.model.Order;
import com.learning.restaurant.service.CustomerOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerOrderController.class)
public class CustomerOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerOrderService customerOrderService;

    private CustomerOrder customerOrder;
    @Autowired
    private ObjectMapper objectMapper;
    private List<CustomerOrder> customerOrders;
@BeforeEach
    public void setUp(){
                customerOrder = new CustomerOrder(101,new Customer("Smith","Smith@gmail.com"),
                Arrays.asList(new Order[]{
                        new Order("Panner",1)
                }),1000,"Smith");
                customerOrders = new ArrayList<>();
                customerOrders.add(customerOrder);
    }

    @Test
    public void testAddCustomerObjectReturnCreatedStatus() throws CustomerOrderAlreadyExistException, Exception {
        when(customerOrderService.addCustomerOrder(any(CustomerOrder.class))).thenReturn(customerOrder);
        mockMvc.perform(
                post("/addCustomerOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerOrder)))
                        .andExpect(status().isCreated());


    }
    @Test
    @Disabled
    public void testGetCustonerOrderDetailsSuccess() throws NoOrderFoundException, Exception {
        when(customerOrderService.getAllCustomerOrders()).thenReturn(customerOrders);
        mockMvc.perform(
                get("/getAllOrders")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isAccepted());

    }
}
