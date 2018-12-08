/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.lex.com.mobilelex.domain;

import java.util.Objects;

/**
 *
 * @author Joaquin
 */
public class Presupuestos extends Control{
    public String nombre;
    public String codSolicitud;
    public String estadoAvance;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodSolicitud() {
        return codSolicitud;
    }

    public void setCodSolicitud(String codSolicitud) {
        this.codSolicitud = codSolicitud;
    }

    public String getEstadoAvance() {
        return estadoAvance;
    }

    public void setEstadoAvance(String estadoAvance) {
        this.estadoAvance = estadoAvance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.codSolicitud);
        hash = 89 * hash + Objects.hashCode(this.estadoAvance);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Presupuestos other = (Presupuestos) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.codSolicitud, other.codSolicitud)) {
            return false;
        }
        if (!Objects.equals(this.estadoAvance, other.estadoAvance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Presupuestos{" + "nombre=" + nombre + ", codSolicitud=" + codSolicitud + ", estadoAvance=" + estadoAvance + '}';
    }
    
    
    
}
