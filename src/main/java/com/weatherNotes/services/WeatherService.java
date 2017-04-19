/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.services;

import com.weatherNotes.models.WeatherWrapper;

/**
 *
 * @author abdo
 */
public interface WeatherService {
    /**
     * This method is used to get a weather by api  url
     *
     * @param url This is the value of api url that will be used to get weather data
     * @return WeatherWrapper object.
     */
     WeatherWrapper getTodayWeather(String url);
    
}
