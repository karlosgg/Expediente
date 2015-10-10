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
@Table(name = "calificacionesxmateria", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionesxmateria.findAll", query = "SELECT c FROM Calificacionesxmateria c"),
    @NamedQuery(name = "Calificacionesxmateria.findByIdCalificacionesXmateria", query = "SELECT c FROM Calificacionesxmateria c WHERE c.idCalificacionesXmateria = :idCalificacionesXmateria")})
public class Calificacionesxmateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCalificacionesXmateria", nullable = false)
    private Integer idCalificacionesXmateria;
    @JoinColumn(name = "idMateria", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMateria;
    @JoinColumn(name = "idCalificacion", referencedColumnName = "idCalificaciones")
    @ManyToOne
    private Calificaciones idCalificacion;

    public Calificacionesxmateria() {
    }

    public Calificacionesxmateria(Integer idCalificacionesXmateria) {
        this.idCalificacionesXmateria = idCalificacionesXmateria;
    }

    public Integer getIdCalificacionesXmateria() {
        return idCalificacionesXmateria;
    }

    public void setIdCalificacionesXmateria(Integer idCalificacionesXmateria) {
        this.idCalificacionesXmateria = idCalificacionesXmateria;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }

    public Calificaciones getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificaciones idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacionesXmateria != null ? idCalificacionesXmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacionesxmateria)) {
            return false;
        }
        Calificacionesxmateria other = (Calificacionesxmateria) object;
        if ((this.idCalificacionesXmateria == null && other.idCalificacionesXmateria != null) || (this.idCalificacionesXmateria != null && !this.idCalificacionesXmateria.equals(other.idCalificacionesXmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Calificacionesxmateria[ idCalificacionesXmateria=" + idCalificacionesXmateria + " ]";
    }
    
}
