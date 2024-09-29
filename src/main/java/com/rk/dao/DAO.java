/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ranen
 */
public class DAO {
    public DAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String url = "jdbc:mysql://127.0.0.1:3306/db_users";
    String uname = "test";
    String pass = "test";
    Connection con = null;
    PreparedStatement ps = null;
    String query;
    public boolean checkUser(String struname, String strpass) {
        ResultSet rs = null;
        try {
            query = "SELECT username FROM tbl_users where username = ? and password = ?;";
            con = DriverManager.getConnection(url, uname, pass);
            ps = con.prepareStatement(query);
            ps.setString(1, struname);
            ps.setString(2, strpass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public int registerUser(String strfullname,String strusername,String strpassword){
        int result = 0;
        try{
            query = "insert into tbl_users (fullname,username,password,isactive,created_by) values (?,?,?,1,?);";
            con = DriverManager.getConnection(url, uname, pass);
            ps = con.prepareStatement(query);
            ps.setString(1, strfullname);
            ps.setString(2, strusername);
            ps.setString(3, strpassword);
            ps.setString(4, strfullname);
            result = ps.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
