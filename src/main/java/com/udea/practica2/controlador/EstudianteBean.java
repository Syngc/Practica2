/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.practica2.controlador;

import com.udea.practica2.modelo.Estudiante;
import com.udea.practica2.logica.EstudianteFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author syn
 */
@Named(value = "estudianteBean")
@SessionScoped
public class EstudianteBean implements Serializable {
     //Declaracion de variables
    private int documento;
    private String nombre;
    private String tipodoc;
    private String email;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento = new Date();
    private String programa;
    private byte[] foto;
    private Estudiante e;
    private boolean disable=true;    
    String m;
    
    //Anotaciones
    @EJB
    private EstudianteFacadeLocal EstudianteFacade;
    private UIComponent mybutton;

    public EstudianteFacadeLocal getEstudianteFacade() {
        return EstudianteFacade;
    }

    public void setEstudianteFacade(EstudianteFacadeLocal EstudianteFacade) {
        this.EstudianteFacade = EstudianteFacade;
    }

    public UIComponent getMybutton() {
        return mybutton;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    
    
    /**
     * Creates a new instance of EstudianteBean
     */
    public EstudianteBean() {
    }
    
    //Setters y getters

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Estudiante getE() {
        return e;
    }

    public void setE(Estudiante e) {
        this.e = e;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
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
    
    //Accion para insertar registro en la BD
    public String guardar(){
        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setTelefono(telefono);
        e.setDireccion(direccion);
        e.setEmail(email);
        e.setFechaNacimiento(fechaNacimiento);
        e.setPrograma(programa);
        e.setFoto(foto);
        this.EstudianteFacade.create(e);        
        return "Estudiante Creado";   
    }
    
    //Accion para validar
    public void validar(){
        disable = false;
    }
    
    //Para Internacionalizacion
    private Locale locale = FacesContext.getCurrentInstance()
            .getViewRoot().getLocale();
    
    public Locale  getLocale(){
        return locale;
    }
    
    public String getLanguage(){
        return locale.getLanguage();
    }
    
    public void changeLanguage(String language){
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
        
}
