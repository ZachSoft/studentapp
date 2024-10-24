package com.example.studentapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataEntryFragment extends Fragment {

    private EditText editName, editAge, editGrade, editMajor;
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);

        // Find views
        editName = view.findViewById(R.id.edit_name);
        editAge = view.findViewById(R.id.edit_age);
        editGrade = view.findViewById(R.id.edit_grade);
        editMajor = view.findViewById(R.id.edit_major);
        submitButton = view.findViewById(R.id.submit_button);

        // Set button click listener
        submitButton.setOnClickListener(v -> submitData());

        return view;
    }

    private void submitData() {
        // Get input values
        String name = editName.getText().toString().trim();
        String age = editAge.getText().toString().trim();
        String grade = editGrade.getText().toString().trim();
        String major = editMajor.getText().toString().trim();

        // Validate inputs
        if (name.isEmpty()) {
            editName.setError("Name is required");
            return;
        }

        if (age.isEmpty() || !isNumeric(age)) {
            editAge.setError("Valid age is required");
            return;
        }

        if (grade.isEmpty() || !isNumeric(grade)) {
            editGrade.setError("Valid grade is required");
            return;
        }

        // If all inputs are valid, send data to the activity
        if (getActivity() != null) {
            // Bundle to pass data
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("age", age);
            bundle.putString("grade", grade);
            bundle.putString("major", major.isEmpty() ? "N/A" : major);

            // Replace current fragment with DisplayFragment
            MainActivity activity = (MainActivity) getActivity();
            activity.displayStudentData(bundle);
        }
    }

    // Utility method to check if a string is a number
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

