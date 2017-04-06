package com.example.user1.entities;

/**
 * Created by User1 on 2017-04-05.
 */

public class Kategorija {
    int id;
    String zymeklio_spalva;
    String objekto_tipas;

    public Kategorija() {
    }

    public Kategorija(int id, String zymeklio_spalva, String objekto_tipas) {
        this.id = id;
        this.zymeklio_spalva = zymeklio_spalva;
        this.objekto_tipas = objekto_tipas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZymeklio_spalva() {
        return zymeklio_spalva;
    }

    public void setZymeklio_spalva(String zymeklio_spalva) {
        this.zymeklio_spalva = zymeklio_spalva;
    }

    public String getObjekto_tipas() {
        return objekto_tipas;
    }

    public void setObjekto_tipas(String objekto_tipas) {
        this.objekto_tipas = objekto_tipas;
    }
}
