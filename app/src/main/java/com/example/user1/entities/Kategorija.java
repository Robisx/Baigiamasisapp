package com.example.user1.entities;

/**
 * Created by User1 on 2017-04-05.
 */

public class Kategorija {
    int id;
    String zymeklio_spalva;
    String objektoTipas;

    public Kategorija() {
    }

    public Kategorija(int id, String zymeklio_spalva, String objektoTipas) {
        this.id = id;
        this.zymeklio_spalva = zymeklio_spalva;
        this.objektoTipas = objektoTipas;
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

    public String getObjektoTipas() {
        return objektoTipas;
    }

    public void setObjektoTipas(String objektoTipas) {
        this.objektoTipas = objektoTipas;
    }
}