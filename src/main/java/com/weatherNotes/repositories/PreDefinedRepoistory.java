/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.repositories;

import com.weatherNotes.models.PreDefinedNote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdo
 */
@Repository
public interface PreDefinedRepoistory extends HibernateRepository<PreDefinedNote, Integer>{

    /**
     *This method is used to get a PreDefinedNote  by temperature 
     * @param temp this is the value of temperature 
     * @return PreDefinedNote
     */
    @Query("SELECT p FROM PreDefinedNote p WHERE  (:temp BETWEEN minTemp and maxTemp and minTemp !=:temp) or :temp >minTemp and maxTemp is null")
    PreDefinedNote findBetweenRange(@Param("temp") Double temp);
}
