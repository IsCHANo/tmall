package com.ischano.tmall.controller;

import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.service.ProductImageService;
import com.ischano.tmall.service.ProductService;
import com.ischano.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductImageService productImageService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(
            @PathVariable("cid") int cid,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;

        Page4Navigator<Product> page = productService.list(cid, start, size, 5);

        productImageService.setFirstProdutImages(page.getContent());

        return page;
    }
    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) throws Exception {
        return productService.get(id);
    }
    @PostMapping("/products")
    public Product add(@RequestBody Product product) throws Exception {
        product.setCreateDate(new Date());
        productService.add(product);
        return product;
    }
    @DeleteMapping("/products/{id}")
    public Product delete(@PathVariable("id")int id) throws Exception {
        productService.delete(id);
        return null;
    }
    @PutMapping("/products")
    public Product update(@RequestBody Product product) throws Exception {
        productService.update(product);
        return product;
    }
}
