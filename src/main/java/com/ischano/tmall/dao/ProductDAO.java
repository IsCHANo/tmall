package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Category;
import com.ischano.tmall.entiey.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);

    List<Product> findByCategoryOrderById(Category category);

    List<Product> findByNameLike(String keyword, Pageable pageable);
}
