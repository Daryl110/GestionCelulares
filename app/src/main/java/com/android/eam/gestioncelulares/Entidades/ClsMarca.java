package com.android.eam.gestioncelulares.Entidades;

import java.io.Serializable;

/**
 * Created by Daryl Ospina on 2/03/2018.
 */

public class ClsMarca implements Serializable{

    private String nombre,descripcion;

    public ClsMarca(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
