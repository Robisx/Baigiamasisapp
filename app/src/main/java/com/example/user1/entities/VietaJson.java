
package com.example.user1.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VietaJson {

    @SerializedName("kategorijaid")
    @Expose
    private Kategorijaid kategorijaid;
    @SerializedName("koordinates")
    @Expose
    private String koordinates;
    @SerializedName("pavadinimas")
    @Expose
    private String pavadinimas;
    @SerializedName("sukurimoData")
    @Expose
    private String sukurimoData;
    @SerializedName("trumpasaprasymas")
    @Expose
    private String trumpasaprasymas;
    @SerializedName("vartotojoid")
    @Expose
    private Vartotojoid vartotojoid;

    public Kategorijaid getKategorijaid() {
        return kategorijaid;
    }

    public void setKategorijaid(Kategorijaid kategorijaid) {
        this.kategorijaid = kategorijaid;
    }

    public String getKoordinates() {
        return koordinates;
    }

    public void setKoordinates(String koordinates) {
        this.koordinates = koordinates;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getSukurimoData() {
        return sukurimoData;
    }

    public void setSukurimoData(String sukurimoData) {
        this.sukurimoData = sukurimoData;
    }

    public String getTrumpasaprasymas() {
        return trumpasaprasymas;
    }

    public void setTrumpasaprasymas(String trumpasaprasymas) {
        this.trumpasaprasymas = trumpasaprasymas;
    }

    public Vartotojoid getVartotojoid() {
        return vartotojoid;
    }

    public void setVartotojoid(Vartotojoid vartotojoid) {
        this.vartotojoid = vartotojoid;
    }

}
