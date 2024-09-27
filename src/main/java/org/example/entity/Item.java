package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Item {
    @Id
    private String id;
    private String name;
    private String price;
    private String qty;

    public Item(String iid, String des, double price, int qty) {
    }
    @ManyToMany
    private List<Order> order = new ArrayList<>();


    public Item(String id, String name, String price, String qty, List<Order> order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.order = order;
    }

    public Item() {

    }

    public Item(String id, String name, String price, String qty) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}


