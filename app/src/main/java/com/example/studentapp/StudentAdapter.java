package com.example.studentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<Bundle> studentDataList;

    public StudentAdapter(ArrayList<Bundle> studentDataList) {
        this.studentDataList = studentDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bundle studentData = studentDataList.get(position);
        holder.textName.setText("Name: " + studentData.getString("name"));
        holder.textAge.setText("Age: " + studentData.getString("age"));
        holder.textGrade.setText("Grade: " + studentData.getString("grade"));
        holder.textMajor.setText("Major: " + studentData.getString("major"));
    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textAge, textGrade, textMajor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.display_name);
            textAge = itemView.findViewById(R.id.display_age);
            textGrade = itemView.findViewById(R.id.display_grade);
            textMajor = itemView.findViewById(R.id.display_major);
        }
    }
}
