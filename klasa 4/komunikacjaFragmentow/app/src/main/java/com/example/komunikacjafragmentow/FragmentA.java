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
//        EditText editText = view.findViewById(R.id.eText);
        Button button1 = view.findViewById(R.id.przycisk1);
        Button button2 = view.findViewById(R.id.przycisk2);
        Button button3 = view.findViewById(R.id.przycisk3);

        button1.setOnClickListener(v -> {
//            String text = String.valueOf(button1.getText());

            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("message","Bardzo");
            fragmentB.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentB)
                    .commit();
        });

        button2.setOnClickListener(v -> {
//            String text = String.valueOf(button2.getText());

            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("message","Lubię");
            fragmentB.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentB)
                    .commit();
        });

        button3.setOnClickListener(v -> {
//            String text = String.valueOf(button3.getText());

            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("message","Piwo");
            fragmentB.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentB)
                    .commit();
        });

        return view;
    }
}