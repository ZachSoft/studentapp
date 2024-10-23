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

    private TextView textName, textAge, textGrade, textMajor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        // Find TextViews
        textName = view.findViewById(R.id.text_name);
        textAge = view.findViewById(R.id.text_age);
        textGrade = view.findViewById(R.id.text_grade);
        textMajor = view.findViewById(R.id.text_major);

        // Get data from Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            textName.setText("Name: " + bundle.getString("name"));
            textAge.setText("Age: " + bundle.getString("age"));
            textGrade.setText("Grade: " + bundle.getString("grade"));
            textMajor.setText("Major: " + bundle.getString("major"));
        }

        return view;
    }
}
