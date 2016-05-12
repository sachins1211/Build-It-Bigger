package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sachin.androidjokes.JokeActivity;
import com.sachin.jokes.Joker;

public class MainActivity extends AppCompatActivity {

    private Joker joke;
    Toast mToast;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // joke = Joker.getInstance();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    public void tellJoke(View view){
        if(mToast != null)
        {
            mToast.cancel();
        }
        mToast = Toast.makeText(this,joke.getRandomJoke(), Toast.LENGTH_LONG);
        mToast.show();
    }
*/
    /*
    public void tellJoke(View view){
        Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE, joke.getRandomJoke());
        if(intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
    }
    */
    public void tellJoke(View view){
        new EndpointsAsyncTask().execute(this);
    }

}
