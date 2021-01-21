package com.ischano.tmall.controller;

import com.ischano.tmall.entiey.Property;
import com.ischano.tmall.service.PropertyService;
import com.ischano.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(
            @PathVariable("cid") int cid,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return propertyService.list(cid, start, size, 5);
    }

    @PostMapping("/properties")
    public Property add(@RequestBody Property property) throws Exception {
        propertyService.add(property);
        return property;
    }

    @DeleteMapping("/properties/{id}")
    public Property delete(@PathVariable("id") int id) throws Exception {
        propertyService.delete(id);
        return null;
    }

    @GetMapping("properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception {
        return propertyService.get(id);
    }

    @PutMapping("properties")
    public Property update(@RequestBody Property property) throws Exception {
        propertyService.update(property);
        return property;
    }
}
