package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class customer {


    @Id
    @GeneratedValue
    int id;
    String customername;
    String bookprice;
    String bookdescription;
    String bookcount;
    public customer(int id) {
        this.id = id;
    }
    public customer() {

    }

    public int getId() {
        return id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookdescription() {
        return bookdescription;
    }

    public void setBookdescription(String bookdescription) {
        this.bookdescription = bookdescription;
    }

    public String getBookcount() {
        return bookcount;
    }

    public void setBookcount(String bookcount) {
        this.bookcount = bookcount;
    }

}
