/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdo
 */
@Controller
public class LoginController {
     @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
       HttpSession loginSession = request.getSession();
       ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
       if(loginSession.getAttribute("msg")!= null){
           modelAndView.addObject("msg",loginSession.getAttribute("msg"));
           loginSession.removeAttribute("msg");
       }
        
      

        return modelAndView;
    }
}
