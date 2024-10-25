package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataSubmitListener {

    private ArrayList<Bundle> studentDataList = new ArrayList<>();  // List to store student data

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

    @Override
    public void onDataSubmit(Bundle data) {
        studentDataList.add(data);  // Add data to the list

        // Pass the updated list to DisplayFragment
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("studentList", studentDataList);
        displayFragment.setArguments(bundle);

        // Replace DataEntryFragment with DisplayFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, displayFragment)
                .addToBackStack(null)
                .commit();
    }
}


