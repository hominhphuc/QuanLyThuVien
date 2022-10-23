/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.dao.*;
import models.dto.*;
import controllers.*;
import java.util.*;
import java.util.regex.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    
    @RequestMapping(value = "/listbook/{usingUserID}", method = RequestMethod.GET)
    public String list(@PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
        BookDAO dao = new BookDAO();
        List<Book> list = dao.readAll();
        UserDAO userdao = new UserDAO();
        User us = userdao.readByID(usingUserID);
        String display="none";
        if(usingUserID==1){
            display="";
        }
        mod.put("list", list);
        mod.put("display", display);
        mod.put("usingUser", us);
        mod.addAttribute("usingUser", us);
        return "searchboard-book";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String moveToAddBook(@ModelAttribute(value = "usingUser") User us, ModelMap mod){
        if (us.getUserID() == 1){
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            mod.addAttribute("addingBook", new Book());
            return "addBook";
        }
        return "login";
    }
    
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String moveToUpdateBook(@ModelAttribute(value = "usingUser") User us, ModelMap mod){
        if (us.getUserID() == 1){
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            mod.addAttribute("updatingBook", new Book());
            mod.addAttribute("deleteBook", new Book());
            return "UpdateBook";
        }
        return "login";
    }
    
    @RequestMapping(value = "/listbookadded/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard(@ModelAttribute(value = "addingBook") Book book, BindingResult result,
                                                    @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
        System.out.println("book added" + book);
        BookDAO dao = new BookDAO();
        boolean validDayOfPub = Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", book.getDayOfPublish()),
                validBook = !result.hasErrors() && validDayOfPub;
        User us = new UserDAO().readByID(usingUserID);
        if(validBook){
            dao.create(book);
            mod.put("usingUser", us);
            return list(usingUserID, mod);
        }
        return moveToAddBook(us, mod);
    }
    
    
    @RequestMapping(value = "/listbookupdated/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard2(@ModelAttribute(value = "updatingBook") Book book, BindingResult result,
                                                    @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
        BookDAO dao = new BookDAO();
        boolean validDayOfPub = Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", book.getDayOfPublish()),
                validBook = !result.hasErrors() && validDayOfPub;
        User us = new UserDAO().readByID(usingUserID);
        if(validBook){
            dao.update(book);
            mod.put("usingUser", us);
            return list(usingUserID, mod);
        }
        return moveToUpdateBook(us, mod);
    }
    
    @RequestMapping(value = "/listbookdeleted/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard3(@ModelAttribute(value = "deleteBook") Book book, BindingResult res,
                                                @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                                                // Render from addUser to searchboard user
        User us = new UserDAO().readByID(usingUserID);
        boolean validBook = !res.hasErrors() && new BookDAO().readByID(book.getBookID())!=null ;
        if(validBook){
            new BookDAO().delete(book.getBookID());
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(usingUserID, mod);
        }
        return moveToUpdateBook(us, mod);
    }
//    @RequestMapping(value = "/addBook/{usingUserID}", method = RequestMethod.GET)
//    public String moveToAddBook(@PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
//        if (usingUserID == 1){
//            UserDAO userdao = new UserDAO();
//            User us = userdao.readByID(usingUserID);
//            mod.put("usingUser", us);
//            return "addBook";
//        }
//        return "login";
//    }
    
//    @RequestMapping(value = "/listbook/1", method = RequestMethod.POST)
//    public String addBook(@ModelAttribute(value = "book") Book book, ModelMap mod){
//        return "searchboard-book";
//    }
}
