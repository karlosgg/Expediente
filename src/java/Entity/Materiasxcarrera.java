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
@Table(name = "materiasxcarrera", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiasxcarrera.findAll", query = "SELECT m FROM Materiasxcarrera m"),
    @NamedQuery(name = "Materiasxcarrera.findByIdMateriasXcarrera", query = "SELECT m FROM Materiasxcarrera m WHERE m.idMateriasXcarrera = :idMateriasXcarrera")})
public class Materiasxcarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMateriasXcarrera", nullable = false)
    private Integer idMateriasXcarrera;
    @JoinColumn(name = "idMateria", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMateria;
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera idCarrera;

    public Materiasxcarrera() {
    }

    public Materiasxcarrera(Integer idMateriasXcarrera) {
        this.idMateriasXcarrera = idMateriasXcarrera;
    }

    public Integer getIdMateriasXcarrera() {
        return idMateriasXcarrera;
    }

    public void setIdMateriasXcarrera(Integer idMateriasXcarrera) {
        this.idMateriasXcarrera = idMateriasXcarrera;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriasXcarrera != null ? idMateriasXcarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiasxcarrera)) {
            return false;
        }
        Materiasxcarrera other = (Materiasxcarrera) object;
        if ((this.idMateriasXcarrera == null && other.idMateriasXcarrera != null) || (this.idMateriasXcarrera != null && !this.idMateriasXcarrera.equals(other.idMateriasXcarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Materiasxcarrera[ idMateriasXcarrera=" + idMateriasXcarrera + " ]";
    }
    
}
