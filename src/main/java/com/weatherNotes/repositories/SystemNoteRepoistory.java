/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.repositories;

import com.weatherNotes.models.SystemNote;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdo
 */
@Repository
public interface SystemNoteRepoistory extends HibernateRepository<SystemNote, Integer>{
    /**
     * This method is used to get a SystemNote by date
     *
     * @param date This is the date of system note
     * @return SystemNote object.
     */
    SystemNote findByDate(String date);
}
