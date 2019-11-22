package com.example.softwarica_dha.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwarica_dha.Adapter.StudentAdapter;
import com.example.softwarica_dha.HomeActivity;
import com.example.softwarica_dha.R;

public class HomeFrag extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);
        StudentAdapter studentAdapter = new StudentAdapter(getContext(), HomeActivity.studentsList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}

