package com.example.shopsb2c22.dals;

import com.example.shopsb2c22.domains.Material;
import com.example.shopsb2c22.domains.Size;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalSize extends Conn implements IDAL<Size> {

    public DalSize() {
        super();
        this.setTableName("sizes");
    }

    @Override
    public ArrayList getList(int page, int limit, String orderBy, String orderType) {
        ArrayList<Size> list = new ArrayList<Size>();
        int offset = (page - 1) * limit;
        this.getListQuery = "SELECT * FROM " + this.getTableName() + " ORDER BY " + orderBy + " " + orderType + " LIMIT " + offset + "," + limit;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                Size size = new Size();
                size.setId(rs.getLong(Size.COL_ID));
                size.setName(rs.getString(Size.COL_NAME));
                list.add(size);
            }
        } catch (Exception e) {
            return null;
        }
        close();
        return list;
    }

    @Override
    public boolean add(Size obj) {
/*        try {
            this.addQuery = String.format("INSERT INTO %s(%s,%s) VALUES(?,?)",
                    this.getTableName(), Size.COL_EMAIL, Size.COL_PASSWORD, Size.COL_PERMISSION, Size.COL_PHONE, Size.COL_ADDRESS);
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
    public boolean update(Size obj) {/*
        try {
            this.updateQuery = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE id=?",
                    this.getTableName(), Size.COL_EMAIL, Size.COL_PASSWORD, Size.COL_PERMISSION, Size.COL_PHONE);
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
    public Size getOne(Long id) {
/*        try {
            Material size = new Material();
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


