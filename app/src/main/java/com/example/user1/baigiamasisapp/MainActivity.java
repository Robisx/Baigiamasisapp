package com.example.user1.baigiamasisapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user1.baigiamasisclient.MainAdapter;
import com.example.user1.entities.Vartotojas;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText userName, passWord;
    private Button login, registracija;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        login = (Button) findViewById(R.id.login);
        registracija = (Button) findViewById(R.id.registracija);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new loginasync(userName.getText().toString(), passWord.getText().toString()).execute();
            }
        });

        registracija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistracijaActivity.class);
                startActivity(intent);
            }
        });

    }
    public class loginasync extends AsyncTask<String, Void, Vartotojas>{
        String s1;
        String s2;

        public loginasync(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        protected void onPostExecute(Vartotojas vartotojases) {
            super.onPostExecute(vartotojases);
            if (vartotojases != null){
                Intent intent = new Intent(MainActivity.this, PaskyraActivity.class);
                startActivity(intent);
            }
        }

        @Override
        protected Vartotojas doInBackground(String... params) {

            return new MainAdapter(MainActivity.this).getVartotojas(s1, s2);
        }
    }
}
