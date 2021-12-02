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
        ArrayList<Product> list = new ArrayList<Product>();
        int offset = (page - 1) * limit;
        this.getListQuery = "SELECT products.id,products.name,products.price," +
                "products.category_id," +
                "products.quantity,category.name as category_name, " +
                "images.path as image_path FROM " + this.getTableName() +
                " LEFT JOIN category ON products.category_id=category.id" +
                " LEFT JOIN images ON products.id = images.product_id GROUP BY products.id " +
                "ORDER BY " + orderBy + " " + orderType + " LIMIT " + offset + "," + limit;
        System.out.println(this.getListQuery);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong(Product.COL_ID));
                product.setName(rs.getString(Product.COL_NAME));
                product.setPrice(rs.getDouble(Product.COL_PRICE));
                product.setCategoryName(rs.getString(Product.COL_CATEGORY_NAME));
                product.setQuantity(rs.getInt(Product.COL_QUANTITY));
                product.setImagePath(rs.getString(Product.COL_IMAGE_PATH));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        return list;
    }

    public ArrayList<Product> getProductByKeyword(String keyword, int page, int limit, String orderBy, String orderType) {
        ArrayList<Product> list = new ArrayList<Product>();
        int offset = (page - 1) * limit;
        this.getListQuery = "SELECT products.id,products.name,products.price," +
                "products.category_id," +
                "products.quantity,category.name as category_name, " +
                "images.path as image_path FROM " + this.getTableName() +
                " LEFT JOIN category ON products.category_id=category.id" +
                " LEFT JOIN images ON products.id = images.product_id WHERE (products.name LIKE '%" + keyword + "%' OR products.content LIKE  '%" + keyword + "%')  GROUP BY products.id " +
                "ORDER BY " + orderBy + " " + orderType + " LIMIT " + offset + "," + limit;
        System.out.println(this.getListQuery);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong(Product.COL_ID));
                product.setName(rs.getString(Product.COL_NAME));
                product.setPrice(rs.getDouble(Product.COL_PRICE));
                product.setCategoryName(rs.getString(Product.COL_CATEGORY_NAME));
                product.setQuantity(rs.getInt(Product.COL_QUANTITY));
                product.setImagePath(rs.getString(Product.COL_IMAGE_PATH));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        return list;
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
        ArrayList<Product> list = new ArrayList<Product>();
        this.getListQuery = "SELECT * FROM " + this.getTableName() + " WHERE " + Product.COL_ID + " = " + id;
        Product product = new Product();
        System.out.println(this.getListQuery);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(this.getListQuery);
            while (rs.next()) {
                product.setId(rs.getLong(Product.COL_ID));
                product.setName(rs.getString(Product.COL_NAME));
                product.setPrice(rs.getDouble(Product.COL_PRICE));
                product.setCategoryName(rs.getString(Product.COL_CATEGORY_NAME));
                product.setQuantity(rs.getInt(Product.COL_QUANTITY));
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
        return product;
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
