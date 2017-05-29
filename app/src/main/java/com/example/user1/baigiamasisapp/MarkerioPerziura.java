package com.example.user1.baigiamasisapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class MarkerioPerziura extends AppCompatActivity {

    Intent returnIntent;
    private TextView pavadinimas, aprasas;
    private ImageView paveikslas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markerio_perziura);

        pavadinimas = (TextView) findViewById(R.id.pavadinimas);
        aprasas = (TextView) findViewById(R.id.aprasas);
        paveikslas = (ImageView) findViewById(R.id.didelispic);
        returnIntent = getIntent();


        pavadinimas.setText(returnIntent.getStringExtra("pavadinimas"));
        aprasas.setText(returnIntent.getStringExtra("aprasymas"));
        String image = returnIntent.getStringExtra("icona");
        //String image = MarkerSingleton.getInstance().returnMarker(pavadinimas.getText().toString(),aprasas.getText().toString()).getPaveiksliukas();
        byte[] imageArray = Base64.decode(image, Base64.DEFAULT);
        paveikslas.setImageBitmap(BitmapFactory.decodeByteArray(imageArray, 0, imageArray.length));

    }
}
