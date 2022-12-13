package com.coderslab.dzien3;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor
public class CartItem {

    private String name;
    private int quantity;

    private double price;

    protected static List<CartItem> cartItems = new ArrayList<>();
}
