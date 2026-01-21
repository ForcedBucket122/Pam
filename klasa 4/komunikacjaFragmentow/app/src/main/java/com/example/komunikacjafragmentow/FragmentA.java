package com.example.komunikacjafragmentow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FragmentA extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        EditText editText = view.findViewById(R.id.eText);
        Button button = view.findViewById(R.id.przycisk);

        button.setOnClickListener(v -> {
            String text = String.valueOf(editText.getText());

            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("message",text);
            fragmentB.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentB)
                    .commit();
        });

        return view;
    }
}