package com.example.user1.baigiamasisclient;

import com.example.user1.entities.Kategorija;
import com.example.user1.entities.VietaJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User1 on 2017-05-15.
 */

public class MarkerSingleton {
    private static final MarkerSingleton ourInstance = new MarkerSingleton();
    private List<VietaJson> markers = new ArrayList<>();
    private List<Kategorija> kategorijos = new ArrayList<>();

    private MarkerSingleton() {
    }

    public static MarkerSingleton getInstance() {
        return ourInstance;
    }

    public List<VietaJson> getMarkers() {
        return markers;
    }

    public void setMarkers(List<VietaJson> markers) {
        this.markers = markers;
    }

    public void addMarker(VietaJson marker) {
        markers.add(marker);
    }

    public List<Kategorija> getKategorijos() {
        return kategorijos;
    }

    public void setKategorijos(List<Kategorija> kategorijos) {
        this.kategorijos = kategorijos;
    }

    public VietaJson returnMarker(String name, String apr) {
        VietaJson v = null;
        for (VietaJson vi : markers) {
            if (vi.getPavadinimas().equalsIgnoreCase(name) && vi.getTrumpasaprasymas().equalsIgnoreCase(apr)) {
                v = vi;
            }
        }
        return v;
    }
}
