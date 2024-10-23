package com.example.studentapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataEntryFragment extends Fragment {

    private EditText editName, editAge, editGrade, editMajor;
    private Button submitButton;

    OnDataSubmitListener callback;

    // Interface to communicate with MainActivity
    public interface OnDataSubmitListener {
        void onDataSubmit(String name, int age, int grade, String major);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            callback = (OnDataSubmitListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDataSubmitListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);

        // Initialize fields
        editName = view.findViewById(R.id.edit_name);
        editAge = view.findViewById(R.id.edit_age);
        editGrade = view.findViewById(R.id.edit_grade);
        editMajor = view.findViewById(R.id.edit_major);
        submitButton = view.findViewById(R.id.submit_button);

        // Submit button listener
        submitButton.setOnClickListener(v -> submitData());

        return view;
    }

    private void submitData() {
        // Validate input fields
        String name = editName.getText().toString().trim();
        String ageStr = editAge.getText().toString().trim();
        String gradeStr = editGrade.getText().toString().trim();
        String major = editMajor.getText().toString().trim();

        if (name.isEmpty()) {
            editName.setError("Name is required");
            return;
        }

        int age, grade;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            editAge.setError("Invalid age");
            return;
        }

        try {
            grade = Integer.parseInt(gradeStr);
            if (grade < 0 || grade > 100) {
                editGrade.setError("Grade should be between 0 and 100");
                return;
            }
        } catch (NumberFormatException e) {
            editGrade.setError("Invalid grade");
            return;
        }

        // Send data to MainActivity
        callback.onDataSubmit(name, age, grade, major);
    }
}
