/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "calificaciones", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c"),
    @NamedQuery(name = "Calificaciones.findByIdCalificaciones", query = "SELECT c FROM Calificaciones c WHERE c.idCalificaciones = :idCalificaciones"),
    @NamedQuery(name = "Calificaciones.findByNota", query = "SELECT c FROM Calificaciones c WHERE c.nota = :nota")})
public class Calificaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCalificaciones", nullable = false)
    private Integer idCalificaciones;
    @Column(name = "Nota")
    private Long nota;
    @OneToMany(mappedBy = "idCalificacion")
    private List<Calificacionesxalumno> calificacionesxalumnoList;
    @OneToMany(mappedBy = "idCalificacion")
    private List<Calificacionesxano> calificacionesxanoList;
    @OneToMany(mappedBy = "idCalificacion")
    private List<Calificacionesxmateria> calificacionesxmateriaList;

    public Calificaciones() {
    }

    public Calificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public Integer getIdCalificaciones() {
        return idCalificaciones;
    }

    public void setIdCalificaciones(Integer idCalificaciones) {
        this.idCalificaciones = idCalificaciones;
    }

    public Long getNota() {
        return nota;
    }

    public void setNota(Long nota) {
        this.nota = nota;
    }

    @XmlTransient
    public List<Calificacionesxalumno> getCalificacionesxalumnoList() {
        return calificacionesxalumnoList;
    }

    public void setCalificacionesxalumnoList(List<Calificacionesxalumno> calificacionesxalumnoList) {
        this.calificacionesxalumnoList = calificacionesxalumnoList;
    }

    @XmlTransient
    public List<Calificacionesxano> getCalificacionesxanoList() {
        return calificacionesxanoList;
    }

    public void setCalificacionesxanoList(List<Calificacionesxano> calificacionesxanoList) {
        this.calificacionesxanoList = calificacionesxanoList;
    }

    @XmlTransient
    public List<Calificacionesxmateria> getCalificacionesxmateriaList() {
        return calificacionesxmateriaList;
    }

    public void setCalificacionesxmateriaList(List<Calificacionesxmateria> calificacionesxmateriaList) {
        this.calificacionesxmateriaList = calificacionesxmateriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificaciones != null ? idCalificaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.idCalificaciones == null && other.idCalificaciones != null) || (this.idCalificaciones != null && !this.idCalificaciones.equals(other.idCalificaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Calificaciones[ idCalificaciones=" + idCalificaciones + " ]";
    }
    
}
