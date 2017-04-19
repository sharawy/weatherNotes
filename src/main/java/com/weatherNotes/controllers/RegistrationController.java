/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.controllers;

import com.weatherNotes.models.User;
import com.weatherNotes.services.UserService;
import com.weatherNotes.utils.LogUtil;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdo
 */
@Controller
public class RegistrationController {

    @Autowired
    UserService userServiceImpl;
    @Autowired
    ApplicationContext messageContext;
    
    private static final Logger logger = LogUtil.getInstance();

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        User user = new User();

        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("user") User user,
            BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        logger.info("registration proccess.");
        try {
            //Model errors
            if (result.hasErrors()) {
                modelAndView.addObject("msg", messageContext.getMessage("register.failed", null, null));
                modelAndView.addObject("errors", result.getAllErrors());

                return modelAndView;
            }
            if (userServiceImpl.findUserByEmail(user.getEmail()) != null) {
                modelAndView.addObject("msg", messageContext.getMessage("register.emailExist", null, null));
                return modelAndView;
            }
            //save in db
            user.setUserRole(userServiceImpl.getUserRoleByName("User"));
            User savedUser = userServiceImpl.register(user);
            if (savedUser == null) {
                logger.debug("Failed to register");
                modelAndView.addObject("msg", messageContext.getMessage("register.failed", null, null));
            }
            modelAndView.setViewName("redirect:/");
            logger.info("registration succes.");
        } catch (Exception e) {
            logger.error(e);
            modelAndView.addObject("msg", messageContext.getMessage("register.failed", null, null));
        }

        return modelAndView;
    }
}
