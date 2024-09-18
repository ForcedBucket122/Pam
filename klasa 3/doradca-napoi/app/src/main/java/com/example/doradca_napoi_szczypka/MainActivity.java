package com.example.doradca_napoi_szczypka;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void onClickFindBeer(View view) {
            TextView brands = (TextView) findViewById(R.id.brands);
            Spinner color = (Spinner) findViewById(R.id.color);
            Spinner marka = (Spinner) findViewById(R.id.marka);
            String Marc = String.valueOf((marka.getSelectedItem()));
            String beerType = String.valueOf(color.getSelectedItem());
            brands.setText(beerType+" "+Marc);
        }
}