package com.example.cordy.dadjokesduel.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cordy on 2017-07-15.
 */

public class Joke implements Parcelable {

    int id;
    String question;
    String answer;
    String url;

    public Joke() {
    }

    protected Joke(Parcel in) {
        id = in.readInt();
        question = in.readString();
        answer = in.readString();
        url = in.readString();
    }

    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel in) {
            return new Joke(in);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(question);
        parcel.writeString(answer);
        parcel.writeString(url);
    }

    //TODO model suchara

    // id
    //question
    //answer
    //ulr obrazka
    //
}
