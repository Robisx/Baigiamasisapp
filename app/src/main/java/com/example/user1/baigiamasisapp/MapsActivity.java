package com.example.user1.baigiamasisapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user1.baigiamasisclient.MainAdapter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapas;
    private Spinner spineris;
    private LatLng markeriocoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bendras_map);
        spineris = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, MapTipai.getTipai());
        spineris.setAdapter(adapter);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapas = googleMap;
        updateMapType();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mapas.setMyLocationEnabled(true);
        }

        mapas.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                markeriocoord = latLng;
                Intent intent = new Intent(MapsActivity.this, MarkerCreationActivity.class);
                startActivityForResult(intent, 4096);
                intent.putExtra("koordinates", latLng);

            }
        });
    }


    private void updateMapType() {
        if (mapas == null) {
            return;
        }

        spineris.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mapas.setMapType(MAP_TYPE_NORMAL);
                        break;
                    case 1:
                        mapas.setMapType(MAP_TYPE_HYBRID);
                        break;
                    case 2:
                        mapas.setMapType(MAP_TYPE_SATELLITE);
                        break;
                    case 3:
                        mapas.setMapType(MAP_TYPE_TERRAIN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4096 && resultCode == Activity.RESULT_OK)
            if (getIntent() != null && markeriocoord != null) {
                String pav = (String) data.getExtras().get("Pavadinimas");
                String apr = (String) data.getExtras().get("Aprasas");
                String kat = (String) data.getExtras().get("Kategorija");
                mapas.addMarker(new MarkerOptions().position(markeriocoord).title(pav).snippet(apr));
                String coords = String.valueOf(markeriocoord.latitude) + ";" + String.valueOf(markeriocoord.longitude);
                new addMarkerasync(pav, apr, coords, kat).execute();
                markeriocoord = null;
            }
    }

    public class addMarkerasync extends AsyncTask<String[], Void, Void> {
        String pav;
        String apr;
        String coord;
        String kat;

        public addMarkerasync(String pav, String apr, String coord, String kat) {
            this.pav = pav;
            this.apr = apr;
            this.coord = coord;
            this.kat = kat;
        }

        @Override
        protected Void doInBackground(String[]... params) {
            new MainAdapter(MapsActivity.this).createVieta(pav, apr, coord, kat);

            return null;
        }

    }
}