/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.dto.*;
import models.utils.DBConnector;

/**
 *
 * @author USER
 */
public class DealDAO {
    private final String SQL_CREATE="Insert into Deals ( User_ID, Book_ID, BorrowDay, ReturnDay) "
                                            + "values (?,?,?,?)",
                            SQL_READALL = "Select * from Deals",
                            SQL_READ_BY_USERID = "Select * from Deals where User_ID = ?",
                            SQL_READ_BY_BOOKID = "Select * from Deals where Book_ID = ?",
                            SQL_UPDATE = "Update Deals set "
                                            + "User_ID=?,"
                                            + "Book_ID=?,"
                                            + "BorrowDay = ?,"
                                            + "ReturnDay=? "
                                            + " where Deal_ID=?",
                            SQL_DELETE = "Delete from Deals where Deal_ID=?";
    Connection conn;
    PreparedStatement prs;
    
    public DealDAO(){
        this.conn = new DBConnector().getConn();
    }
    
    public int create(Deal de){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setInt(1, de.getUserID());
            prs.setInt(2, de.getBookID());
            prs.setString(3, de.getBorrowDay());
            prs.setString(4, de.getReturnDay());
            int newCreate = prs.executeUpdate();
            System.out.println("create succesfully");
            return newCreate;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public List<Deal> readAll(){
        try {
            List<Deal> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Deal de = new Deal(res.getInt("Deal_ID"), res.getInt("User_ID"),res.getInt("Book_ID"), 
                                    res.getString("BorrowDay"), res.getString("ReturnDay"));
                list.add(de);
                System.out.println(de);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Deal> readByUserID(int id){
        try {
            List<Deal> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READ_BY_USERID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Deal de = new Deal(0, res.getInt("User_ID"),res.getInt("Book_ID"), 
                                    res.getString("BorrowDay"), res.getString("ReturnDay"));
                list.add(de);
                System.out.println(de);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Deal>  readByBookID(int id){
        try {
            List<Deal> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READ_BY_BOOKID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Deal de = new Deal(0, res.getInt("User_ID"),res.getInt("Book_ID"), 
                                    res.getString("BorrowDay"), res.getString("ReturnDay"));
                list.add(de);
                System.out.println(de);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int update(Deal de){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setInt(1, de.getUserID());
            prs.setInt(2, de.getBookID());
            prs.setString(3, de.getBorrowDay());
            prs.setString(4, de.getReturnDay());
            prs.setInt(5, de.getDealID());
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
        DealDAO dao = new DealDAO();
        Deal de = new Deal(2, 3, 3, "22/05/2018", "10/06/2018");
        Deal de1 = new Deal(2, 3, 3, "25/05/2018", "03/06/2018");
        Deal de2 = new Deal(2, 3, 3, "28/03/2018", "30/04/2018");
        Deal de3 = new Deal(2, 1, 3, "24/07/2018", "30/07/2018");
        Deal de4 = new Deal(0, 2, 2, "29/06/2018", "01/07/2018");
        
        dao.create(de);
        dao.create(de1);
        dao.create(de2);
        dao.create(de3);
        dao.create(de4);
//        List<Deal> list = dao.readByBookID(2);
//        
//        System.out.println(list.size());
//
//        dao.delete(3);
    }
}
