package com.example.user1.baigiamasisclient;

import android.content.Context;

import com.example.user1.baigiamasisapp.R;
import com.example.user1.entities.Kategorija;
import com.example.user1.entities.Kategorijaid;
import com.example.user1.entities.Vartotojas;
import com.example.user1.entities.VartotojasJson;
import com.example.user1.entities.VietaJson;
import com.example.user1.http.Transport;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by User1 on 2017-04-05.
 */

public class MainAdapter {

    private Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public List<Kategorija> getKategorijos() {
        List<Kategorija> cat = null;
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.kategorija_rest_urlas);
        String json = Transport.transport(url);
        Gson gson = new Gson();
        Kategorija[] katJsonArray = gson.fromJson(json, Kategorija[].class);
        cat = Arrays.asList(katJsonArray);
        return cat;
    }

    public Vartotojas getVartotojas(String str_user, String str_pass) {
        Vartotojas var;
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.vartotojas_rest_urlas);
        String json = Transport.authenticate(str_user, str_pass, url);
        Gson gson = new Gson();
        var = gson.fromJson(Transport.authenticate(str_user, str_pass, url), Vartotojas.class);
        return var;
    }

    public void createVartotojas(String varvar, String sla, String var, String pav, String elp, String amz, String tel) {
        VartotojasJson v = new VartotojasJson();
        v.setVartotojopav(varvar);
        v.setSlaptazodis(sla);
        v.setVardas(var);
        v.setPavarde(pav);
        v.setElPastas(elp);
        v.setAmzius(amz);
        v.setTelefonas(tel);
        Gson gson = new Gson();
        String json = gson.toJson(v);
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.vartotojas_rest_urlas);
        Transport.putJson(url, json);
    }

    public void createVieta(String vieta, String aprasymas, String koordinates, String kategorija, String pavei) {
        VietaJson v = new VietaJson();
        v.setPavadinimas(vieta);
        v.setTrumpasaprasymas(aprasymas);
        v.setKoordinates(koordinates);
        v.setSukurimoData(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        v.setPaveiksliukas(pavei);
        System.out.println(v.getSukurimoData());
        List<Kategorija> kategorijos = getKategorijos();
        for (Kategorija k : kategorijos) {
            if (k.getObjektoTipas().equalsIgnoreCase(kategorija)) {
                System.out.println(k.getObjektoTipas());
                System.out.println(kategorija);
                System.out.println("praejo");
                Kategorijaid krv = new Kategorijaid();
                krv.setId(k.getId());
                krv.setObjektoTipas(k.getObjektoTipas());
                krv.setZymeklioSpalva(k.getZymeklioSpalva());
                v.setKategorijaid(krv);
                break;
            }
        }
        v.setVartotojoid(UserSingleton.getInstance().getVartotojas());
        MarkerSingleton.getInstance().addMarker(v);
        Gson gson = new Gson();
        String json = gson.toJson(v);
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.vieta_rest_urlas);
        Transport.putJson(url, json);
        System.out.println(json);
    }

    public List<VietaJson> getVietos() {
        List<VietaJson> result = null;
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.vieta_rest_urlas);
        String json = Transport.transport(url);
        Gson gson = new Gson();
        VietaJson[] arr = gson.fromJson(json, VietaJson[].class);
        result = new ArrayList<>(Arrays.asList(arr));
        System.out.println(result.get(0).getTrumpasaprasymas());
        System.out.println(result.get(0).getPavadinimas());
        for (VietaJson v : result) {
            MarkerSingleton.getInstance().addMarker(v);
        }
        return result;
    }
}
