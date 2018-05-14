package com.udacity.gradle.builditbigger.backend;

public class AJoke {
    private String myJoke;

    public AJoke(String myJoke) {
        this.myJoke = myJoke;
    }

    public String getAJoke() { return myJoke; }
    public void setAJoke(String joke) { myJoke = joke; }
}