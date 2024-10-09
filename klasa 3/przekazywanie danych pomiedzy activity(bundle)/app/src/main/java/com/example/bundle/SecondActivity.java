package com.example.bundle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String KEY_TEXT = "key_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        Bundle b = getIntent().getExtras();
        String text= b.getString(KEY_TEXT,"");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
}
