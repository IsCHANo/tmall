package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Order;

import com.ischano.tmall.entiey.OrderItem;
import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrder(Order order);

    List<OrderItem> findByProduct(Product product);

    List<OrderItem> findByUserAndOrderIsNull(User user);
}
