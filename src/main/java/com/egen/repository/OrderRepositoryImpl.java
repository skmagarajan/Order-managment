package com.egen.repository;

import com.egen.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Override
    public List<Order> getAllOrders() {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getAllOrders", Order.class);
        return query.getResultList();
    }

    @Override
    public Order getOrderById(String id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> getAllOrdersWithinInterval(java.sql.Date startTime, java.sql.Date endTime) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getOrdersWithinInterval", Order.class);
        query.setParameter("start", startTime);
        query.setParameter("end", endTime);
        return query.getResultList();
    }

    @Override
    public List<Order> getTop10OrdersWithHighestDollarAmountInZip(String zip) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.getTop10OrdersWithHighestDollarAmountInZip", Order.class);
        query.setParameter("zip",zip);
        return query.setMaxResults(10).getResultList();
    }

    @Override
    public Order placeOrder(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public Order update(Order order) {
        return entityManager.merge(order);
    }
}
