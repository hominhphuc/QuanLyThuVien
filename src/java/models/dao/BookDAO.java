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
import models.utils.DBConnector;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.dto.*;

/**
 *
 * @author USER
 */
public class BookDAO {
    private final String SQL_CREATE="Insert into Books ( BookName, Author, Publisher, DayOfPublish, Quantity, Position) "
                                            + "values (?,?,?,?,?,?)",
                            SQL_READALL = "Select * from Books",
                            SQL_READ_BY_AUTHOR = "Select * from Books where Author = ?",
                            SQL_READ_BY_ID = "Select * from Books where Book_ID = ?",
                            SQL_UPDATE = "Update Books set "
                                            + "BookName=?,"
                                            + "Author=?,"
                                            + "Publisher=?,"
                                            + "DayOfPublish=?,"
                                            + "Quantity=?,"
                                            + "Position=?"
                                            + " where Book_ID=?",
                            SQL_DELETE = "Delete from Books where Book_ID=?";
    Connection conn;
    PreparedStatement prs;
    
    public BookDAO(){
        this.conn = new DBConnector().getConn();
    }
    
    public int create(Book book){
        try {
            prs = conn.prepareStatement(SQL_CREATE);
            prs.setString(1, book.getBookName());
            prs.setString(2, book.getAuthor());
            prs.setString(3, book.getPublisher());
            prs.setString(4, book.getDayOfPublish());
            prs.setInt(5, book.getQuantity());
            prs.setString(6, book.getPosition());
            int newCreate = prs.executeUpdate();
            System.out.println("create succesfully");
            return newCreate;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public List<Book> readAll(){
        try {
            List<Book> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Book bo = new Book( res.getInt("Book_ID"),res.getString("BookName"), res.getString("Author"), 
                                    res.getString("Publisher"), res.getString("DayOfPublish"), 
                                        res.getInt("Quantity"), res.getString("Position"));
                list.add(bo);
//                System.out.println(bo);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Book> readByAuthor(String aut){
        try {
            List<Book> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READ_BY_AUTHOR);
            prs.setString(1, aut);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Book bo = new Book( res.getInt("Book_ID"), res.getString("BookName"), res.getString("Author"), 
                                    res.getString("Publisher"), res.getString("DayOfPublish"), 
                                        res.getInt("Quantity"), res.getString("Position"));
                list.add(bo);
//                System.out.println(bo);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Book readByID(int id){
        try {
            prs = conn.prepareStatement(SQL_READ_BY_ID);
            prs.setInt(1, id);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                Book bo = new Book( res.getInt("Book_ID"), res.getString("BookName"), res.getString("Author"), 
                                    res.getString("Publisher"), res.getString("DayOfPublish"), 
                                        res.getInt("Quantity"), res.getString("Position"));
//                System.out.println(bo);
                return bo;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int update(Book book){
        try {
            prs = conn.prepareStatement(SQL_UPDATE);
            prs.setString(1, book.getBookName());
            prs.setString(2, book.getAuthor());
            prs.setString(3, book.getPublisher());
            prs.setString(4, book.getDayOfPublish());
            prs.setInt(5, book.getQuantity());
            prs.setString(6, book.getPosition());
            prs.setInt(7, book.getBookID());
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
    
//    public static void main(String[] args) {
//        BookDAO dao = new BookDAO();
//        Book book = new Book(3, "kfjn lk", "lndlkb l ", "dshj kj ", "dffas  d ", 44, "8b");
////        Book book1 = new Book(3, "kfsdfgadjn lk", "lnasdcdlkb l ", "dshj dgfvzskj ", "dffas dfhg d ", 70, "8c");
////        Book book2 = new Book(3, "kfjdfhn lk", "lndlkb l ", "dshj kj ", "dffas fcgh d ", 110, "3b");
////        Book book3 = new Book(3, "kfjnsfx lk", "lndlkb ddrl ", "dshj trsyskj ", "dffas thdhs d ", 64, "4a");
//////        List<Book> list = dao.readByAuthor("lndlkb l");
//////        int b = dao.delete(1);
//////        System.out.println(b);
////        dao.create(book);
////        dao.create(book1);
////        dao.create(book2);
////        dao.create(book);
//        System.out.println(book==null);
//            new BookDAO().delete(4);
//    }
}
