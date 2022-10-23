/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.dao.*;
import models.dto.*;
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
public class UserController {
        
    @RequestMapping(value="/listuser", method = RequestMethod.POST)
    public String list(@ModelAttribute(value = "user") User user, ModelMap mod){ //Render from Login --> searchboard-user
        UserDAO dao = new UserDAO();
        User us = dao.readByID(user.getUserID());
        if(us != null){
            if(us.getPassword().equals(user.getPassword())){
                List<User> list = dao.readAll();
                mod.put("list", list);
                String display="none";
                if (us.getUserID()==1){
                    display = "";
                }
                mod.put("display", display);
                mod.put("usingUser", user);
                mod.addAttribute("usingUser", user);
                mod.addAttribute("choosingUser", new User());
                return "searchboard-user";
            }
        }
        return "login";
    }
    
    @RequestMapping(value = "/listuser2")
    public String list2(@ModelAttribute(value = "usingUser") User user, ModelMap mod){ //Render from searchboard-book and
                                                                                        // searchboard-deal to searchboard-user
        User us = new UserDAO().readByID(user.getUserID());
        return list(us, mod);
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String moveToAddUser(@ModelAttribute(value = "usingUser") User user, ModelMap mod){ //Render from searchboard-user to adduser
        UserDAO userdao = new UserDAO();
        if(user.getUserID() == 1){
            User us = userdao.readByID(user.getUserID());
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            mod.addAttribute("addingUser", new User());
            return "addUser";
        }
        return "login";
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String moveToUpdateUser(@ModelAttribute(value = "usingUser") User user, ModelMap mod){ //Render from searchboard-user to updateUser
        UserDAO userdao = new UserDAO();
        if(user.getUserID() == 1){
            User us = userdao.readByID(user.getUserID());
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            mod.addAttribute("updatingUser", new User());
            mod.addAttribute("deleteUser", new User());
            return "UpdateUser";
        }
        return "login";
    }
    
    @RequestMapping(value = "/listuseradded/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard(@ModelAttribute(value = "addingUser") User user, BindingResult res,
                                                @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                                                // Render from addUser to searchboard user
        System.out.println("check ModelAttribute: "+ user);                                            
        UserDAO dao = new UserDAO();
        User us = new UserDAO().readByID(usingUserID);
        boolean validUser = !res.hasErrors() && 
                                Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", user.getBirthDay());
        if(validUser){
            dao.create(user);
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(us, mod);
        }
        return moveToAddUser(us, mod);
    }
    
    @RequestMapping(value = "/listuserupdated/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard2(@ModelAttribute(value = "updatingUser") User user, BindingResult res,
                                                @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                                                // Render from update user to searchboard user
        UserDAO dao = new UserDAO();
        User us = new UserDAO().readByID(usingUserID);
        boolean validUser = !res.hasErrors() && 
                                Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", user.getBirthDay());
        if(validUser){
            dao.update(user);
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(us, mod);
        }
        return moveToUpdateUser(us, mod);
    }
    
    @RequestMapping(value = "/listuserdeleted/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard3(@ModelAttribute(value = "updatingUser") User user, BindingResult res,
                                                @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                                                // Render from addUser to searchboard user
        UserDAO dao = new UserDAO();
        User us = new UserDAO().readByID(usingUserID);
        boolean validUser = !res.hasErrors() && dao.readByID(user.getUserID())!=null ;
        if(validUser){
            dao.delete(user.getUserID());
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(us, mod);
        }
        return moveToUpdateUser(us, mod);
    }
    
}
