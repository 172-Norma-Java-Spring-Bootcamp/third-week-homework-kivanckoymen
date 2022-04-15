package com.example.demo;

import com.example.demo.model.Model;
import com.example.demo.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@Slf4j
@RestController
@RequestMapping()
public class Controller {
    @Autowired
    RestTemplate restTemplate;

    public String apiUrl;



    @Autowired()
    ObjectMapper objectMapper;
    //ObjectMapper objectMapper = new ObjectMapper();


    Api api=new Api();

    @GetMapping(path = "/{city}")
    public List<?> test(@PathVariable String city) throws JsonProcessingException {

        apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                +"&appid="+api.getApiKey()
                +"&units=metric&lang=tr";


        //  cor1=restTemplate.getForObject(apiUrl,Coord.class);
    log.info(api.apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        String abc=response.getBody();

        Model currentWeather = objectMapper.readValue(abc, Model.class);
        // Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        //  Assert.assertEqual(200, response.getStatusCodeValue());
        //assertEqual(true, response.getBody().contains("employeeList"));



        //log.info(currentWeather.getTemp);
        return Collections.singletonList(currentWeather);
        // "asd "+currentWeather.getName();
    }


}