/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.Prestamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xazak
 */
@Stateless
public class PrestamoFacade extends AbstractFacade<Prestamo> implements PrestamoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoPrestamodeMaterialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoFacade() {
        super(Prestamo.class);
    }
    
}
