/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.lex.com.mobilelex.domain;

import android.support.annotation.XmlRes;

import java.util.Objects;

/**
 *
 * @author jfuentealba
 */

public class UserDataLoggin extends Control{
    
    private String user;
    private String nombreRol;
    private String idRol;
    private String correo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
  
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String column) {
        this.idRol = column;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "UserDataLoggin{" + "user=" + user + ", nombreRol=" + nombreRol + ", idRol=" + idRol + ", correo=" + correo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.user);
        hash = 23 * hash + Objects.hashCode(this.nombreRol);
        hash = 23 * hash + Objects.hashCode(this.idRol);
        hash = 23 * hash + Objects.hashCode(this.correo);
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
        final UserDataLoggin other = (UserDataLoggin) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.nombreRol, other.nombreRol)) {
            return false;
        }
        if (!Objects.equals(this.idRol, other.idRol)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    
    
}
