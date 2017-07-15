package com.example.cordy.dadjokesduel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cordy.dadjokesduel.Model.Joke;
import com.example.cordy.dadjokesduel.Utils.MainToFragmentUtils;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MainToFragmentUtils {


    List<Joke> jokeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//TODO - splashscreen na poczatek i start (jako dialog fragment - ze slajdami z instrukcja)

        //https://www.androidhive.info/2016/05/android-build-intro-slider-app/
        //TODO - fragment wyswietlajacy dowcipy w dwoch polach tekstowych (rozna czcionka - pytanie odpowiedz)
        //TODO - math random ktory losuje z listy obiekt typu suchar
        // TODO - retrofit ktory sciaga plik json z sucharami - plik jest wczytywany do bazy
        // TODO wczytywanie obiektow z pliku json
        //TODO dialog fragment z wygrana - animacja koniec gry - ilosc uzytych dowcipow (dialog fragment)
        //TODO


        jokeList = new ArrayList<>();
        makeJokesList();


    }

    public void makeJokesList() {

        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference databaseReference = fDatabase.getReference();
        databaseReference.child("Jokes").addValueEventListener(new com.google.firebase.database.ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                Log.d("TAAAAG", Long.toString(dataSnapshot.getChildrenCount()) + "UDALO SIE POLACZYC");

                jokeList.clear();

                for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {

                    Joke joke = child.getValue(Joke.class);
                    jokeList.add(joke);
                    Log.d("TAAAAG", jokeList.size() + "ROZMIAR LISTY");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public int getRandom(){
        return new Random().nextInt(jokeList.size()-1);
    }

}
