package com.example.cordy.dadjokesduel;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cordy on 2017-07-15.
 */
public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}