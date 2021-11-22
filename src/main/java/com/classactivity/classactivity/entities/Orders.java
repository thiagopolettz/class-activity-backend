package com.classactivity.classactivity.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Orders implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long orderNumber;
    private String orderEmissionDate;
    @ManyToOne
    private Clients client;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orders")
    private List<Products> products = new ArrayList<Products>();

    public Orders(){

    }

    public Orders(Long orderId){
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderEmissionDate() {
        return orderEmissionDate;
    }

    public void setOrderEmissionDate(String orderEmissionDate) {
        this.orderEmissionDate = orderEmissionDate;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
