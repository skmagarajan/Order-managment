package com.egen.repository;

import com.egen.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    List<Order> getAllOrdersWithinInterval(java.sql.Date startTime, java.sql.Date endTime);
    List<Order> getTop10OrdersWithHighestDollarAmountInZip(String zip);
    Order placeOrder(Order order);
    void delete(Order order);
    Order update(Order order);
}
