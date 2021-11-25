package com.example.shopsb2c22.domains;


import lombok.Data;

@Data
public class Category {
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    private Long id;
    private String name;
}
