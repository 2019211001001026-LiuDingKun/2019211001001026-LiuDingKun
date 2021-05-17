package com.liudingkun.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean active;

    public Category(){}

    public Category(int categoryId, String categoryName, String description, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from Category";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Category> List=new ArrayList<>();
        Category category=null;
        while (rs.next()){
            category=new Category();
            category.setCategoryId(Integer.parseInt(rs.getString("CategoryId")));
            category.setCategoryName(rs.getString("CategoryName"));
            category.setDescription(rs.getString("Description"));
            category.setActive(rs.getBoolean("Active"));
            List.add(category);
        }
        return List;
    }
    public static String FindByCategoryId(Connection con,int categoryId) throws SQLException {
        String sql="select * from Category where CategoryId=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(categoryId));
        ResultSet rs=st.executeQuery();
        String CategoryName=null;
        while (rs.next()){ ;
            CategoryName=rs.getString("CategoryName");
        }
        return CategoryName;
    }
}
