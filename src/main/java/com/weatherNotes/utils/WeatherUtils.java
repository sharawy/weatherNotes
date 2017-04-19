/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.utils;

import com.weatherNotes.models.WeatherWrapper;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author abdo
 */
public class WeatherUtils {

    /**
     *this method is used to parse response from api response to weather wrapper object  
     * @param json hash map contain weather data with expected keys
     * @return weatherWrapper object
     */
    public static WeatherWrapper parseJsonToWeatherWrapper(HashMap<String, Object> json) {
        WeatherWrapper weatherWrapper = new WeatherWrapper();
        HashMap<String, Object> main = (HashMap<String, Object>) json.get("main");
        HashMap<String, Object> wind = (HashMap<String, Object>) json.get("wind");
        List<Object> info = (List<Object>) json.get("weather");
        HashMap<String, Object> todayInfo = (HashMap<String, Object>) info.get(0);

        weatherWrapper.setDate(json.get("dt_txt").toString().split(" ")[0]);
        weatherWrapper.setDescription(todayInfo.get("description").toString());
        weatherWrapper.setHumidity((Integer) main.get("humidity"));
        weatherWrapper.setIcon(todayInfo.get("icon").toString());
        weatherWrapper.setMaxTemp((Double) main.get("temp_max"));
        weatherWrapper.setMinTemp(Double.parseDouble( main.get("temp_min").toString()));
        weatherWrapper.setTemp((Double) main.get("temp"));
        weatherWrapper.setPressure((Double) main.get("pressure"));
        weatherWrapper.setWindSpeed((Double) wind.get("speed"));
        return weatherWrapper;
    }
}
