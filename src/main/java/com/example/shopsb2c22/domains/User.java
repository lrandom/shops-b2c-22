package com.example.shopsb2c22.domains;

import lombok.Data;

@Data
public class User {


    public static final String COL_ID = "id";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";
    public static final String COL_PHONE = "phone";
    public static final String COL_ADDRESS = "address";
    public static final String COL_PERMISSION = "permission";

    private Long id;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Integer permission = 3; // 1- admin , 2- staff, 3 - user


    public String getPermissionName() {
        if (permission == 1) {
            return "admin";
        } else if (permission == 2) {
            return "staff";
        } else if (permission == 3) {
            return "user";
        }
        return "";
    }
}
