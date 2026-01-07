package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        EditText editText = view.findViewById(R.id.tekst);
        Button button = view.findViewById(R.id.wyslij);

        button.setOnClickListener(v -> {
            String tekst = editText.getText().toString();

            FragmentB fragmentB = new FragmentB();
            Bundle bundle = new Bundle();
            bundle.putString("message", tekst);
            fragmentB.setArguments(bundle);

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragmentB)
                    .commit();
        });

        return view;
    }
}
