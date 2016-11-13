package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.joke.jokerscreen.JokeActivity;

import static com.joke.jokerscreen.JokeActivity.EXTRA_JOKE;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        Button btnJoke = (Button) root.findViewById(R.id.btn_joke);
        btnJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJoke();

            }


        });
        return root;
    }

    private void fetchJoke() {
        new EndpointAsynkTask().execute(new JokeListener() {
            @Override
            public void onJokeFetched(String joke) {
                mJoke = joke;

                if (mJoke!= null) {
                    startJokeActivity(mJoke);
                }
            }
        });
    }

    private void startJokeActivity(String mJoke) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(EXTRA_JOKE, mJoke);
        startActivity(intent);
    }
}
