
package com.example.user1.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kategorijaid {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("objektoTipas")
    @Expose
    private String objektoTipas;
    @SerializedName("zymeklioSpalva")
    @Expose
    private String zymeklioSpalva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjektoTipas() {
        return objektoTipas;
    }

    public void setObjektoTipas(String objektoTipas) {
        this.objektoTipas = objektoTipas;
    }

    public String getZymeklioSpalva() {
        return zymeklioSpalva;
    }

    public void setZymeklioSpalva(String zymeklioSpalva) {
        this.zymeklioSpalva = zymeklioSpalva;
    }

}
