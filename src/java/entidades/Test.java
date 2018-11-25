/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xazak
 */
@Entity
@Table(name = "TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByC1", query = "SELECT t FROM Test t WHERE t.c1 = :c1")
    , @NamedQuery(name = "Test.findByName", query = "SELECT t FROM Test t WHERE t.name = :name")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "C1")
    private BigDecimal c1;
    @Size(max = 25)
    @Column(name = "NAME")
    private String name;

    public Test() {
    }

    public Test(BigDecimal c1) {
        this.c1 = c1;
    }

    public BigDecimal getC1() {
        return c1;
    }

    public void setC1(BigDecimal c1) {
        this.c1 = c1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (c1 != null ? c1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.c1 == null && other.c1 != null) || (this.c1 != null && !this.c1.equals(other.c1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Test[ c1=" + c1 + " ]";
    }
    
}
