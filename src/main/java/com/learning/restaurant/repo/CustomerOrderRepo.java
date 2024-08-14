package com.learning.restaurant.repo;

import com.learning.restaurant.model.CustomerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerOrderRepo extends MongoRepository<CustomerOrder,Integer> {
    Optional<CustomerOrder> findByOrderIdAndUsername(int orderId, String username);
}
