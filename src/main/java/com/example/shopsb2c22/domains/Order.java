package com.example.shopsb2c22.domains;


import lombok.Data;

@Data
public class Order {
    Long id;
    Double subTotal;
    Integer tax;
    Double total;
    Integer status; // 1- pending, 2- processing, 3- shipped, 4- delivered, 5- cancelled
    String note;
    String address;
    String phone;
}
