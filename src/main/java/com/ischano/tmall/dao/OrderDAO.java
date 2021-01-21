package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Order;
import com.ischano.tmall.entiey.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findByUserAndStatusNotOrderById(User user, String status);
}
