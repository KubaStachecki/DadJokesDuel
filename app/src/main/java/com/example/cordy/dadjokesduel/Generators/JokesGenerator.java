package com.example.cordy.dadjokesduel.Generators;

import com.example.cordy.dadjokesduel.Model.Joke;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by cordy on 2017-07-15.
 */

public class JokesGenerator {

    //TODO klasa na sciaganie pliku - odczyt z pliku i nadpisanie pliku - ta klasa wystawia dowcipy


    public List<Joke> makeJokesList(String file) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

//        Joke joke = objectMapper.readValue(new File(file), Joke.class);

        List<Joke> jokesFromFile = objectMapper.readValue(new File(file), List.class);


        return jokesFromFile;

    }

    public String getJsonFile(String url){




        return "sciezka do pliku json";
    }
}
