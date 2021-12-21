package com.example.tubesakhir.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentBayarBinding;

public class FragmentBayar extends Fragment implements View.OnClickListener {
    private FragmentBayarBinding binding;
    private String[] genreValue = {"Bandung", "Jakarta", "Surabaya", "Semarang", "Bogor"};

    public static BayarFragment newInstance() {
        BayarFragment fragment = new BayarFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        this.binding = FragmentBayarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return view;
    };

    @Override
    public void onClick(View view) {

    }
}