package com.joke.jokerscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String EXTRA_JOKE = "extra_joke";
    String mJoke = "No joke to display";

    public static void start(String joke, Context c) {
        Intent intent = new Intent(c, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        c.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            mJoke = getIntent().getExtras().getString(EXTRA_JOKE);
        }

        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);
        tvJoke.setText(mJoke);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
