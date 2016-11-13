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
