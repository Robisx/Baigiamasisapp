package com.example.user1.entities;

import java.util.Date;

/**
 * Created by User1 on 2017-05-06.
 */

public class VietaJson {
    private String vieta;
    private String aprasymas;
    private String koordinates;
    private Date data;

    public VietaJson(String vieta, String aprasymas, String koordinates) {
        this.vieta = vieta;
        this.aprasymas = aprasymas;
        this.koordinates = koordinates;
    }

    public VietaJson() {
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVieta() {
        return vieta;
    }

    public void setVieta(String vieta) {
        this.vieta = vieta;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public String getKoordinates() {
        return koordinates;
    }

    public void setKoordinates(String koordinates) {
        this.koordinates = koordinates;
    }
}
