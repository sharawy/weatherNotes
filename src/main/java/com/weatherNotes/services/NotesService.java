/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services;

import com.weatherNotes.models.PreDefinedNote;
import com.weatherNotes.models.SystemNote;
import java.util.List;

/**
 *
 * @author abdo
 */
public interface NotesService {

    /**
     * This method is used to get a PreDefinedNote by temperature
     *
     * @param temp This is the value of temperature
     * @return PreDefinedNote object.
     */
    PreDefinedNote getPreDefinedNoteByTemp(Double temp);

    /**
     * This method is used to get a PreDefinedNote by id
     *
     * @param id This is the value of prenote id
     * @return PreDefinedNote object.
     */
    PreDefinedNote getPreDefinedNote(Integer id);

    /**
     * This method is used to insert new predefined not or update it if it exist
     *
     * @param preDefinedNote This is object of predefinedNote
     * @return PreDefinedNote object.
     */
    PreDefinedNote updateIfnotExistCreatePredefinedNote(PreDefinedNote preDefinedNote);

    /**
     * This method is used to delete a PreDefinedNote
     *
     * @param preDefinedNote This is object of preDefinedNote
     *
     */
    void deletePreDefinedNote(PreDefinedNote preDefinedNote);

    /**
     * This method is used to get all Pre Defined Notes
     *
     * @return list of PreDefinedNote object.
     */
    public List<PreDefinedNote> getAllPredefinedNotes();

    /**
     * This method is used to get all SystemNote
     *
     * @return list of SystemNote object.
     */
    public List<SystemNote> getAllSystemNotes();

    /**
     * This method is used to insert new SystemNote not or update it if it exist
     *
     * @param sysNote This is object of SystemNote
     * @return SystemNote object.
     */
    SystemNote updateIfnotExistCreateSystemNote(SystemNote sysNote);

    /**
     * This method is used to get a SystemNote by id
     *
     * @param id This is the value of prenote id
     * @return SystemNote object.
     */
    SystemNote getSystemNote(Integer id);

    /**
     * This method is used to delete a SystemNote
     *
     * @param sysNote This is object of SystemNote
     *
     */
    void deleteSysdNote(SystemNote sysNote);

    /**
     * This method is used to get a SystemNote by date
     *
     * @param date This is the value of system note date
     * @return SystemNote object.
     */
    SystemNote getSysNoteByDate(String date);
}
