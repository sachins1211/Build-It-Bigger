package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sachin.androidjokes.JokeActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    public void tellJoke(View view){
        getAndDisplayJoke();
    }

    private void getAndDisplayJoke() {
        mProgressBar.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
                    intent.putExtra(JokeActivity.EXTRA_JOKE, result);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Error fetching Jokes from server!", Toast.LENGTH_LONG).show();
                }
                mProgressBar.setVisibility(View.GONE);
            }
        }.execute();
    }
}
