package com.example.formularz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String KEY_LOGIN = "key_login";
    public static final String KEY_PASSWORD = "key_password";
    public static final String KEY_PESEL = "key_pesel";
    public static final String KEY_EMAIL = "key_email";
    public static final String KEY_PLEC = "key_plec";
    public static final String KEY_WYKSZTALCENIE = "key_wyksztalcenie";
    public static final String KEY_REGULAMIN = "key_regulamin";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Bundle b = getIntent().getExtras();

        
    }
}
