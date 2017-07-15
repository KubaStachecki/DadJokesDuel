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


    //TODO main game fragment


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private MainToFragmentUtils mListener;

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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        ButterKnife.bind(this,view);


        return view;
    }


}
