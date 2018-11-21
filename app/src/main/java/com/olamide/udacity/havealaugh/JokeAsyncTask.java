package com.olamide.udacity.havealaugh;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.olamide.udacity.havealaugh.backend.myApi.MyApi;
import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private JokeAsynctaskInterface jokeAsynctaskInterface;
    private static MyApi myApiService = null;


    public JokeAsyncTask(JokeAsynctaskInterface jokeAsynctaskInterface) {
        this.jokeAsynctaskInterface = jokeAsynctaskInterface;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    //.setRootUrl("http://192.168.43.187:8080/_ah/api/")
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }




        try {
            return myApiService.getJoke().execute().getData();
            //return "dndjsksddsldsddhfhd";
        } catch (IOException e) {
            Log.e("JokeAsynx", e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        jokeAsynctaskInterface.didplayJoke(joke);

            }


}
