package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Integer> {
    List<Review> findByProductOrderById(Product product);

    int countByProduct(Product product);
}
