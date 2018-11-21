package com.olamide.udacity.havealaugh;

import android.support.test.runner.AndroidJUnit4;



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
            public void didplayJoke(String joke) {

                assertNotNull(joke);
                assertNotEquals(joke,"");
            }

        });

        jokeAsyncTask.execute();

    }
}
