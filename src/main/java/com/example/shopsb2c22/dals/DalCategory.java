package com.example.shopsb2c22.dals;

import com.example.shopsb2c22.domains.Category;
import com.example.shopsb2c22.domains.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalCategory extends Conn implements IDAL<Category> {
    String getListQuery;


    public DalCategory() {
        super();
        this.setTableName("category");
    }

    @Override
    public ArrayList getList(int page, int limit, String orderBy, String orderType) {
        ArrayList<Category> list = new ArrayList<Category>();
        int offset = (page - 1) * limit;
        this.getListQuery = "SELECT * FROM " + this.getTableName() + " ORDER BY " + orderBy + " " + orderType + " LIMIT " + offset + "," + limit;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getLong(Category.COL_ID));
                category.setName(rs.getString(Category.COL_NAME));
                list.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        close();
        return list;
    }

    @Override
    public boolean add(Category obj) {
/*        try {
            this.addQuery = String.format("INSERT INTO %s(%s,%s) VALUES(?,?)",
                    this.getTableName(), Category.COL_EMAIL, Category.COL_PASSWORD, Category.COL_PERMISSION, Category.COL_PHONE, Category.COL_ADDRESS);
            PreparedStatement preparedStatement = conn.prepareStatement(this.addQuery);
            preparedStatement.setString(1, obj.getEmail());
            preparedStatement.setString(2, obj.getPassword());
            preparedStatement.setInt(3, obj.getPermission());
            preparedStatement.setString(4, obj.getPhone());
            preparedStatement.setString(5, obj.getAddress());
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();*/
        return false;
    }

    @Override
    public boolean update(Category obj) {/*
        try {
            this.updateQuery = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE id=?",
                    this.getTableName(), Category.COL_EMAIL, Category.COL_PASSWORD, Category.COL_PERMISSION, Category.COL_PHONE);
            PreparedStatement preparedStatement = conn.prepareStatement(this.updateQuery);
            preparedStatement.setString(1, obj.getEmail());
            preparedStatement.setString(2, obj.getPassword());
            preparedStatement.setInt(3, obj.getPermission());
            preparedStatement.setString(4, obj.getPhone());
            preparedStatement.setLong(5, obj.getId());
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        close();*/
        return false;
    }

    @Override
    public boolean delete(Long id) {
/*        try {
            this.deleteQuery = String.format("DELETE FROM %s WHERE id=?", this.getTableName());
            PreparedStatement preparedStatement = conn.prepareStatement(this.deleteQuery);
            preparedStatement.setLong(1, id);
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        close();*/
        return false;
    }

    @Override
    public Category getOne(Long id) {
/*        try {
            Category category = new Category();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " WHERE id=" + id);
            while (rs.next()) {
                category.setId(rs.getLong(Category.COL_ID));
                category.setEmail(rs.getString(Category.COL_EMAIL));
                category.setPassword(rs.getString(Category.COL_PASSWORD));
                category.setPermission(rs.getInt(Category.COL_PERMISSION));
                category.setPhone(rs.getString(Category.COL_PHONE));
                category.setAddress(rs.getString(Category.COL_ADDRESS));
            }
            return category;
        } catch (Exception e) {

        }
        close();*/
        return null;
    }

    @Override
    public Double getTotal() {
/*
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) as total_record FROM " + this.getTableName());
            while (rs.next()) {
                return rs.getDouble("total_record");
            }
        } catch (Exception e) {

        }
*/

        return new Double(0);
    }
}
