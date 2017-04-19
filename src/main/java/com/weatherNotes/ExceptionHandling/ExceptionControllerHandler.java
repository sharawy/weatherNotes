/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.ExceptionHandling;

import com.weatherNotes.utils.LogUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdo
 */
@ControllerAdvice
public class ExceptionControllerHandler {

    public static final String DEFAULT_ERROR_VIEW = "errorPage";
    @Autowired
    ApplicationContext messageContext;

  

    @ExceptionHandler(CustomeException.class)
    public ModelAndView handleCustomException(CustomeException ex) {

        ModelAndView model = new ModelAndView("errorPage");
        model.addObject("status", ex.getErrCode());
        model.addObject("msg", ex.getErrMsg());

        return model;

    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView
            defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        LogUtil.getInstance().error(e.getMessage());
        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", 500);
        mav.addObject("msg", "Internal Error please contact system admin");;
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
