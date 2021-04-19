package com.liudingkun.dao;

import com.liudingkun.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.sql.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getId());
        ps.setString(2,user.getUsername());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getEmail());
        ps.setString(5,user.getGender());
        ps.setDate(6,user.getBirthdate());
        ps.executeUpdate();
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getId());
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set password=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getPassword());
        ps.setString(2,user.getId());
        return 0;
    }

    @Override
    public User findById(Connection con, String id) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where id=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where username=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where password=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where email=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where gender=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setString(1, gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select id,username,password,email,gender,birthdate from usertable where birthDate=? ";
        PreparedStatement st=con.prepareCall(sql);
        st.setDate(1, birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from usertable";
        PreparedStatement st=con.prepareCall(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPassword(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return Collections.singletonList(user);
    }
}
