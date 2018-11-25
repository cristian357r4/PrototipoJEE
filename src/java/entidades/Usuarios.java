/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByNocuenta", query = "SELECT u FROM Usuarios u WHERE u.nocuenta = :nocuenta")
    , @NamedQuery(name = "Usuarios.findByUnip", query = "SELECT u FROM Usuarios u WHERE u.unip = :unip")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApellidoPaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "Usuarios.findByApellidoMaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "Usuarios.findByTelNumber", query = "SELECT u FROM Usuarios u WHERE u.telNumber = :telNumber")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOCUENTA")
    private BigDecimal nocuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNIP")
    private BigInteger unip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Size(max = 30)
    @Column(name = "TEL_NUMBER")
    private String telNumber;
    @OneToMany(mappedBy = "nocuenta")
    private List<Prestamo> prestamoList;

    public Usuarios() {
    }

    public Usuarios(BigDecimal nocuenta) {
        this.nocuenta = nocuenta;
    }

    public Usuarios(BigDecimal nocuenta, BigInteger unip, String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nocuenta = nocuenta;
        this.unip = unip;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public BigDecimal getNocuenta() {
        return nocuenta;
    }

    public void setNocuenta(BigDecimal nocuenta) {
        this.nocuenta = nocuenta;
    }

    public BigInteger getUnip() {
        return unip;
    }

    public void setUnip(BigInteger unip) {
        this.unip = unip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
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
        hash += (nocuenta != null ? nocuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.nocuenta == null && other.nocuenta != null) || (this.nocuenta != null && !this.nocuenta.equals(other.nocuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuarios[ nocuenta=" + nocuenta + " ]";
    }
    
}
