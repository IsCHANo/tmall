package com.ischano.tmall.service;

import com.ischano.tmall.dao.PropertyDAO;
import com.ischano.tmall.entiey.Category;
import com.ischano.tmall.entiey.Property;
import com.ischano.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property property) {
        propertyDAO.save(property);
    }

    public void delete(int id) {
        propertyDAO.delete(id);
    }

    public Property get(int id) {
       return propertyDAO.findOne(id);
    }

    public void update(Property property) {
        propertyDAO.save(property);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Property> pageFromJPA = propertyDAO.findByCategory(category, pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public List<Property> listByCategory(Category category) {
        return propertyDAO.findByCategory(category);
    }
}
