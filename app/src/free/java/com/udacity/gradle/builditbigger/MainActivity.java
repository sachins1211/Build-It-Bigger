package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.sachin.androidjokes.JokeActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    boolean mIsAppPaidVersion;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mIsAppPaidVersion = getResources().getBoolean(R.bool.is_paid_version);

        if (!mIsAppPaidVersion) {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();
                    getAndDisplayJoke();
                }
            });
            requestNewInterstitial();
        }
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);

    }

    public void tellJoke(View view){
        if (!mIsAppPaidVersion && mInterstitialAd.isLoaded())
            mInterstitialAd.show();
        else {
            getAndDisplayJoke();
        }
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
                    Toast.makeText(MainActivity.this, getString(R.string.fetch_error), Toast.LENGTH_LONG).show();
                }
                mProgressBar.setVisibility(View.GONE);
            }
        }.execute();
    }
}
