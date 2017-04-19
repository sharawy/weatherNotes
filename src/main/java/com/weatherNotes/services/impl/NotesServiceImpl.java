/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services.impl;

import com.weatherNotes.models.PreDefinedNote;
import com.weatherNotes.models.SystemNote;
import com.weatherNotes.repositories.PreDefinedRepoistory;
import com.weatherNotes.repositories.SystemNoteRepoistory;
import com.weatherNotes.services.NotesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdo
 */
@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    SystemNoteRepoistory systemNoteRepoistory;
    @Autowired
    PreDefinedRepoistory preDefinedRepoistory;

    @Override
    public PreDefinedNote getPreDefinedNoteByTemp(Double temp) {
       PreDefinedNote preDefinedNote = preDefinedRepoistory.findBetweenRange(temp);
        return preDefinedNote;
    }
    
    @Override
    public PreDefinedNote getPreDefinedNote(Integer id) {
      
       return  preDefinedRepoistory.findOne(id);
       
    }
    @Override
    public PreDefinedNote updateIfnotExistCreatePredefinedNote(PreDefinedNote preDefinedNote) {

        return preDefinedRepoistory.save(preDefinedNote);
    }

    @Override
    public void deletePreDefinedNote(PreDefinedNote preDefinedNote) {

        preDefinedRepoistory.delete(preDefinedNote);
    }
    //sys notes
    @Override
    public  List<SystemNote> getAllSystemNotes() {

        return systemNoteRepoistory.findAll();
    }
    @Override
    public SystemNote updateIfnotExistCreateSystemNote(SystemNote sysNote) {

        return systemNoteRepoistory.save(sysNote);
    }

    @Override
    public SystemNote getSystemNote(Integer id) {

        return systemNoteRepoistory.findOne(id);
    }

    @Override
    public void deleteSysdNote(SystemNote sysNote) {

        systemNoteRepoistory.delete(sysNote);
    }
    @Override
    public SystemNote getSysNoteByDate(String date) {

       return systemNoteRepoistory.findByDate(date);
    }

    @Override
    public List<PreDefinedNote> getAllPredefinedNotes() {
        return  preDefinedRepoistory.findAll();
    }
}
