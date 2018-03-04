package com.android.eam.gestioncelulares.Entidades;

import java.io.Serializable;

/**
 * Created by Daryl Ospina on 2/03/2018.
 */

public class ClsUsuario implements Serializable{

    private String nombreCompleto,nombreUsu,password;

    public ClsUsuario(String nombreCompleto, String nombreUsu, String password) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsu = nombreUsu;
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
