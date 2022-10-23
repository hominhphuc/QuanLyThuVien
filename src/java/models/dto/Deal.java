/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author USER
 */
public class Deal implements Serializable, Comparable<Deal>{
    private int userID, bookID,dealID;
    private String  borrowDay, returnDay;

    public Deal(int dealID, int userID, int bookID, String borrowDay, String returnDay) {
        this.dealID = dealID;
        this.userID = userID;
        this.bookID = bookID;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Deal() {
    }

    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(String borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    @Override
    public int compareTo(Deal o) {
        long bor1= Date.parse(this.borrowDay), bor2=Date.parse(o.getBorrowDay());
        return (bor1 >= bor2)? 1 : (bor1 == bor2 ? 0 : -1);
    }

    @Override
    public String toString() {
        return "Deal{" + "dealID=" + dealID + ", userID=" + userID + ", bookID=" + bookID + ", borrowDay=" + borrowDay + ", returnDay=" + returnDay + '}';
    }
    
    
}
