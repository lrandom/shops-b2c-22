package com.example.shopsb2c22.dals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.shopsb2c22.domains.User;

public class DalUser extends Conn implements IDAL<User> {
    String getListQuery;
    String addQuery;
    String updateQuery;
    String deleteQuery;

    public DalUser() {
        super();
        this.setTableName("users");
    }

    @Override
    public ArrayList getList(int page, int limit, String orderBy, String orderType) {
        ArrayList<User> list = new ArrayList<User>();
        int offset =(page - 1) * limit;
        this.getListQuery = "SELECT * FROM " + this.getTableName() + " ORDER BY " + orderBy + " " + orderType + " LIMIT " + offset + "," + limit;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(User.COL_ID));
                user.setEmail(rs.getString(User.COL_EMAIL));
                user.setPassword(rs.getString(User.COL_PASSWORD));
                user.setPermission(rs.getInt(User.COL_PERMISSION));
                user.setPhone(rs.getString(User.COL_PHONE));
                user.setAddress(rs.getString(User.COL_ADDRESS));
                list.add(user);
            }
        } catch (Exception e) {
            return null;
        }
        close();
        return list;
    }

    @Override
    public boolean add(User obj) {
        try {
            this.addQuery = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES(?,?,?,?,?)",
                    this.getTableName(), User.COL_EMAIL, User.COL_PASSWORD, User.COL_PERMISSION, User.COL_PHONE, User.COL_ADDRESS);
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
        close();
        return false;
    }

    @Override
    public boolean update(User obj) {
        try {
            this.updateQuery = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=? WHERE id=?",
                    this.getTableName(), User.COL_EMAIL, User.COL_PASSWORD, User.COL_PERMISSION, User.COL_PHONE);
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
        close();
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try {
            this.deleteQuery = String.format("DELETE FROM %s WHERE id=?", this.getTableName());
            PreparedStatement preparedStatement = conn.prepareStatement(this.deleteQuery);
            preparedStatement.setLong(1, id);
            int affectRow = preparedStatement.executeUpdate();
            if (affectRow > 0) {
                return true;
            }
        } catch (Exception e) {

        }
        close();
        return false;
    }

    @Override
    public User getOne(Long id) {
        try {
            User user = new User();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " WHERE id=" + id);
            while (rs.next()) {
                user.setId(rs.getLong(User.COL_ID));
                user.setEmail(rs.getString(User.COL_EMAIL));
                user.setPassword(rs.getString(User.COL_PASSWORD));
                user.setPermission(rs.getInt(User.COL_PERMISSION));
                user.setPhone(rs.getString(User.COL_PHONE));
                user.setAddress(rs.getString(User.COL_ADDRESS));
            }
            return user;
        } catch (Exception e) {

        }
        close();
        return null;
    }

    @Override
    public Double getTotal() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) as total_record FROM " + this.getTableName());
            while (rs.next()) {
                return rs.getDouble("total_record");
            }
        } catch (Exception e) {

        }

        return new Double(0);
    }
}
