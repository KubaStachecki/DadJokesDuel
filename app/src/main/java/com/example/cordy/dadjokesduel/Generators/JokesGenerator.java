//package com.example.cordy.dadjokesduel.Generators;
//
//import android.util.Log;
//
//import com.example.cordy.dadjokesduel.Model.Joke;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
///**
// * Created by cordy on 2017-07-15.
// */
//
//public class JokesGenerator {
//
//    //TODO klasa na sciaganie pliku - odczyt z pliku i nadpisanie pliku - ta klasa wystawia dowcipy
//
//
//
//    public List<Joke> makeJokesList() throws IOException {
//
//
//
//        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//
//        DatabaseReference databaseReference = fDatabase.getReference();
//        databaseReference.child("wallpapers").addValueEventListener(new com.google.firebase.database.ValueEventListener() {
//
//            @Override
//            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
//
//
//                Log.d("TAAAAG",Long.toString(dataSnapshot.getChildrenCount()) + "UDALO SIE POLACZYC");
//                jokeList.clear();
//
//
//                for (com.google.firebase.database.DataSnapshot child : dataSnapshot.getChildren()) {
//
//
//                   Joke joke = child.getValue(Joke.class);
//
//                    jokeList.add(joke);
//
//                    Log.d("TAAAAG",jokeList.size() + "ROZMIAR LISTY");
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//
//    }
//
//    return jokesList;
//
//
//
//}
//
//    public String getJsonFile(String url){
//
//
//
//
//        return "sciezka do pliku json";
//    }
//}
