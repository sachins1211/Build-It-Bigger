package com.sachin.jokes;

/**
 * Created by sachin on 11/5/16.
 */
public class Jokes {
    private String jText;

    public Jokes(String jokeText) {
        jText = jokeText;
    }

    public String getJokeText() {
        return jText;
    }

    public void setJokeText(String jokeText) {
        jText = jokeText;
    }
}
