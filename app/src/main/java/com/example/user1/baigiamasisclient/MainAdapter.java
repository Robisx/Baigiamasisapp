package com.example.user1.baigiamasisclient;

import android.content.Context;

import com.example.user1.baigiamasisapp.R;
import com.example.user1.entities.Kategorija;
import com.example.user1.entities.Vartotojas;
import com.example.user1.http.Transport;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by User1 on 2017-04-05.
 */

public class MainAdapter {
    private Context context ;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public List<Kategorija> getKategorijos (){
        List<Kategorija> cat = null;
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.kategoryja_rest_urlas);
        String json = Transport.transport(url);
        Gson gson = new Gson();
        Kategorija[] katJsonArray = gson.fromJson(json, Kategorija[].class);
        cat = Arrays.asList(katJsonArray);
        return cat;
    }
    public List<Vartotojas> getVartotojas (String str_user, String str_pass){
        List<Vartotojas> var = null;
        String url = this.context.getResources().getString(R.string.base_rest_urlas) +
                this.context.getResources().getString(R.string.vartotojas_rest_urlas);
        String json = Transport.authenticate(str_user, str_pass, url);
        Gson gson = new Gson();
        Vartotojas[] varJson = gson.fromJson(json, Vartotojas[].class);
        var = Arrays.asList(varJson);
        return var;
    }
}
