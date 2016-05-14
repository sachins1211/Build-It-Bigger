package com.sachin.jokes.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.sachin.jokes.Joker;
import com.sachin.jokes.Jokes;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.jokes.sachin.com",
    ownerName = "backend.jokes.sachin.com",
    packagePath=""
  )
)

public class MyEndpoint {
    @ApiMethod(name = "randomJoke")
    public Jokes randomJoke() {
        Joker joker = Joker.getInstance();
        return joker.getRandomJoke();
    }
}
