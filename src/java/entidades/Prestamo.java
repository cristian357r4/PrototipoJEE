/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xazak
 */
@Entity
@Table(name = "PRESTAMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByIdPrestamo", query = "SELECT p FROM Prestamo p WHERE p.idPrestamo = :idPrestamo")
    , @NamedQuery(name = "Prestamo.findByFolio", query = "SELECT p FROM Prestamo p WHERE p.folio = :folio")
    , @NamedQuery(name = "Prestamo.findByFechaPrestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaPrestamo = :fechaPrestamo")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRESTAMO")
    private BigDecimal idPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLIO")
    private BigInteger folio;
    @Column(name = "FECHA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @JoinColumn(name = "ID_PATRIMONIAL", referencedColumnName = "ID_PATRIMONIAL")
    @ManyToOne
    private BienPatrimonial idPatrimonial;
    @JoinColumn(name = "NOCUENTA", referencedColumnName = "NOCUENTA")
    @ManyToOne
    private Usuarios nocuenta;

    public Prestamo() {
    }

    public Prestamo(BigDecimal idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo(BigDecimal idPrestamo, BigInteger folio) {
        this.idPrestamo = idPrestamo;
        this.folio = folio;
    }

    public BigDecimal getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(BigDecimal idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigInteger getFolio() {
        return folio;
    }

    public void setFolio(BigInteger folio) {
        this.folio = folio;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public BienPatrimonial getIdPatrimonial() {
        return idPatrimonial;
    }

    public void setIdPatrimonial(BienPatrimonial idPatrimonial) {
        this.idPatrimonial = idPatrimonial;
    }

    public Usuarios getNocuenta() {
        return nocuenta;
    }

    public void setNocuenta(Usuarios nocuenta) {
        this.nocuenta = nocuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Prestamo[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
