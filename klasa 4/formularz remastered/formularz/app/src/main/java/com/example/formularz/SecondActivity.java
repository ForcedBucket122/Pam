package com.example.formularz;

import android.os.Bundle;
import android.widget.TextView;

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
    private TextView wynik;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Bundle b = getIntent().getExtras();

        assert b != null;
        String login = b.getString(KEY_LOGIN, "");
        String password = b.getString(KEY_PASSWORD, "");
        long pesel = b.getLong(KEY_PESEL, 0);
        String email = b.getString(KEY_EMAIL, "");
        String plec = b.getString(KEY_PLEC, "");
        String wyksztalcenie = b.getString(KEY_WYKSZTALCENIE, "");
        boolean regulamin = b.getBoolean(KEY_REGULAMIN, false);
        String zaakceptowano="";
        if (regulamin){
            zaakceptowano="zaakceptowano";
        }else{
            zaakceptowano="nie zaakceptowano";
        }
        wynik= findViewById(R.id.wynik);

        wynik.setText("Login: "+login+" Password: "+password+" PESEL:"+pesel+" Email: "+email+
                " Płeć: "+plec+" Wykształcenie: "+ wyksztalcenie+ "Regulamin: "+zaakceptowano);

    }
}
