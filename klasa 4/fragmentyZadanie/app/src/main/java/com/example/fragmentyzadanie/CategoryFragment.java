package com.example.fragmentyzadanie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);



        ListView listView = view.findViewById(R.id.list);
        Bundle bundle = new Bundle();

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            bundle.putString("kategoria",String.valueOf(listView.getItemAtPosition(position)) );
            NotesFragment notesFragment  = new NotesFragment();
            notesFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, notesFragment)
                    .commit();
        });

        return view;
    }
}