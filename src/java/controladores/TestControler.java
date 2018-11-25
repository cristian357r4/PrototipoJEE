/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Test;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import model.TestFacadeLocal;

/**
 *
 * @author xazak
 */
@Named(value = "testControler")
@SessionScoped
public class TestControler implements Serializable {

    /**
     * Creates a new instance of TestControler
     */
    @EJB
    private TestFacadeLocal test;
    private Test entidadTest= new Test();
 
    
    
    
    public List<Test> findAll(){
        //propiedades = Arrays.asList("c1","name");
        return this.test.findAll();
    }
    public Test getTest(){
        return entidadTest;
    }

    public void setEntidadTest(Test entidadTest) {
        this.entidadTest = entidadTest;
    }
    
    public String agregarTest(){
        this.test.create(entidadTest);
        this.entidadTest = new Test();
        return "";
    }
    public TestControler() {
    }
    
    
}
