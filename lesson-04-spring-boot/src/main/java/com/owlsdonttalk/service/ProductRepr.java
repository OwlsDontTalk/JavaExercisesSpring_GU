package com.owlsdonttalk.service;

import com.owlsdonttalk.persist.Product;
import javax.validation.constraints.NotEmpty;

public class ProductRepr {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private int price;

    public ProductRepr(){}

    public ProductRepr(String name) {
        this.name = name;
    }

    public ProductRepr(Product product){
        this.id = product.getId();
        this.description = product.getDescription();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
