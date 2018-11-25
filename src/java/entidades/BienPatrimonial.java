/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xazak
 */
@Entity
@Table(name = "BIEN_PATRIMONIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BienPatrimonial.findAll", query = "SELECT b FROM BienPatrimonial b")
    , @NamedQuery(name = "BienPatrimonial.findByIdPatrimonial", query = "SELECT b FROM BienPatrimonial b WHERE b.idPatrimonial = :idPatrimonial")
    , @NamedQuery(name = "BienPatrimonial.findByEstado", query = "SELECT b FROM BienPatrimonial b WHERE b.estado = :estado")})
public class BienPatrimonial implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PATRIMONIAL")
    private BigDecimal idPatrimonial;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_MATERIAL", referencedColumnName = "ID_MATERIAL")
    @ManyToOne(optional = false)
    private Material idMaterial;
    @OneToMany(mappedBy = "idPatrimonial")
    private List<Prestamo> prestamoList;

    public BienPatrimonial() {
    }

    public BienPatrimonial(BigDecimal idPatrimonial) {
        this.idPatrimonial = idPatrimonial;
    }

    public BigDecimal getIdPatrimonial() {
        return idPatrimonial;
    }

    public void setIdPatrimonial(BigDecimal idPatrimonial) {
        this.idPatrimonial = idPatrimonial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatrimonial != null ? idPatrimonial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BienPatrimonial)) {
            return false;
        }
        BienPatrimonial other = (BienPatrimonial) object;
        if ((this.idPatrimonial == null && other.idPatrimonial != null) || (this.idPatrimonial != null && !this.idPatrimonial.equals(other.idPatrimonial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.BienPatrimonial[ idPatrimonial=" + idPatrimonial + " ]";
    }
    
}
