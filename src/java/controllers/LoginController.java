/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.dao.*;
import models.dto.*;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    public LoginController() {
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String renderUser(ModelMap mod){
        mod.addAttribute("user", new User());
        return "login";
    }
}
