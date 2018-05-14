package com.sergiocruz.sergiojokeslibrary;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    public String getRandomJoke() {
        List<String> jokeList = Arrays.asList(
                "Can a kangaroo jump higher than a house? \n" +
                        "Of course, a house doesn't jump at all.",

                "A man asks a farmer near a field, " +
                        "\"Sorry sir, would you mind if I " +
                        "crossed your field instead of going around it? You see, " +
                        "I have to catch the 4:23 train.\n" +
                        "The farmer says, \"Sure, go right ahead. " +
                        "And if my bull sees you, you’ll even catch the 4:11 one.\"",

                "Anton, do you think I'm a bad mother?\n" +
                        "My name is Paul.",

                "My dog used to chase people on a bike a lot. " +
                        "It got so bad, finally I had to take his bike away.",

                "What is the difference between a snowman and a snowwoman?\n" +
                        "Snowballs.",

                "My wife suffers from a drinking problem.\"\n" +
                        "Oh is she an alcoholic?\"\n" +
                        "\"No, I am, but she's the one who suffers.\"\n");

        int random = new Random().nextInt(jokeList.size());

        return jokeList.get(random);
    }


}
