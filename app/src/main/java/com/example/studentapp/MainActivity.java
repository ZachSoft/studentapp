package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataSubmitListener {

    private Button buttonShowData;
    private String studentName, studentAge, studentGrade, studentMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial fragment transaction to display the Data Entry Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DataEntryFragment())
                    .commit();
        }

        buttonShowData = findViewById(R.id.button_show_data);

        // Button click listener to show the DisplayFragment
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with the DisplayFragment
                DisplayFragment displayFragment = new DisplayFragment();

                // Pass data to the DisplayFragment using Bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", studentName);
                bundle.putString("age", studentAge);
                bundle.putString("grade", studentGrade);
                bundle.putString("major", studentMajor);
                displayFragment.setArguments(bundle);

                // Perform fragment replacement
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, displayFragment)
                        .addToBackStack(null)  // Add to back stack so user can go back
                        .commit();
            }
        });
    }

    // This method will be called when data is submitted from DataEntryFragment
    @Override
    public void onDataSubmit(String name, String age, String grade, String major) {
        studentName = name;
        studentAge = age;
        studentGrade = grade;
        studentMajor = major;
    }
}

