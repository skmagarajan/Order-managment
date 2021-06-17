package com.egen.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="orders")
@NamedQueries({
        @NamedQuery(name="Order.getAllOrders", query = "SELECT order FROM Order order"),
        @NamedQuery(name="Order.getOrdersWithinInterval", query="SELECT order FROM Order order where order.dateCreated>:start and order.dateCreated<:end"),
        @NamedQuery(name="Order.getTop10OrdersWithHighestDollarAmountInZip", query="SELECT order FROM Order order where order.billingAddress.zip=:zip order by order.payment.orderTotal DESC")
})

public class Order {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private String customerId;
    @OneToMany
    private List<Item> items;

    @OneToOne
    private Payment payment;
    @OneToOne
    private Billing billingAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    @OneToOne
    private Shipping shippingAddress;

    private Date dateCreated;
    private Date dateModified;

    public Order(){

    }

    public Order(String id){
        this.id = UUID.randomUUID().toString();
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Billing getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Billing billingAddress) {
        this.billingAddress = billingAddress;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Shipping getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Shipping shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderStatus=" + orderStatus +
                ", customerId='" + customerId + '\'' +
                ", items=" + items +
                ", payment=" + payment +
                ", billingAddress=" + billingAddress +
                ", deliveryType=" + deliveryType +
                ", shippingAddress=" + shippingAddress +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
