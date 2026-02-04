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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class NotesFragment extends Fragment {
    private static final Map<String, Integer> MAPA_TRESCI = new HashMap<String, Integer>() {{
        put("Spotkanie z klientem", R.string.spotkanie_z_klientem);
        put("Raport miesięczny", R.string.raport_miesieczny);
        put("Kubek", R.string.kubek);
        put("Zaliczenie z fragmentow", R.string.zaliczenie_z_fragmentow);
        put("Sprawdzian z ciągów arytmetycznych", R.string.sprawdzian_ciagi);
        put("zadanie domowe z polskiego", R.string.polski);
        put("Oproznic zmywarke", R.string.zmywarka);
        put("Podlac kwiatki", R.string.kwiatki);
        put("Uzupelnic Arsenal (Piwo)", R.string.arsenal);
        put("Trening", R.string.trening);
        put("Wypic piwo", R.string.piwo);
        put("Wyjsc na rower", R.string.rower);
    }};

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

            Integer Id = MAPA_TRESCI.get(tytul);
            String tresc;

            if (Id != null) {
                tresc = getResources().getString(Id);
            } else {
                tresc = "";
            }


            bundle.putString("Tresc", tresc);
            bundle.putString("Kategoria", kategoria);
            detailFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, detailFragment)
                    .commit();
        });


        CategoryFragment categoryFragment = new CategoryFragment();
        ImageButton back = view.findViewById(R.id.goBack);

        back.setOnClickListener(v -> requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, categoryFragment)
                .commit());
        return view;
    }
}