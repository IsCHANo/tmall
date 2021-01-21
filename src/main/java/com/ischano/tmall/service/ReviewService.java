package com.ischano.tmall.service;

import com.ischano.tmall.dao.ReviewDAO;
import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewDAO reviewDAO;
    @Autowired
    ProductService productService;

    public void add(Review review) {
        reviewDAO.save(review);
    }

    public List<Review> list(Product product) {
        return reviewDAO.findByProductOrderById(product);
    }

    public int getCount(Product product) {
        return reviewDAO.countByProduct(product);
    }
}
