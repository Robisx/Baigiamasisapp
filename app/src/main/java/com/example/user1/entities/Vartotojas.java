package com.example.user1.entities;

/**
 * Created by User1 on 2017-04-06.
 */

public class Vartotojas {
    int id;
    String vartotojo_pav;
    String slaptazodis;
    String vardas;
    String pavarde;
    String el_pastas;
    String amzius;
    String telefonas;

    public Vartotojas() {
    }

    public Vartotojas(int id, String telefonas, String amzius, String el_pastas, String pavarde, String vardas, String slaptazodis, String vartotojo_pav) {
        this.id = id;
        this.telefonas = telefonas;
        this.amzius = amzius;
        this.el_pastas = el_pastas;
        this.pavarde = pavarde;
        this.vardas = vardas;
        this.slaptazodis = slaptazodis;
        this.vartotojo_pav = vartotojo_pav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }

    public String getAmzius() {
        return amzius;
    }

    public void setAmzius(String amzius) {
        this.amzius = amzius;
    }

    public String getEl_pastas() {
        return el_pastas;
    }

    public void setEl_pastas(String el_pastas) {
        this.el_pastas = el_pastas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getVartotojo_pav() {
        return vartotojo_pav;
    }

    public void setVartotojo_pav(String vartotojo_pav) {
        this.vartotojo_pav = vartotojo_pav;
    }
}
