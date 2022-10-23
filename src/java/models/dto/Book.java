/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

import java.io.Serializable;


public class Book implements Serializable, Comparable<Book>{
    private int quantity, bookID;
    private String  bookName, author, publisher, dayOfPublish, position;

    public Book( int bookID, String bookName, String author, String publisher, String dayOfPublish, int quantity, String position) {
        this.quantity = quantity;
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.dayOfPublish = dayOfPublish;
        this.position = position;
    }

    public Book() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDayOfPublish() {
        return dayOfPublish;
    }

    public void setDayOfPublish(String dayOfPublish) {
        this.dayOfPublish = dayOfPublish;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int compareTo(Book o) {
        return this.bookName.compareToIgnoreCase(o.getBookName());
    }

    @Override
    public String toString() {
        return "Book{" + "quantity=" + quantity + ", bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + ", dayOfPublish=" + dayOfPublish + ", position=" + position + '}';
    }
    
    
}
