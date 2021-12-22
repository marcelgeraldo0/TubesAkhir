package com.example.tubesakhir.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tubesakhir.MainActivity;
import com.example.tubesakhir.R;
import com.example.tubesakhir.Model.Course;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecycleViewAdapter";

    private List<Course> list_Course_History;
    private Context context;
    private MainActivity activity;

    public RecyclerViewAdapter(List<Course> list_course_History, MainActivity activity) {
        this.list_Course_History = list_course_History;
        this.activity = activity;
        if (list_Course_History.isEmpty()) {
            this.list_Course_History = new ArrayList<Course>();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_case,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        ((ViewHolder) holder).tv_index.setText(String.valueOf(position + 1));
    }
    public void add(List<Course> caseInput) {
        this.list_Course_History.addAll(caseInput);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list_Course_History.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int index = 1;
        TextView tv_index;
        TextView tv_country_list;
        TextView tv_total_list;
        LinearLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_index = itemView.findViewById(R.id.tv_index_list);
            tv_country_list = itemView.findViewById(R.id.tv_country_list);
            tv_total_list = itemView.findViewById(R.id.tv_total_case_list);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
