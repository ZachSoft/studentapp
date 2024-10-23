package com.example.studentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private TextView displayName, displayAge, displayGrade, displayMajor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        // Initialize views
        displayName = view.findViewById(R.id.display_name);
        displayAge = view.findViewById(R.id.display_age);
        displayGrade = view.findViewById(R.id.display_grade);
        displayMajor = view.findViewById(R.id.display_major);

        return view;
    }

    public void updateStudentData(String name, int age, int grade, String major) {
        displayName.setText("Name: " + name);
        displayAge.setText("Age: " + age);
        displayGrade.setText("Grade: " + grade);
        displayMajor.setText("Major: " + (major.isEmpty() ? "N/A" : major));
    }
}
