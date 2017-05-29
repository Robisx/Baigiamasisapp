package com.example.user1.baigiamasisapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user1.baigiamasisclient.MainAdapter;
import com.example.user1.entities.Kategorija;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MarkerCreationActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    Intent returnIntent;
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

        returnIntent = new Intent();
        new spinnerasync().execute();

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }
        });
        Intent i = getIntent();
        final String coord = i.getStringExtra("koordinates");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Neįrašytas pavadinimas";
                CharSequence text2 = "Neįrašytas vietovės aprašymas";
                int duration = Toast.LENGTH_SHORT;
                if (!pav.equals("") && pav != null) {
                    returnIntent.putExtra("Pavadinimas", pav.getText().toString());
                } else {
                    Toast.makeText(context, text, duration).show();
                }

                if ((!apr.getText().equals("") && apr != null) && (!pav.getText().equals("") && pav != null) && bArray1 != null) {
                    returnIntent.putExtra("Aprasas", apr.getText().toString());
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else {
                    Toast.makeText(context, text2, duration).show();
                }

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                returnIntent.putExtra("Kategorija", spinner.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context = getApplicationContext();
        CharSequence text3 = "Trūksta vietovės nuotraukos";
        int duration = Toast.LENGTH_SHORT;
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 100, bos);
            bArray1 = bos.toByteArray();
            String b64 = Base64.encodeToString(bArray1, Base64.DEFAULT);
            if (b64 != null && !b64.equals("")) {
                returnIntent.putExtra("paveiksliukas", b64);
            } else {
                Toast.makeText(context, text3, duration).show();
            }
            returnIntent.putExtra("icona", photo);
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

}
