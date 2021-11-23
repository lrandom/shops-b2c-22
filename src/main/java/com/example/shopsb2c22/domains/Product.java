package com.example.shopsb2c22.domains;

import lombok.Data;

@Data
public class Product {
    Long id;
    String name;
    String content;
    String meta_keyword;
    String meta_description;
    String meta_title;
    Double price;
    Integer quantity;
}

