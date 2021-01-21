package com.ischano.tmall.comparator;

import java.util.Comparator;

import com.ischano.tmall.entiey.Product;

public class ProductPriceComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return (int) (p1.getPromotePrice()-p2.getPromotePrice());
    }

}