package com.example.cicknimev2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cicknimev2.R;

public class TvFragment extends Fragment {

    public static TvFragment newInstance() {
        TvFragment tvFragment = new TvFragment();
        Bundle args = new Bundle();

        tvFragment.setArguments(args);

        return tvFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }
}