package com.egen.service;

import com.egen.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    List<Order> getAllOrdersWithinInterval(String startTime, String endTime);
    List<Order> getTop10OrdersWithHighestDollarAmountInZip(String zip);
    Order placeOrder(Order order);
    void delete(String id);
    Order update(String id, Order order);
}
