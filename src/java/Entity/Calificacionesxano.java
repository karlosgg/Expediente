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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "calificacionesxano", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionesxano.findAll", query = "SELECT c FROM Calificacionesxano c"),
    @NamedQuery(name = "Calificacionesxano.findByIdCalificacionesXano", query = "SELECT c FROM Calificacionesxano c WHERE c.idCalificacionesXano = :idCalificacionesXano")})
public class Calificacionesxano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCalificacionesXano", nullable = false)
    private Integer idCalificacionesXano;
    @JoinColumn(name = "idCalificacion", referencedColumnName = "idCalificaciones")
    @ManyToOne
    private Calificaciones idCalificacion;
    @JoinColumn(name = "idano", referencedColumnName = "idAnoacademico")
    @ManyToOne
    private Anoacademico idano;

    public Calificacionesxano() {
    }

    public Calificacionesxano(Integer idCalificacionesXano) {
        this.idCalificacionesXano = idCalificacionesXano;
    }

    public Integer getIdCalificacionesXano() {
        return idCalificacionesXano;
    }

    public void setIdCalificacionesXano(Integer idCalificacionesXano) {
        this.idCalificacionesXano = idCalificacionesXano;
    }

    public Calificaciones getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificaciones idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Anoacademico getIdano() {
        return idano;
    }

    public void setIdano(Anoacademico idano) {
        this.idano = idano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacionesXano != null ? idCalificacionesXano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacionesxano)) {
            return false;
        }
        Calificacionesxano other = (Calificacionesxano) object;
        if ((this.idCalificacionesXano == null && other.idCalificacionesXano != null) || (this.idCalificacionesXano != null && !this.idCalificacionesXano.equals(other.idCalificacionesXano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Calificacionesxano[ idCalificacionesXano=" + idCalificacionesXano + " ]";
    }
    
}
