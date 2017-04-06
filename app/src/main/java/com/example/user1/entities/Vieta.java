package com.example.user1.entities;

/**
 * Created by User1 on 2017-04-06.
 */

public class Vieta {
    int id;
    String pavadinimas;
    String trumpas_aprasymas;
    int kategorija_id;
    int vartotojo_id;
    String koordinates;
    String sukurimo_data;

    public Vieta() {
    }

    public Vieta(int id, String sukurimo_data, String koordinates, int vartotojo_id, int kategorija_id, String trumpas_aprasymas, String pavadinimas) {
        this.id = id;
        this.sukurimo_data = sukurimo_data;
        this.koordinates = koordinates;
        this.vartotojo_id = vartotojo_id;
        this.kategorija_id = kategorija_id;
        this.trumpas_aprasymas = trumpas_aprasymas;
        this.pavadinimas = pavadinimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getTrumpas_aprasymas() {
        return trumpas_aprasymas;
    }

    public void setTrumpas_aprasymas(String trumpas_aprasymas) {
        this.trumpas_aprasymas = trumpas_aprasymas;
    }

    public int getKategorija_id() {
        return kategorija_id;
    }

    public void setKategorija_id(int kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public int getVartotojo_id() {
        return vartotojo_id;
    }

    public void setVartotojo_id(int vartotojo_id) {
        this.vartotojo_id = vartotojo_id;
    }

    public String getKoordinates() {
        return koordinates;
    }

    public void setKoordinates(String koordinates) {
        this.koordinates = koordinates;
    }

    public String getSukurimo_data() {
        return sukurimo_data;
    }

    public void setSukurimo_data(String sukurimo_data) {
        this.sukurimo_data = sukurimo_data;
    }
}
