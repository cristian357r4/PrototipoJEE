/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Prestamo;
import static entidades.Prestamo_.fechaPrestamo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import java.sql.*;
import java.sql.Date;
import model.PrestamoFacadeLocal;

/**
 *
 * @author xazak
 */
@Named(value = "controlPrestamos")
@SessionScoped
public class ControlPrestamos implements Serializable {
    @EJB
    private PrestamoFacadeLocal prestamosFacade;
    private Prestamo entidadPrestamos = new Prestamo();
    private boolean canEdit;
    
    public List<Prestamo> findAll(){
        return this.prestamosFacade.findAll();
    }
    
    public Prestamo getPrestamo(){
        return entidadPrestamos;
    }
    
    public void setEntidadPrestamos(Prestamo entidadPrestamo){
        this.entidadPrestamos = entidadPrestamo;        
    }
    
    public String agregarPrestamo(){
        java.sql.Date fecha = getCurrentJavaSqlDate();
        
        entidadPrestamos.setFechaPrestamo(fecha);
        this.prestamosFacade.create(entidadPrestamos);
        this.entidadPrestamos = new Prestamo();
        return "";
    }
    /**
     * Creates a new instance of ControlPrestamos
     */
    
    public static java.sql.Date getCurrentJavaSqlDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    
      public boolean isCanEdit() {
      return canEdit;
   }

   public void setCanEdit(boolean canEdit) {
      this.canEdit = canEdit;
   }	
   public ControlPrestamos() {
       
   }
    
}
