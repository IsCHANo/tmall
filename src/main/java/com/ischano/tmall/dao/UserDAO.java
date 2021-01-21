package com.ischano.tmall.dao;

import com.ischano.tmall.entiey.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User getByName(String name);

    User getByNameAndPassword(String name, String password);
}
