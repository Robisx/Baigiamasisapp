package com.example.user1.baigiamasisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaskyraActivity extends AppCompatActivity {

    private Button zymekliai, zemelapis, atsijungti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paskyra);

        zymekliai = (Button) findViewById(R.id.zymekliai);
        zemelapis = (Button) findViewById(R.id.zemelapis);
        atsijungti = (Button) findViewById(R.id.atsijungti);

        zemelapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaskyraActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
