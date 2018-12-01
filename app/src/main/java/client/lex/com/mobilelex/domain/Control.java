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
public abstract class  Control {
    private int codigo;
    private String mensaje;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.mensaje);
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
        final Control other = (Control) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Control{" + "codigo=" + codigo + ", mensaje=" + mensaje + '}';
    }
    
    
    
}
