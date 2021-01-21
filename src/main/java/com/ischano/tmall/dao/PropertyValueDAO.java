package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.Property;
import com.ischano.tmall.entiey.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyValueDAO extends JpaRepository<PropertyValue, Integer> {
    List<PropertyValue> findByProductOrderById(Product product);

    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
