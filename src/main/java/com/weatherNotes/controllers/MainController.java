package com.weatherNotes.controllers;

import com.weatherNotes.common.Defines;
import com.weatherNotes.models.User;
import com.weatherNotes.models.WeatherWrapper;
import com.weatherNotes.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdalrahman.sharawy
 */
@Controller
public class MainController {

    @Autowired
    WeatherService weatherServiceImpl;
    @Autowired
    private ConfigurableEnvironment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();
        
        if (user.getUserRole().getUserRoleName().equals(Defines.UserRoles.ADMIN)) {

            return "redirect:/systemNotes";
        } else {
            return "redirect:/home";
        }

    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        WeatherWrapper weatherWrapper
                = weatherServiceImpl.getTodayWeather(env.getProperty("apiUrl"));
        modelAndView.addObject("todayWeather", weatherWrapper);

        return modelAndView;
    }

}
