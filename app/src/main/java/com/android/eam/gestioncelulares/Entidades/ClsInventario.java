package com.android.eam.gestioncelulares.Entidades;

import java.io.Serializable;

/**
 * Created by Daryl Ospina on 2/03/2018.
 */

public class ClsInventario implements Serializable{

    private String imeiCelular,nombreMarcaCelular,nombreCelular;

    public ClsInventario(String imeiCelular, String nombreMarcaCelular, String nombreCelular) {
        this.imeiCelular = imeiCelular;
        this.nombreMarcaCelular = nombreMarcaCelular;
        this.nombreCelular = nombreCelular;
    }

    public String getImeiCelular() {
        return imeiCelular;
    }

    public void setImeiCelular(String imeiCelular) {
        this.imeiCelular = imeiCelular;
    }

    public String getNombreMarcaCelular() {
        return nombreMarcaCelular;
    }

    public void setNombreMarcaCelular(String nombreMarcaCelular) {
        this.nombreMarcaCelular = nombreMarcaCelular;
    }

    public String getNombreCelular() {
        return nombreCelular;
    }

    public void setNombreCelular(String nombreCelular) {
        this.nombreCelular = nombreCelular;
    }
}
