/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

import java.io.Serializable;


public class User implements Serializable, Comparable<User>{
    private String userName, userSirName, birthDay, phoneNumber, iD_Number, andress, password;
    private int userID;
    
    public User(int userID, String userName, String userSirName, String birthDay, String phoneNumber,
                                                                        String iD_Number, String andress, String password) {
        this.userID = userID;
        this.userName = userName;
        this.userSirName = userSirName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.iD_Number = iD_Number;
        this.andress = andress;
        this.password = password;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSirName() {
        return userSirName;
    }

    public void setUserSirName(String userSirName) {
        this.userSirName = userSirName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getiD_Number() {
        return iD_Number;
    }

    public void setiD_Number(String iD_Number) {
        this.iD_Number = iD_Number;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    @Override
    public int compareTo(User o) {
        if (this.getUserName().equalsIgnoreCase(o.getUserName())) return 0;
        else return this.getUserName().compareToIgnoreCase(o.getUserName());
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName=" + userName + ", userSirName=" + userSirName + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber + ", iD_Number=" + iD_Number + ", andress=" + andress + '}';
    }

    

}
