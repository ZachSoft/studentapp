package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataSubmitListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load DataEntryFragment and DisplayFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_data_entry, new DataEntryFragment())
                    .replace(R.id.fragment_display, new DisplayFragment())
                    .commit();
        }
    }

    @Override
    public void onDataSubmit(String name, int age, int grade, String major) {
        // Pass the data to DisplayFragment
        DisplayFragment displayFragment = (DisplayFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_display);
        if (displayFragment != null) {
            displayFragment.updateStudentData(name, age, grade, major);
        }
    }
}
