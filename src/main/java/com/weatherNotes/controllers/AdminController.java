/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.controllers;

import com.weatherNotes.ExceptionHandling.CustomeException;
import com.weatherNotes.models.PreDefinedNote;
import com.weatherNotes.models.SystemNote;
import com.weatherNotes.services.NotesService;
import com.weatherNotes.utils.LogUtil;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author abdo
 */
@Controller
public class AdminController {

    @Autowired
    NotesService notesServiceImpl;
    @Autowired
    ApplicationContext messageContext;
    
     private static final Logger logger = LogUtil.getInstance();
    
    @RequestMapping(value = "/systemNotes", method = RequestMethod.GET)
    public ModelAndView systemNoteslisting() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("systemNotes/listing");

        modelAndView.addObject("systemNotes", notesServiceImpl.getAllSystemNotes());

        return modelAndView;
    }

    @RequestMapping(value = "/systemNotes/{id}", method = RequestMethod.GET)
    public ModelAndView editSystemNote(@PathVariable("id") Integer id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("systemNotes/edit");
        SystemNote systemNote = new SystemNote();
        if (id != null) {
            systemNote = notesServiceImpl.getSystemNote(id);
        } else {
           throw new CustomeException(HttpStatus.NOT_FOUND.value(),messageContext.getMessage("notFound", new String[]{""}, null));
        }

        modelAndView.addObject("systemNote", systemNote);

        return modelAndView;
    }

    @RequestMapping(value = "/systemNotes/edit", method = RequestMethod.POST)
    public ModelAndView editSystemNote(@Valid @ModelAttribute("systemNote") SystemNote systemNote, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        SystemNote savedSystemNote = null;
        modelAndView.setViewName("systemNotes/edit");
        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
            modelAndView.addObject("msg", messageContext.getMessage("editSystemNote.failed", null, null));

        } else {
            try {
                savedSystemNote = notesServiceImpl.getSystemNote(systemNote.getId());
                if (savedSystemNote != null) {
                    notesServiceImpl.updateIfnotExistCreateSystemNote(systemNote);
                } else {
                    modelAndView.addObject("msg", messageContext.getMessage("editSystemNote.notExist", null, null));

                }
                modelAndView.addObject("systemNote", systemNote);
            } catch (Exception e) {
                logger.error(e);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/systemNotes/add", method = RequestMethod.GET)
    public ModelAndView addSystemNote() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("systemNotes/add");
        SystemNote systemNote = new SystemNote();

        modelAndView.addObject("systemNote", systemNote);

        return modelAndView;
    }

    @RequestMapping(value = "/systemNotes/add", method = RequestMethod.POST)
    public ModelAndView addSystemNote(@Valid @ModelAttribute("systemNote") SystemNote systemNote, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        SystemNote savedSystemNote = null;
        modelAndView.setViewName("systemNotes/add");
        
        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
            modelAndView.addObject("msg", messageContext.getMessage("addSystemNote.failed", null, null));
        } else {
            savedSystemNote = notesServiceImpl.getSysNoteByDate(systemNote.getDate());
            if (savedSystemNote != null) {
                modelAndView.addObject("msg", messageContext.getMessage("addSystemNote.alreadyExist", null, null));

            } else {
                
                savedSystemNote = notesServiceImpl.updateIfnotExistCreateSystemNote(systemNote);
                if (savedSystemNote != null) {
                    modelAndView.setViewName("redirect:/systemNotes");
                } else {
                    modelAndView.addObject("msg", messageContext.getMessage("addSystemNote.failed", null, null));

                }
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/preNotes", method = RequestMethod.GET)
    public ModelAndView preNoteslisting() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("predefinedNotes/listing");

        modelAndView.addObject("preNotes", notesServiceImpl.getAllPredefinedNotes());

        return modelAndView;
    }

    @RequestMapping(value = "/preNotes/{id}", method = RequestMethod.GET)
    public ModelAndView editPreNote(@PathVariable("id") Integer id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("predefinedNotes/edit");
        PreDefinedNote preNote = new PreDefinedNote();
        if (id != null) {
            preNote = notesServiceImpl.getPreDefinedNote(id);
        } else {
           throw new CustomeException(HttpStatus.NOT_FOUND.value(),messageContext.getMessage("notFound", new String[]{""}, null));
        }

        modelAndView.addObject("preNote", preNote);

        return modelAndView;
    }

    @RequestMapping(value = "/preNotes/edit", method = RequestMethod.POST)
    public ModelAndView editPreNote(@Valid @ModelAttribute("preNote") PreDefinedNote preNote, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("predefinedNotes/edit");
        PreDefinedNote savedPreDefinedNote;
        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
            modelAndView.addObject("msg", messageContext.getMessage("editPreNote.failed", null, null));

        } else {
            savedPreDefinedNote = notesServiceImpl.getPreDefinedNote(preNote.getId());
            if (savedPreDefinedNote != null) {
                notesServiceImpl.updateIfnotExistCreatePredefinedNote(preNote);
            } else {
                modelAndView.addObject("msg", messageContext.getMessage("editPreNote.failed", null, null));

            }
        }
        modelAndView.addObject("preNote", preNote);

        return modelAndView;
    }

    @RequestMapping(value = "/preNotes/add", method = RequestMethod.GET)
    public ModelAndView addPreNote() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("predefinedNotes/add");
        modelAndView.addObject("preNote", new PreDefinedNote());
        return modelAndView;
    }

    @RequestMapping(value = "/preNotes/add", method = RequestMethod.POST)
    public ModelAndView addPreNote(@Valid @ModelAttribute("preNote") PreDefinedNote preNote, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        PreDefinedNote savedPreDefinedNote = null;
        modelAndView.setViewName("predefinedNotes/add");

        if (result.hasErrors()) {
            modelAndView.addObject("errors", result.getAllErrors());
            modelAndView.addObject("msg", messageContext.getMessage("addPreNote.failed", null, null));
        } else {
            savedPreDefinedNote = notesServiceImpl.updateIfnotExistCreatePredefinedNote(preNote);
            if (savedPreDefinedNote != null) {
                modelAndView.setViewName("redirect:/preNotes");
            }
        }
        return modelAndView;
    }

}
