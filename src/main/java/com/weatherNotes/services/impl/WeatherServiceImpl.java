/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherNotes.ExceptionHandling.CustomeException;
import com.weatherNotes.models.Note;
import com.weatherNotes.models.SystemNote;
import com.weatherNotes.models.WeatherWrapper;
import com.weatherNotes.repositories.PreDefinedRepoistory;
import com.weatherNotes.repositories.SystemNoteRepoistory;
import com.weatherNotes.services.WeatherService;
import com.weatherNotes.utils.LogUtil;
import com.weatherNotes.utils.WeatherUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author abdo
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    @Qualifier("systemNoteRepoistory")
    SystemNoteRepoistory systemNoteRepoistory;
    @Autowired
    @Qualifier("preDefinedRepoistory")
    PreDefinedRepoistory preDefinedRepoistory;

    @Override
    public WeatherWrapper getTodayWeather(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        WeatherWrapper weatherWrapper = null;
        Map<String, Object> weatherMap = new HashMap<String, Object>();
        Note systemNote = null;
        try {
            String jsonResp = restTemplate.getForObject(url, String.class);
            weatherMap = mapper.readValue(jsonResp, new TypeReference<Map<String, Object>>() {
            });
            List<Object> weatherContent = new ArrayList<Object>();
            weatherContent = (List<Object>) weatherMap.get("list");
            weatherWrapper = WeatherUtils.parseJsonToWeatherWrapper((HashMap<String, Object>) weatherContent.get(0));
            if (weatherWrapper != null) {
                systemNote = systemNoteRepoistory.findByDate(weatherWrapper.getDate());
                if (systemNote == null) {
                   // systemNote = new SystemNote();
                    systemNote = preDefinedRepoistory.findBetweenRange(weatherWrapper.getTemp());
                    //  systemNote.setValue(preDefinedRepoistory.findBetweenRange(weatherWrapper.getTemp()).getValue());
                }

                weatherWrapper.setNote(systemNote);
            } else {
                throw new CustomeException(404, "service is down");
            }
        } catch (IOException ex) {
            LogUtil.getInstance().error(ex);
        } catch (Exception ex) {
            LogUtil.getInstance().error(ex);
        }

        return weatherWrapper;
    }

}
