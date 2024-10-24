package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataSubmitListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load DataEntryFragment by default
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DataEntryFragment())
                    .commit();
        }
    }

    // This method is called when the submit button is clicked in DataEntryFragment
    @Override
    public void onDataSubmit(Bundle data) {
        // Create and set arguments for DisplayFragment
        DisplayFragment displayFragment = new DisplayFragment();
        displayFragment.setArguments(data);

        // Replace DataEntryFragment with DisplayFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, displayFragment)
                .addToBackStack(null)  // Optionally add to back stack
                .commit();
    }
}


