/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.dto.*;
import models.utils.DBConnector;
import java.util.*;

public class UserDAO {
    private final String SQL_CREATE="Insert into Users (User_Name, User_SirName, BirthDay, PhoneNumber, ID_Number, Andress, Password) "
                                            + "values (?,?,?,?,?,?,?)",
                            SQL_READALL = "Select * from Users",
                            SQL_READ_BY_NAME = "Select * from Users where User_Name = ?",
                            SQL_READ_BY_ID = "Select * from Users where User_ID = ?",
                            SQL_UPDATE = "Update Users set "
                                            + "User_Name=?, "
                                            + "User_SirName=?, "
                                            + "BirthDay=?, "
                                            + "PhoneNumber=?, "
                                            + "ID_Number=?, "
                                            + "Andress=?, "
                                            + "Password = ? "
                                            + " where User_ID=?",
                            SQL_DELETE = "Delete from Users where User_ID=?";
    Connection conn;
    PreparedStatement prs;
    
    public UserDAO(){
        this.conn = new DBConnector().getConn();
    }
    
    public int create(User user){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setString(1, user.getUserName());
            prs.setString(2, user.getUserSirName());
            prs.setString(3, user.getBirthDay());
            prs.setString(4, user.getPhoneNumber());
            prs.setString(5, user.getiD_Number());
            prs.setString(6, user.getAndress());
            prs.setString(7, user.getPassword());
            int newCreate = prs.executeUpdate();
            System.out.println("create succesfully");
            return newCreate;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public List<User> readAll(){
        try {
            List<User> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                User us = new User( res.getInt("User_ID"), res.getString("User_Name"), res.getString("User_SirName"), 
                                    res.getString("BirthDay"), res.getString("PhoneNumber"), 
                                        res.getString("ID_Number"), res.getString("Andress"), res.getString("Password"));
                list.add(us);
//                System.out.println(us);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<User> readByName(String name){
        try {
            List<User> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READ_BY_NAME);
            prs.setString(1, name);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                User us = new User(res.getInt("User_ID"), res.getString("User_Name"), res.getString("User_SirName"), 
                                    res.getString("BirthDay"), res.getString("PhoneNumber"), 
                                        res.getString("ID_Number"), res.getString("Andress"), res.getString("Password"));
                list.add(us);
//                System.out.println(us);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public User readByID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                User us = new User(res.getInt("User_ID"), res.getString("User_Name"), res.getString("User_SirName"), 
                                    res.getString("BirthDay"), res.getString("PhoneNumber"), 
                                        res.getString("ID_Number"), res.getString("Andress"), res.getString("Password"));
//                System.out.println(us);
                return us;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int update(User us){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setString(1, us.getUserName());
            prs.setString(2, us.getUserSirName());
            prs.setString(3, us.getBirthDay());
            prs.setString(4, us.getPhoneNumber());
            prs.setString(5, us.getiD_Number());
            prs.setString(6, us.getAndress());
            prs.setString(7, us.getPassword());
            prs.setInt(8, us.getUserID());
            int newUpdate = prs.executeUpdate();
            System.out.println(newUpdate!=0 ? "update succesfully" : "failed");
            return newUpdate;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int delete(int id){
        try {
            prs=conn.prepareCall(SQL_DELETE);
            prs.setInt(1, id);
            int del = prs.executeUpdate();
            System.out.println(del!=0 ? "delete suscessfully" : "failed");
            return del;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
//        User us = new User(0, "Khoi", "Nguyen Ngoc", "10/03/1995", "055151511202", "0154521154", "Thua Thien Hue", "hahah");

        User us = new User(2, "Hiệu", "Nguyễn Văn", "10/05/1997", "01515185", "05412548", "Da Nang","vanhieu");
//        User us2 = new User(2, "Chinh", "Nguyen Huu", "16/03/1995", "25451035648", "0254512015", "Quang Ninh", "ldijf");
//        User us3 = new User(0, "usern", "userSir", "18/02/1998", "554554154851", "574112222222228", "Quang Binh", "password");
//        
        UserDAO dao = new UserDAO();
//        
        dao.create(us);
//        dao.create(us2);
//        dao.create(us3);
    }
}
