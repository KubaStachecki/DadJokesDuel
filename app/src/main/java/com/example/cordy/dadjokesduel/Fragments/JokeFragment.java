package com.example.cordy.dadjokesduel.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cordy.dadjokesduel.MainActivity;
import com.example.cordy.dadjokesduel.Model.Joke;
import com.example.cordy.dadjokesduel.R;
import com.example.cordy.dadjokesduel.Utils.MainToFragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class JokeFragment extends Fragment {


    @BindView(R.id.button_next)
    AppCompatButton nextButt;

    @BindView(R.id.button_win)
    AppCompatButton winButt;

    @BindView(R.id.joke_fragment_question)
    TextView questionText;


    @BindView(R.id.joke_fragment_answer)
    TextView answerText;


    MainToFragmentUtils mainUtils;


    //TODO main game fragment



    public JokeFragment() {
        // Required empty public constructor
    }


    public static JokeFragment newInstance(Bundle jokeBundle) {
        JokeFragment fragment = new JokeFragment();


        //TODO bundle = joke.


        fragment.setArguments(jokeBundle);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Joke thisJoke = getArguments();

        ((MainActivity) getActivity()).getSupportActionBar().hide();

        mainUtils = (MainActivity) getActivity();





    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        Joke currentJoke  = getArguments().getParcelable(MainActivity.JOKE_PARCELABLE);

        questionText.setText(currentJoke.getQuestion());
        answerText.setText(currentJoke.getAnswer());










        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              mainUtils.openFragmentMain();

            }
        });





    }




}
