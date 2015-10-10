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
@Table(name = "calificacionesxalumno", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacionesxalumno.findAll", query = "SELECT c FROM Calificacionesxalumno c"),
    @NamedQuery(name = "Calificacionesxalumno.findByIdCalificacionesXalumno", query = "SELECT c FROM Calificacionesxalumno c WHERE c.idCalificacionesXalumno = :idCalificacionesXalumno"),
    @NamedQuery(name = "Calificacionesxalumno.findByEstado", query = "SELECT c FROM Calificacionesxalumno c WHERE c.estado = :estado")})
public class Calificacionesxalumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCalificacionesXalumno", nullable = false)
    private Integer idCalificacionesXalumno;
    @Size(max = 10)
    @Column(name = "Estado", length = 10)
    private String estado;
    @JoinColumn(name = "idCalificacion", referencedColumnName = "idCalificaciones")
    @ManyToOne
    private Calificaciones idCalificacion;
    @JoinColumn(name = "idAlumno", referencedColumnName = "Carnet")
    @ManyToOne
    private Alumnos idAlumno;

    public Calificacionesxalumno() {
    }

    public Calificacionesxalumno(Integer idCalificacionesXalumno) {
        this.idCalificacionesXalumno = idCalificacionesXalumno;
    }

    public Integer getIdCalificacionesXalumno() {
        return idCalificacionesXalumno;
    }

    public void setIdCalificacionesXalumno(Integer idCalificacionesXalumno) {
        this.idCalificacionesXalumno = idCalificacionesXalumno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Calificaciones getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificaciones idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Alumnos getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumnos idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalificacionesXalumno != null ? idCalificacionesXalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacionesxalumno)) {
            return false;
        }
        Calificacionesxalumno other = (Calificacionesxalumno) object;
        if ((this.idCalificacionesXalumno == null && other.idCalificacionesXalumno != null) || (this.idCalificacionesXalumno != null && !this.idCalificacionesXalumno.equals(other.idCalificacionesXalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Calificacionesxalumno[ idCalificacionesXalumno=" + idCalificacionesXalumno + " ]";
    }
    
}
