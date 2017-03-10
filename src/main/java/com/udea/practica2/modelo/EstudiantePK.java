/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.practica2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author syn
 */
@Embeddable
public class EstudiantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "documento")
    private int documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipodoc")
    private String tipodoc;

    public EstudiantePK() {
    }

    public EstudiantePK(int documento, String tipodoc) {
        this.documento = documento;
        this.tipodoc = tipodoc;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documento;
        hash += (tipodoc != null ? tipodoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantePK)) {
            return false;
        }
        EstudiantePK other = (EstudiantePK) object;
        if (this.documento != other.documento) {
            return false;
        }
        if ((this.tipodoc == null && other.tipodoc != null) || (this.tipodoc != null && !this.tipodoc.equals(other.tipodoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.practica2.modelo.EstudiantePK[ documento=" + documento + ", tipodoc=" + tipodoc + " ]";
    }
    
}
