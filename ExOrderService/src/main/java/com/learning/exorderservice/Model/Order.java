package com.learning.exorderservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="orders")
public class Order {

    @Id
    @GeneratedValue
    int id;
    int prdid;
    String prdname;
    int quantity;

    public Order() {
    }

    public Order(int id, int prdid, String prdname, int quantity) {
        this.id = id;
        this.prdid = prdid;
        this.prdname = prdname;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrdid() {
        return prdid;
    }

    public void setPrdid(int prdid) {
        this.prdid = prdid;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
