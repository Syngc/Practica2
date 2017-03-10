/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.practica2.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syn
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByDocumento", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.documento = :documento")
    , @NamedQuery(name = "Estudiante.findByTipodoc", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.tipodoc = :tipodoc")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByEmail", query = "SELECT e FROM Estudiante e WHERE e.email = :email")
    , @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Estudiante.findByDireccion", query = "SELECT e FROM Estudiante e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Estudiante.findByFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Estudiante.findByPrograma", query = "SELECT e FROM Estudiante e WHERE e.programa = :programa")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantePK estudiantePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "programa")
    private String programa;
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public Estudiante() {
    }

    public Estudiante(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public Estudiante(EstudiantePK estudiantePK, String nombre, String email, String telefono, String direccion, Date fechaNacimiento, String programa) {
        this.estudiantePK = estudiantePK;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.programa = programa;
    }

    public Estudiante(int documento, String tipodoc) {
        this.estudiantePK = new EstudiantePK(documento, tipodoc);
    }

    public EstudiantePK getEstudiantePK() {
        return estudiantePK;
    }

    public void setEstudiantePK(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudiantePK != null ? estudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudiantePK == null && other.estudiantePK != null) || (this.estudiantePK != null && !this.estudiantePK.equals(other.estudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.practica2.modelo.Estudiante[ estudiantePK=" + estudiantePK + " ]";
    }
    
}
