package com.example.cordy.dadjokesduel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cordy.dadjokesduel.Utils.MainToFragmentUtils;

public class MainActivity extends AppCompatActivity implements MainToFragmentUtils {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sout("Cześć Kuba"); if(true){openBeerAction(new Beer beer);}

        // CZESC JACEK

//TODO - splashscreen na poczatek i start (jako dialog fragment - ze slajdami z instrukcja)
        //https://www.androidhive.info/2016/05/android-build-intro-slider-app/
        //TODO - fragment wyswietlajacy dowcipy w dwoch polach tekstowych (rozna czcionka - pytanie odpowiedz)
        //TODO - math random ktory losuje z listy obiekt typu suchar
        // TODO - retrofit ktory sciaga plik json z sucharami - plik jest wczytywany do bazy
        // TODO wczytywanie obiektow z pliku json
        //TODO dialog fragment z wygrana - animacja koniec gry - ilosc uzytych dowcipow (dialog fragment)
        //TODO


    }
}
