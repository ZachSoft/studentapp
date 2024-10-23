import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DataEntryFragment extends Fragment {

    private EditText editName, editAge, editGrade, editMajor;
    private Button submitButton;
    private OnDataSubmitListener dataSubmitListener;

    // Interface to communicate with the MainActivity
    public interface OnDataSubmitListener {
        void onDataSubmit(String name, String age, String grade, String major);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDataSubmitListener) {
            dataSubmitListener = (OnDataSubmitListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnDataSubmitListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);

        // Find input fields
        editName = view.findViewById(R.id.edit_name);
        editAge = view.findViewById(R.id.edit_age);
        editGrade = view.findViewById(R.id.edit_grade);
        editMajor = view.findViewById(R.id.edit_major);
        submitButton = view.findViewById(R.id.submit_button);

        // Submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String grade = editGrade.getText().toString();
                String major = editMajor.getText().toString();

                // Validate inputs (simple validation example)
                if (name.isEmpty() || age.isEmpty() || grade.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Send the data to MainActivity
                dataSubmitListener.onDataSubmit(name, age, grade, major);
            }
        });

        return view;
    }
}
