package com.example.user1.baigiamasisapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.user1.baigiamasisclient.MainAdapter;
import com.example.user1.baigiamasisclient.MarkerSingleton;
import com.example.user1.entities.VietaJson;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_TERRAIN;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mapas;
    private Spinner spineris;
    private LatLng markeriocoord;
    private Bitmap icona;


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
        System.out.println(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION));
        new loadMarkersAsync().execute();

        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 4095);


        mapas.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                markeriocoord = latLng;
                Intent intent = new Intent(MapsActivity.this, MarkerCreationActivity.class);
                startActivityForResult(intent, 4096);
                intent.putExtra("koordinates", latLng);

            }
        });
        mapas.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            Context context = getApplicationContext();
            CharSequence text = "paspaudei inforamcija";

            @Override
            public void onInfoWindowClick(Marker marker) {

                Intent intent = new Intent(MapsActivity.this, MarkerioPerziura.class);
                intent.putExtra("pavadinimas", marker.getTitle());
                intent.putExtra("aprasymas", marker.getSnippet().toString());
                String image = (MarkerSingleton.getInstance().returnMarker(marker.getTitle(), marker.getSnippet()).getPaveiksliukas());
                intent.putExtra("icona", image);
                startActivity(intent);

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
        if (mapas != null) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mapas.setMyLocationEnabled(true);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println(requestCode);
        System.out.println(grantResults.length);
        switch (requestCode) {
            case 4095: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        mapas.setMyLocationEnabled(true);
                    }
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4096 && resultCode == Activity.RESULT_OK)
            if (getIntent() != null && markeriocoord != null) {
                String pav = (String) data.getExtras().get("Pavadinimas");
                String apr = (String) data.getExtras().get("Aprasas");
                String kat = (String) data.getExtras().get("Kategorija");
                String pavei = (String) data.getExtras().get("paveiksliukas");
                icona = (Bitmap) data.getExtras().get("icona");

                mapas.addMarker(new MarkerOptions().position(markeriocoord).title(pav).snippet(apr).icon(BitmapDescriptorFactory.fromBitmap(icona)));
                String coords = String.valueOf(markeriocoord.latitude) + ";" + String.valueOf(markeriocoord.longitude);
                new addMarkerasync(pav, apr, coords, kat, pavei).execute();
                markeriocoord = null;
            }
    }

    public class addMarkerasync extends AsyncTask<String[], Void, Void> {
        String pav;
        String apr;
        String coord;
        String kat;
        String pavei;

        public addMarkerasync(String pav, String apr, String coord, String kat, String pavei) {
            this.pav = pav;
            this.apr = apr;
            this.coord = coord;
            this.kat = kat;
            this.pavei = pavei;
        }

        @Override
        protected Void doInBackground(String[]... params) {
            new MainAdapter(MapsActivity.this).createVieta(pav, apr, coord, kat, pavei);

            return null;
        }

    }

    public class loadMarkersAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            new MainAdapter(MapsActivity.this).getVietos();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            List<VietaJson> r = MarkerSingleton.getInstance().getMarkers();
            for (VietaJson v : r) {

                String[] s = v.getKoordinates().split(";");
                LatLng l = new LatLng(Double.valueOf(s[0]), Double.valueOf(s[1]));
                Bitmap b = BitmapFactory.decodeByteArray(Base64.decode(v.getPaveiksliukas(), Base64.DEFAULT), 0, Base64.decode(v.getPaveiksliukas(), Base64.DEFAULT).length);

                mapas.addMarker(
                        new MarkerOptions().position(l)
                                .title(v.getPavadinimas())
                                .snippet(v.getTrumpasaprasymas())
                                .icon(BitmapDescriptorFactory.fromBitmap(b)));
            }
        }
    }
}