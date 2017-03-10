/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.practica2.logica;

import com.udea.practica2.modelo.Estudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author syn
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "practica2UP")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
}
