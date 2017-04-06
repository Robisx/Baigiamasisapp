package com.example.user1.entities;

/**
 * Created by User1 on 2017-04-06.
 */

public class Vartotojas {
    int id;
    String vartotojopav;
    String slaptazodis;
    String vardas;
    String pavarde;
    String elPastas;
    String amzius;
    String telefonas;

    public Vartotojas() {
    }

    public Vartotojas(int id, String vartotojopav, String slaptazodis, String vardas, String pavarde, String elPastas, String amzius, String telefonas) {
        this.id = id;
        this.vartotojopav = vartotojopav;
        this.slaptazodis = slaptazodis;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.elPastas = elPastas;
        this.amzius = amzius;
        this.telefonas = telefonas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVartotojopav() {
        return vartotojopav;
    }

    public void setVartotojopav(String vartotojopav) {
        this.vartotojopav = vartotojopav;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public String getAmzius() {
        return amzius;
    }

    public void setAmzius(String amzius) {
        this.amzius = amzius;
    }

    public String getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(String telefonas) {
        this.telefonas = telefonas;
    }
}
