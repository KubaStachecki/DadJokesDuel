package com.example.cordy.dadjokesduel;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.cordy.dadjokesduel.Fragments.JokeFragment;
import com.example.cordy.dadjokesduel.Generators.RandomGenerator;
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


    public static final String JOKE_PARCELABLE = "jokeParcelable";
    List<Joke> jokeList;
    Bundle bundle;
    RandomGenerator randomGenerator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


//TODO - splashscreen na poczatek i start (jako dialog fragment - ze slajdami z instrukcja)

        //https://www.androidhive.info/2016/05/android-build-intro-slider-app/

        //TODO - fragment wyswietlajacy dowcipy w dwoch polach tekstowych (rozna czcionka - pytanie odpowiedz)
        //TODO dialog fragment z wygrana - animacja koniec gry - ilosc uzytych dowcipow (dialog fragment)
        //TODO obracanie ekranu


        jokeList = new ArrayList<>();
        randomGenerator = new RandomGenerator();

        makeJokesList();



    }

    public void makeJokesList() {

        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = fDatabase.getReference();
        databaseReference.child("Jokes").addValueEventListener(new com.google.firebase.database.ValueEventListener() {

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                Log.d("GEEEEET", Long.toString(dataSnapshot.getChildrenCount()) + "UDALO SIE POLACZYC");
                jokeList.clear();

                for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {

                    Joke joke = child.getValue(Joke.class);
                    jokeList.add(joke);
                    Log.d("AAAAAADDDDDDDD", jokeList.size() + "ROZMIAR LISTY");
                }

                getRandomFragmentJoke();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(), "Database error, check internet connection!", Toast.LENGTH_SHORT).show();
                Log.d("TAAAAG", "DATABASE ERRORRR");

            }
        });
    }


    @Override
    public void openFragment(Fragment fragment) {

        this.getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void openFragmentMain() {


        getRandomFragmentJoke();


    }

    public void backFragment(Fragment fragment, FragmentActivity context) {

        context.getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.enter, R.anim.exit)
                .replace(R.id.container, fragment)
                .commit();
    }


//    public void BackButton(Activity c) {
//
//        c.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
//        c.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
//
//    }


    public void getRandomFragmentJoke() {

        Joke currentJoke = jokeList.get(randomGenerator.randomJoke(jokeList.size()));
        bundle = new Bundle();
        bundle.putParcelable(JOKE_PARCELABLE, currentJoke);
        openFragment(JokeFragment.newInstance(bundle));


    }

}
