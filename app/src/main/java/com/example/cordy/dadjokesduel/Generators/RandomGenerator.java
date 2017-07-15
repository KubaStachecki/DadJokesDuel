package com.example.cordy.dadjokesduel.Generators;

import java.util.Random;

/**
 * Created by cordy on 2017-07-15.
 */

public class RandomGenerator {

    //TODO klasa na matematyke do losowania dowcipow

    //TODO - generator dowcipow z listy o danej dlugosci

    //TODO - generator 1- 5 dla obrazkow

    //TODO - generator 1 - 5 dla dzwiekow


    public int randomJoke(int listSize){
        return new Random().nextInt(listSize-1);
    }



}
