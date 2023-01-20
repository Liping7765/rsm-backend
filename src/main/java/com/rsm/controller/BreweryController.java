package com.rsm.controller;

import com.google.gson.Gson;
import com.rsm.domain.Brewery;
import com.rsm.util.RandomContent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;



@RestController
@RequestMapping("/breweries")
public class BreweryController {



    @CrossOrigin
    @GetMapping
    public Brewery[] findAll() throws IOException {

        Gson gson = new Gson();
        //read from DATA.json file to get static breweries info
        Reader reader = new FileReader("src/main/resources/DATA.json");
        // store data
        Brewery[] data = gson.fromJson(reader, Brewery[].class);


        // add on information to display
        for (int i = 0; i < data.length; i++) {
            Brewery brewery = data[i];
            brewery.setId(i + "");
            brewery.setName("RSMBrewery" + i);
            brewery.setBrewery_type("RSM");
            brewery.setCity(RandomContent.getRandomCity());
            brewery.setState(RandomContent.getRandomState());
            brewery.setPostal_code("12345");
        }

        reader.close();
        return data;
    }

}