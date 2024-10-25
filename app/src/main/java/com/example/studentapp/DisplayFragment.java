import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DisplayFragment extends Fragment {

    private RecyclerView recyclerView;
    private Button goBackButton;
    private ArrayList<Bundle> studentDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        // Initialize views
        recyclerView = view.findViewById(R.id.recycler_view);
        goBackButton = view.findViewById(R.id.go_back_btn);

        // Get the list of student data from arguments
        studentDataList = getArguments() != null ? getArguments().getParcelableArrayList("studentList") : new ArrayList<>();

        // Set up RecyclerView with adapter
        StudentAdapter adapter = new StudentAdapter(studentDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Go back to data entry on button click
        goBackButton.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        return view;
    }
}
