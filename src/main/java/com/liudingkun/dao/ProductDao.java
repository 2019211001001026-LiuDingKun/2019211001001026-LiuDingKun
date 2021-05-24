package com.liudingkun.dao;

import com.liudingkun.model.Product;
import com.liudingkun.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from Product where productId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, String.valueOf(productId));
        int res=ps.executeUpdate();
        return res;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update Product set ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? where ProductId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,instance.getProductName());
        ps.setString(2,instance.getProductDescription());
        ps.setBinaryStream(3,instance.getPicture());
        ps.setDouble(4,instance.getPrice());
        ps.setString(5,String.valueOf(instance.getCategoryId()));
        ps.setString(6,String.valueOf(instance.getProductId()));
        int res=ps.executeUpdate();
        return res;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql="select * from Product where ProductId=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(productId));
        ResultSet rs=st.executeQuery();
        Product product=null;
        while (rs.next()){
            product=new Product();
            product.setProductId(Integer.parseInt(rs.getString("ProductId")));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql="select * from Product where CategoryId=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(categoryId));
        ResultSet rs=st.executeQuery();
        List<Product> List=new ArrayList<>();
        Product product=null;
        while (rs.next()){
            product=new Product();
            product.setProductId(Integer.parseInt(rs.getString("ProductId")));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql="select ProductId,ProductName,ProductDescription,Picture,Price,CategoryId from Product where Price between ? and ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(minPrice));
        st.setString(2, String.valueOf(maxPrice));
        ResultSet rs=st.executeQuery();
        List<Product> List=new ArrayList<>();
        Product product=null;
        if (rs.next()){
            product=new Product();
            product.setProductId(Integer.parseInt(rs.getString("ProductId")));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql="select * from Product";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<Product> List=new ArrayList<>();
        Product product=null;
        while (rs.next()){
            product=new Product();
            product.setProductId(Integer.parseInt(rs.getString("ProductId")));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql="select ProductId,ProductName,ProductDescription,Picture,Price,CategoryId from Product where ProductName=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(productName));
        ResultSet rs=st.executeQuery();
        List<Product> List=new ArrayList<>();
        Product product=null;
        if (rs.next()){
            product=new Product();
            product.setProductId(Integer.parseInt(rs.getString("ProductId")));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            List.add(product);
        }
        return List;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql="select Picture from Product where ProductId=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(productId));
        ResultSet rs=st.executeQuery();
        List<Product> List=new ArrayList<>();
        Product product=null;
        while (rs.next()){
            product=new Product();
            product.setPicture(rs.getBinaryStream("Picture"));
            List.add(product);
        }
        return List;
    }

    public byte[] getPictureById(Integer productId, Connection con) throws SQLException {
        byte[] imgBytes=null;
        String sql="select picture from Product where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());
        }
        return imgBytes;
    }
}
