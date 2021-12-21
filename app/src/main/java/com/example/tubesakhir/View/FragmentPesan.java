package com.example.tubesakhir.View;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentPesanBinding;

public class FragmentPesan extends Fragment implements View.OnClickListener {
    private FragmentPesanBinding binding;
    private String[] genreValue = {"Bandung", "Jakarta", "Surabaya", "Semarang", "Bogor"};

    public static PesanFragment newInstance() {
        PesanFragment fragment = new PesanFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        this.binding = FragmentPesanBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return view;
    };

    @Override
    public void onClick(View view) {

    }
}
