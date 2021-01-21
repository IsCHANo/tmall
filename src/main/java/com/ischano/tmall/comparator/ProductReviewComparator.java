package com.ischano.tmall.comparator;

import com.ischano.tmall.entiey.Product;

import java.util.Comparator;

public class ProductReviewComparator implements Comparator<Product> {

    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()-p1.getReviewCount();
    }
}
