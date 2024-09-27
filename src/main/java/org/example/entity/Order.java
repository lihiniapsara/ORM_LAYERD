package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Order {
    @Id
    private String id;
    private double price;
    private String qtyy;


    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "order")
    private List<Item> item = new ArrayList<>();

   /* public Order(String id, double price, int qty, Customer customer) {
        this.id = id;
        this.price = price;
        this.qty = qty;
        this.customer = customer;
    }*/

    public Order(String oid, double tot, int qtyy, Customer customer) {
    }

    public Order(String id, double price, String qtyy, Customer customer, List<Item> item) {
        this.id = id;
        this.price = price;
        this.qtyy = qtyy;
        this.customer = customer;
        this.item = item;
    }

    public Order(String id, double price, String qtyy, Customer customer) {
        this.id = id;
        this.price = price;
        this.qtyy = qtyy;
        this.customer = customer;
    }

    public <E> List<E> getItem() {
        return null;
    }
}
