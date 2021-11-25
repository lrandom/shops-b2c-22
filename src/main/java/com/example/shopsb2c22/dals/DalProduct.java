package com.example.shopsb2c22.dals;

import com.example.shopsb2c22.domains.Product;
import com.example.shopsb2c22.domains.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DalProduct extends Conn implements IDAL<Product> {
    public DalProduct() {
        super();
        this.setTableName("products");
    }

    @Override
    public ArrayList<Product> getList(int page, int limit, String orderBy, String orderType) {
        return null;
    }

    @Override
    public boolean add(Product obj) {
        try {
            PreparedStatement preparedStatement = _insertProduct(obj);
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return false;
    }

    private PreparedStatement _insertProduct(Product obj) throws SQLException {
        this.addQuery = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?,?,?)",
                this.getTableName(), Product.COL_NAME, Product.COL_CONTENT, Product.COL_META_KEYWORD,
                Product.COL_META_DESCRIPTION, Product.COL_META_TITLE, Product.COL_PRICE, Product.COL_QUANTITY, Product.COL_CATEGORY_ID);
        PreparedStatement preparedStatement = conn.prepareStatement(this.addQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getContent());
        preparedStatement.setString(3, obj.getMeta_keyword());
        preparedStatement.setString(4, obj.getMeta_description());
        preparedStatement.setString(5, obj.getMeta_title());
        preparedStatement.setDouble(6, obj.getPrice());
        preparedStatement.setInt(7, obj.getQuantity());
        preparedStatement.setLong(8, obj.getCategoryId());
        return preparedStatement;
    }

    public long addAndGetId(Product obj) {
        try {
            PreparedStatement preparedStatement = _insertProduct(obj);
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                ResultSet rsKey = preparedStatement.getGeneratedKeys();
                if (rsKey.next()) {
                    return rsKey.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return 0;
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
