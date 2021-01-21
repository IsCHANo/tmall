package com.ischano.tmall.service;

import com.ischano.tmall.dao.OrderItemDAO;
import com.ischano.tmall.entiey.Order;
import com.ischano.tmall.entiey.OrderItem;
import com.ischano.tmall.entiey.Product;
import com.ischano.tmall.entiey.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ProductImageService productImageService;

    public void update(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    public void fill(List<Order> orders) {
        for (Order order : orders) {
            fill(order);
        }
    }

    public void fill(Order order) {
        List<OrderItem> orderItems = listByOrder(order);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getNumber() * orderItem.getProduct().getPromotePrice();
            totalNumber += orderItem.getNumber();
            productImageService.setFirstProdutImage(orderItem.getProduct());
        }
        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItems);
    }

    public void add(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    public OrderItem get(int id) {
        return orderItemDAO.getOne(id);
    }

    public void delete(int id) {
        orderItemDAO.delete(id);
    }

    public int getSaleCount(Product product) {
        List<OrderItem> orderItems = listByProduct(product);
        int result = 0;
        for (OrderItem orderItem : orderItems) {
            if (null != orderItem.getOrder() && null != orderItem.getOrder().getPayDate()) {
                result += orderItem.getNumber();
            }
        }
        return result;
    }
    public List<OrderItem> listByOrder(Order order) {
        return orderItemDAO.findByOrder(order);
    }

    public List<OrderItem> listByProduct(Product product) {
        return orderItemDAO.findByProduct(product);
    }

    public List<OrderItem> listByUser(User user) {
        return orderItemDAO.findByUserAndOrderIsNull(user);
    }
}
