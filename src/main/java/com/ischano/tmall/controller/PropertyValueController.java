package com.ischano.tmall.controller;

import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.PropertyValue;
import com.ischano.tmall.service.ProductService;
import com.ischano.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) throws Exception {
        Product product = productService.get(pid);
        propertyValueService.init(product);
        return propertyValueService.list(product);
    }

    @PutMapping("/propertyValues")
    public PropertyValue update(@RequestBody PropertyValue propertyValue) throws Exception {
        propertyValueService.update(propertyValue);
        return propertyValue;
    }
}
