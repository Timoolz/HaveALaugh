package com.olamide.udacity.havealaugh.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.olamide.jokes.Joke;
import com.olamide.jokes.JokeFactory;
import com.olamide.udacity.havealaugh.backend.MyBean;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.havealaugh.udacity.olamide.com",
                ownerName = "backend.havealaugh.udacity.olamide.com",
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

    @ApiMethod(name = "getJoke")
    public Joke getJoke(){
        JokeFactory jokeFactory = new JokeFactory();
        Joke joke =  jokeFactory.getDemoJoke();
        return joke;

    }

}
