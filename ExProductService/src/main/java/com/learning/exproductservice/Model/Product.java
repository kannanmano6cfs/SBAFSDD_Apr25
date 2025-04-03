package com.learning.exproductservice.Model;

import com.learning.exproductservice.util.ValidProductName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Product {

    @Id
    @GeneratedValue
    int id;
    @ValidProductName
    String prdname;
    @PositiveOrZero(message="Invalid Product Price")
    String prdprice;
    @NotEmpty(message="Product description is required")
    String prddescription;
    @NotEmpty(message = "Product count is required")
    String prdcount;

    public Product(int id) {
        this.id = id;
    }
    public Product() {

    }

    public int getId() {
        return id;
    }

    public String getPrdname() {
        return prdname;
    }

    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    public String getPrdprice() {
        return prdprice;
    }

    public void setPrdprice(String prdprice) {
        this.prdprice = prdprice;
    }

    public String getPrddescription() {
        return prddescription;
    }

    public void setPrddescription(String prddescription) {
        this.prddescription = prddescription;
    }

    public String getPrdcount() {
        return prdcount;
    }

    public void setPrdcount(String prdcount) {
        this.prdcount = prdcount;
    }

    public void setId(int id) {
        this.id = id;
    }



}

