package com.example.shopsb2c22.domains;

import lombok.Data;

@Data
public class Product {

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_CONTENT = "content";
    public static final String COL_META_KEYWORD = "meta_keyword";
    public static final String COL_META_DESCRIPTION = "meta_description";
    public static final String COL_META_TITLE = "meta_title";
    public static final String COL_PRICE = "price";
    public static final String COL_QUANTITY = "quantity";
    public static final String COL_CATEGORY_ID = "category_id";
    public static final String COL_IMAGE_PATH = "image_path";
    public static final String COL_CATEGORY_NAME = "category_name";



    Long id;
    String name;
    String content;
    String meta_keyword;
    String meta_description;
    String meta_title;
    Double price;
    Integer quantity;
    Long categoryId;

    String categoryName;
    String imagePath;


}

