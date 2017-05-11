
package com.example.user1.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vartotojoid {

    @SerializedName("amzius")
    @Expose
    private Integer amzius;
    @SerializedName("elPastas")
    @Expose
    private String elPastas;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pavarde")
    @Expose
    private String pavarde;
    @SerializedName("slaptazodis")
    @Expose
    private String slaptazodis;
    @SerializedName("telefonas")
    @Expose
    private Integer telefonas;
    @SerializedName("vardas")
    @Expose
    private String vardas;
    @SerializedName("vartotojopav")
    @Expose
    private String vartotojopav;

    public Integer getAmzius() {
        return amzius;
    }

    public void setAmzius(Integer amzius) {
        this.amzius = amzius;
    }

    public String getElPastas() {
        return elPastas;
    }

    public void setElPastas(String elPastas) {
        this.elPastas = elPastas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public Integer getTelefonas() {
        return telefonas;
    }

    public void setTelefonas(Integer telefonas) {
        this.telefonas = telefonas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getVartotojopav() {
        return vartotojopav;
    }

    public void setVartotojopav(String vartotojopav) {
        this.vartotojopav = vartotojopav;
    }

}
