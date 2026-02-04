package com.example.fragmentyzadanie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class NoteDetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);
        assert getArguments() != null;
        String tytul = getArguments().getString("Tytul");
        String tresc = getArguments().getString("Tresc");
        String kategoria = getArguments().getString("Kategoria");

        TextView textViewTytul = view.findViewById(R.id.tytul);
        TextView textViewTresc = view.findViewById(R.id.tresc);

        textViewTytul.setText(tytul);
        textViewTresc.setText(tresc);

        NotesFragment notesFragment = new NotesFragment();
        ImageButton back = view.findViewById(R.id.goBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("kategoria",kategoria);
                notesFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, notesFragment)
                        .commit();
            }
        });
        return view;
    }
}