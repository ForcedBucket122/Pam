package com.example.fragmentyzadanie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;


public class NotesFragment extends Fragment {

    private String[] notatkiTytul;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        ListView listView = view.findViewById(R.id.notatki);

        assert getArguments() != null;
        String kategoria = getArguments().getString("kategoria");


        if (Objects.equals(kategoria, "Praca")){
            notatkiTytul = getResources().getStringArray(R.array.notatkiPraca);
        } else if (Objects.equals(kategoria, "Szkoła")) {
            notatkiTytul = getResources().getStringArray(R.array.notatkiSzkola);
        }else if (Objects.equals(kategoria, "Dom")) {
            notatkiTytul = getResources().getStringArray(R.array.notatkiDom);
        }else if (Objects.equals(kategoria, "Hobby")) {
            notatkiTytul = getResources().getStringArray(R.array.notatkiHobby);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                notatkiTytul
        );

        listView.setAdapter(adapter);


        Bundle bundle = new Bundle();
        NoteDetailFragment detailFragment = new NoteDetailFragment();
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String tytul = listView.getItemAtPosition(position).toString();
            bundle.putString("Tytul", tytul);
            bundle.putString("Tresc", tytul);
            bundle.putString("Kategoria", kategoria);
            detailFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, detailFragment)
                    .commit();
        });
        CategoryFragment categoryFragment = new CategoryFragment();
        ImageButton back = view.findViewById(R.id.goBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, categoryFragment)
                        .commit();
            }
        });
        return view;
    }
}