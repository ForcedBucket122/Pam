package com.example.myapplication;

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

        Bundle bundle = getArguments();
        if (bundle != null) {
            String tekst = bundle.getString("message", "");
            textView.setText(tekst);
        }

        return view;
    }
}
