package com.example.cicknimev2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cicknimev2.R;

public class LibraryFragment extends Fragment {

    public static LibraryFragment newInstance() {
        LibraryFragment libraryFragment = new LibraryFragment();
        Bundle args = new Bundle();

        libraryFragment.setArguments(args);

        return libraryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library, container, false);
    }
}