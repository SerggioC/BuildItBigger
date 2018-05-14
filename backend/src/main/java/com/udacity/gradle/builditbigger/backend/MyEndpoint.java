package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.sergiocruz.sergiojokeslibrary.Joker;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myBackendApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    /** endpoint method that gets a random joke from java library */
    @ApiMethod(name = "getJokeFromSergio")
    public AJoke getJokeFromSergio() {
        Joker joker = new Joker();
        String joke = joker.getRandomJoke();

        AJoke aJoke = new AJoke(joke);

        return aJoke;
    }




}

