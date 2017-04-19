/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.models;

import javax.persistence.Entity;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 *
 * @author abdo
 */
@Entity
public class PreDefinedNote extends Note {

   
    @NotNull
    private Double minTemp;
    
   
    @Max(Long.MAX_VALUE)
    private Double maxTemp;

    @AssertTrue(message = "invalid range")
    public boolean isTempRangeValid() {
        return minTemp <maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

}
