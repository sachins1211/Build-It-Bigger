package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sachin.androidjokes.JokeActivity;
import com.sachin.jokes.backend.myApi.MyApi;
import com.sachin.jokes.backend.myApi.model.Jokes;


/**
 * Created by sachin on 11/5/16.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, Jokes> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected Jokes doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
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

        context = params[0];

        try {
            return myApiService.randomJoke().execute();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Jokes result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        if (result != null) {
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra(JokeActivity.EXTRA_JOKE,result.getJokeText());
            context.startActivity(intent);
        } else {
            Toast.makeText(context,"Error!",Toast.LENGTH_SHORT).show();
        }
    }
}
