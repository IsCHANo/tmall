package com.ischano.tmall.dao;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.ischano.tmall.entiey.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Integer>{
}
