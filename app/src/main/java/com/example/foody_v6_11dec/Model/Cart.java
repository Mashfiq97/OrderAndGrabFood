package com.example.foody_v6_11dec.Model;

public class Cart
{
    private String discount, name, price, quantity;

    public Cart() {
    }

    public Cart(String discount, String name, String price, String quantity) {
        this.discount = discount;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
