package com.hackathon3.api.entities;

import com.hackathon3.api.enums.OrderStatus;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Date date;

    @ManyToMany
    @JoinTable(
        name = "Order_Product_Associations",
        joinColumns = @JoinColumn( name = "order_id"),
        inverseJoinColumns = @JoinColumn( name = "product_id")
    )
    private List<Product> productList;

    @Column
    @NotNull
    private OrderStatus status;

    @OneToMany(mappedBy = "customer")
    @NotNull
    private Customer customer;

    @OneToMany(mappedBy = "address")
    @NotNull
    private Address deliveryAddress;

    @OneToMany(mappedBy = "address")
    @JoinColumn(name = "billingAddress")
    private Address billingAddress;

    public Order() { }


    public boolean isDeliverable() {
        if(getStatus() == OrderStatus.PENDING) {
            return true;
        }
        return false;
    }

    public boolean isSent() {
        if(getStatus() == OrderStatus.ONGOING) {
            return true;
        }
        return false;
    }

    public boolean isDelivered() {
        if(getStatus() == OrderStatus.DELIVERED) {
            return true;
        }
        return false;
    }

    public boolean isCancelled() {
        if(getStatus() == OrderStatus.CANCELLED) {
            return true;
        }
        return false;
    }

    //Getters
    public OrderStatus getStatus() {
        return status;
    }
    public Long getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public List<Product> getProductList() {
        return productList;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Address getDeliveryAddress() {
        return deliveryAddress;
    }
    public Address getBillingAddress() {
        return billingAddress;
    }

    //Setters
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
