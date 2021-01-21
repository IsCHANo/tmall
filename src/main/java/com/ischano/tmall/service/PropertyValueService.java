package com.ischano.tmall.service;

import com.ischano.tmall.dao.PropertyValueDAO;
import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.Property;
import com.ischano.tmall.entiey.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;
    @Autowired
    PropertyService propertyService;

    @CacheEvict(allEntries = true)
    public void update(PropertyValue propertyValue) {
        propertyValueDAO.save(propertyValue);
    }

    public void init(Product product) {
        //查询当前分类下的所有属性
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        for (Property property : properties) {
            PropertyValue propertyValue = getByPropertyAndProduct(property, product);
            if (null == propertyValue) {
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    public PropertyValue getByPropertyAndProduct(Property property, Product product) {
        return propertyValueDAO.getByPropertyAndProduct(property, product);
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueDAO.findByProductOrderById(product);
    }
}
