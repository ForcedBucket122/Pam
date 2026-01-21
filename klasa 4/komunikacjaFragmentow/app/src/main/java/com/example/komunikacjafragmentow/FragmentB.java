package com.example.komunikacjafragmentow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        TextView textView = view.findViewById(R.id.wyswietl);

        assert getArguments() != null;
        String value = getArguments().getString("message");
        textView.setText(value);

        return view;
    }
}