/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidades.BienPatrimonial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xazak
 */
@Local
public interface BienPatrimonialFacadeLocal {

    void create(BienPatrimonial bienPatrimonial);

    void edit(BienPatrimonial bienPatrimonial);

    void remove(BienPatrimonial bienPatrimonial);

    BienPatrimonial find(Object id);

    List<BienPatrimonial> findAll();

    List<BienPatrimonial> findRange(int[] range);

    int count();
    
}
