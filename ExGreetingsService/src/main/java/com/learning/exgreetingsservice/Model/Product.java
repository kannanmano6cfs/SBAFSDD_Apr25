package com.learning.exgreetingsservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String prdname;
    private String prddesc;
    private double prdprice;

    public Product() {}
    public Product(int id, String prdname, String prddesc, double prdprice) {

        this.id = id;
        this.prdname = prdname;
        this.prddesc = prddesc;
        this.prdprice = prdprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrddesc() {
        return prddesc;
    }

    public void setPrddesc(String prddesc) {
        this.prddesc = prddesc;
    }

    public double getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(double prdprice) {
        this.prdprice = prdprice;
    }
}
