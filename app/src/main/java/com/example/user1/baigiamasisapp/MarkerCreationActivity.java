package com.example.user1.baigiamasisapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.user1.baigiamasisclient.MainAdapter;
import com.example.user1.entities.Kategorija;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MarkerCreationActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private EditText pav, apr;
    private Spinner spinner;
    private Button save, camera;
    private ImageView image;
    private byte[] bArray1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_creation);

        final Intent intent = getIntent();

        pav = (EditText) findViewById(R.id.Pavadinimas);
        apr = (EditText) findViewById(R.id.tAprasymas);
        spinner = (Spinner) findViewById(R.id.spinner);
        save = (Button) findViewById(R.id.save);
        camera = (Button) findViewById(R.id.camera);
        image = (ImageView) findViewById(R.id.imageView);

        new spinnerasync().execute();

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new addMarkerasync(pav.getText().toString(), apr.getText().toString()).execute();
                Intent intent = new Intent(MarkerCreationActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bArray1 = bos.toByteArray();
        }
    }

    public class spinnerasync extends AsyncTask<String, Void, List<Kategorija>> {
        String pav, apr;


        @Override
        protected List<Kategorija> doInBackground(String... params) {
            return new MainAdapter(MarkerCreationActivity.this).getKategorijos();
        }

        @Override
        protected void onPostExecute(List<Kategorija> kategorijas) {
            super.onPostExecute(kategorijas);
            List<String> listas = new ArrayList<>();
            for (int i = 0; i < kategorijas.size(); i++) {
                listas.add(kategorijas.get(i).getObjektoTipas());

            }

            spinner.setAdapter(new ArrayAdapter<String>(MarkerCreationActivity.this, R.layout.support_simple_spinner_dropdown_item, listas));
        }
    }

    public class addMarkerasync extends AsyncTask<String[], Void, Void> {
        String pav;
        String apr;

        public addMarkerasync(String pav, String apr) {
            this.pav = pav;
            this.apr = apr;
        }

        @Override
        protected Void doInBackground(String[]... params) {
            new MainAdapter(MarkerCreationActivity.this).createVieta(pav, apr, "kazkokios koordinates");
            return null;
        }

    }
}
