package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageDAO extends JpaRepository<ProductImage, Integer> {
    public List<ProductImage> findByProductAndTypeOrderById(Product product, String type);
}
