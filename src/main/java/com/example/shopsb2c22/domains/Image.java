package com.example.shopsb2c22.domains;

import lombok.Data;

@Data
public class Image {
    public static final String COL_ID = "col_id";
    public static final String COL_PATH = "col_path";
    public static final String COL_PRODUCT_ID = "col_product_id";


    Long id;
    String path;
    Long productId;
}
