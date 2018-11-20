package com.olamide.udacity.havealaugh;

import android.support.test.runner.AndroidJUnit4;

import com.olamide.udacity.havealaugh.backend.myApi.model.Joke;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest  {

    @Test
    public void testDoInBackground() throws InterruptedException {
        Thread.sleep(7000);

        final JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(new JokeAsynctaskInterface()
        {
            @Override
            public void didplayJoke(Joke joke) {

                assertNotNull(joke);
                assertNotNull(joke.getContent());
                assertNotEquals(joke.getContent(),"");
            }

        });

        jokeAsyncTask.execute();

    }
}
