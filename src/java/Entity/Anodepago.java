/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "anodepago", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anodepago.findAll", query = "SELECT a FROM Anodepago a"),
    @NamedQuery(name = "Anodepago.findByIdAnodepago", query = "SELECT a FROM Anodepago a WHERE a.idAnodepago = :idAnodepago"),
    @NamedQuery(name = "Anodepago.findByEstado", query = "SELECT a FROM Anodepago a WHERE a.estado = :estado")})
public class Anodepago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAnodepago", nullable = false)
    private Integer idAnodepago;
    @Size(max = 45)
    @Column(name = "Estado", length = 45)
    private String estado;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne
    private Pagos idPago;
    @JoinColumn(name = "idAnoacademico", referencedColumnName = "idAnoacademico")
    @ManyToOne
    private Anoacademico idAnoacademico;

    public Anodepago() {
    }

    public Anodepago(Integer idAnodepago) {
        this.idAnodepago = idAnodepago;
    }

    public Integer getIdAnodepago() {
        return idAnodepago;
    }

    public void setIdAnodepago(Integer idAnodepago) {
        this.idAnodepago = idAnodepago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pagos getIdPago() {
        return idPago;
    }

    public void setIdPago(Pagos idPago) {
        this.idPago = idPago;
    }

    public Anoacademico getIdAnoacademico() {
        return idAnoacademico;
    }

    public void setIdAnoacademico(Anoacademico idAnoacademico) {
        this.idAnoacademico = idAnoacademico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnodepago != null ? idAnodepago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anodepago)) {
            return false;
        }
        Anodepago other = (Anodepago) object;
        if ((this.idAnodepago == null && other.idAnodepago != null) || (this.idAnodepago != null && !this.idAnodepago.equals(other.idAnodepago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Anodepago[ idAnodepago=" + idAnodepago + " ]";
    }
    
}
