/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.dao.*;
import models.dto.*;
import java.util.*;
import java.util.regex.Pattern;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DealController {
    
    @RequestMapping(value = "/listdeal/{usingUserID}", method = RequestMethod.GET)
    public String list(@PathVariable(value = "usingUserID") int usingUserID, ModelMap mod ){ //from searchboard book to search board deal
        DealDAO dao = new DealDAO();
        List<Deal> list = dao.readAll();
        String display = "none";
        UserDAO userdao = new UserDAO();
        User us = userdao.readByID(usingUserID);
        mod.put("list", list);
        if(usingUserID == 1 ){
            display= "";
        }
        mod.put("display", display);
        mod.put("usingUser", us);
        mod.addAttribute("usingUser", us);
        return "searchboard-deal";
    }
    
    @RequestMapping(value = "/addDeal", method = RequestMethod.POST)
    public String movetoAddDeal(@ModelAttribute(value = "usingUser") User user, ModelMap mod){ //from search board to add deal
        DealDAO dao = new DealDAO();
        UserDAO userdao = new UserDAO();
        if (user.getUserID() == 1){
            mod.put("usingUser", user);
            mod.addAttribute("usingUser", user);
            mod.addAttribute("addingDeal", new Deal());
            return "addDeal";
        }
        return "login";
    }
    
    @RequestMapping(value = "/updateDeal", method = RequestMethod.POST)
    public String movetoUpdateDeal(@ModelAttribute(value = "usingUser") User user, ModelMap mod){//from search board to update deal
        DealDAO dao = new DealDAO();
        UserDAO userdao = new UserDAO();
        if (user.getUserID() == 1){
            mod.put("usingUser", user);
            mod.addAttribute("usingUser", user);
            mod.addAttribute("updatingDeal", new Deal());
            mod.addAttribute("deleteDeal", new Deal());
            return "UpdateDeal";
        }
        return "login";
    }
    
    @RequestMapping(value = "/listdealadded/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard(@ModelAttribute(value = "addingDeal") Deal deal, BindingResult res,
                                            @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                            // from add deal to search board
        UserDAO dao = new UserDAO();
        User us = new UserDAO().readByID(usingUserID);
        boolean validDeal = !res.hasErrors() && 
                                Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", deal.getBorrowDay()) &&
                                (Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", deal.getReturnDay())
                                                                                                    || deal.getReturnDay().equals(""));
        if(validDeal){
            new DealDAO().create(deal);
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(usingUserID, mod);
        }
        return movetoAddDeal(us, mod);
    }
    
    @RequestMapping(value = "/listdealupdated/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard2(@ModelAttribute(value = "updatingDeal") Deal deal, BindingResult res,
                                            @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                            // from update deal to search board
        UserDAO dao = new UserDAO();
        User us = new UserDAO().readByID(usingUserID);
        boolean validDeal = !res.hasErrors() && 
                                Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", deal.getBorrowDay()) &&
                                (Pattern.matches("^((0|1)\\d{1})(\\/|-)((0|1|2)\\d{1})(\\/|-)((19|20)\\d{2})", deal.getReturnDay()) 
                                                                                                    || deal.getReturnDay().equals("")); 
        if(validDeal){
            new DealDAO().update(deal);
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(usingUserID, mod);
        }
        return movetoUpdateDeal(us, mod);
    }
    
    @RequestMapping(value = "/listdealdeleted/{usingUserID}", method = RequestMethod.POST)
    public String returnSearchBoard3(@ModelAttribute(value = "deleteDeal") Deal deal, BindingResult res,
                                                @PathVariable(value = "usingUserID") int usingUserID, ModelMap mod){
                                                                                // Render from addUser to searchboard user
        User us = new UserDAO().readByID(usingUserID);
        boolean validDeal = !res.hasErrors() && new BookDAO().readByID(deal.getDealID())!=null ;
        if(validDeal){
            new DealDAO().delete(deal.getDealID());
            mod.put("usingUser", us);
            mod.addAttribute("usingUser", us);
            return list(usingUserID, mod);
        }
        return movetoUpdateDeal(us, mod);
    }
}
