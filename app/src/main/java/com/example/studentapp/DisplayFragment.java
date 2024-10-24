package com.example.studentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private TextView textName, textAge, textGrade, textMajor;
    private Button goBackButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        // Find views
        textName = view.findViewById(R.id.display_name);
        textAge = view.findViewById(R.id.display_age);
        textGrade = view.findViewById(R.id.display_grade);
        textMajor = view.findViewById(R.id.display_major);
        goBackButton = view.findViewById(R.id.go_back_btn);

        // Get data from arguments passed by MainActivity
        Bundle bundle = getArguments();
        if (bundle != null) {
            textName.setText("Name: " + bundle.getString("name"));
            textAge.setText("Age: " + bundle.getString("age"));
            textGrade.setText("Grade: " + bundle.getString("grade"));
            textMajor.setText("Major: " + bundle.getString("major"));
        }

        // Handle "Go Back" button click
        goBackButton.setOnClickListener(v -> {
            // Use FragmentManager to navigate back to DataEntryFragment
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}
