package com.example.shopsb2c22.dals;

import com.example.shopsb2c22.domains.Product;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalImage extends Conn implements IDAL<Product> {
    public DalImage() {
        super();
        this.setTableName("products");
    }


    public ArrayList<Product> getByProductId(Long productId) {
        this.getListQuery = "SELECT * FROM " + this.getTableName() + " WHERE product_id = " + productId;
        try {
            Statement stm = this.conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {

            }
        } catch (Exception e) {

        }
        return null;
    }


    @Override
    public ArrayList<Product> getList(int page, int limit, String orderBy, String orderType) {
        return null;
    }

    @Override
    public boolean add(Product obj) {
        return false;
    }

    @Override
    public boolean update(Product obj) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Product getOne(Long id) {
        return null;
    }

    @Override
    public Double getTotal() {
        return null;
    }
}
