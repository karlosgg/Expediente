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
@Table(name = "alumnosxdocentes", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnosxdocentes.findAll", query = "SELECT a FROM Alumnosxdocentes a"),
    @NamedQuery(name = "Alumnosxdocentes.findByIdAlumnosXdocentes", query = "SELECT a FROM Alumnosxdocentes a WHERE a.idAlumnosXdocentes = :idAlumnosXdocentes")})
public class Alumnosxdocentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlumnosXdocentes", nullable = false)
    private Integer idAlumnosXdocentes;
    @JoinColumn(name = "idDocente", referencedColumnName = "idDocentes")
    @ManyToOne
    private Docentes idDocente;
    @JoinColumn(name = "idAlumno", referencedColumnName = "Carnet")
    @ManyToOne
    private Alumnos idAlumno;

    public Alumnosxdocentes() {
    }

    public Alumnosxdocentes(Integer idAlumnosXdocentes) {
        this.idAlumnosXdocentes = idAlumnosXdocentes;
    }

    public Integer getIdAlumnosXdocentes() {
        return idAlumnosXdocentes;
    }

    public void setIdAlumnosXdocentes(Integer idAlumnosXdocentes) {
        this.idAlumnosXdocentes = idAlumnosXdocentes;
    }

    public Docentes getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docentes idDocente) {
        this.idDocente = idDocente;
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
        hash += (idAlumnosXdocentes != null ? idAlumnosXdocentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnosxdocentes)) {
            return false;
        }
        Alumnosxdocentes other = (Alumnosxdocentes) object;
        if ((this.idAlumnosXdocentes == null && other.idAlumnosXdocentes != null) || (this.idAlumnosXdocentes != null && !this.idAlumnosXdocentes.equals(other.idAlumnosXdocentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Alumnosxdocentes[ idAlumnosXdocentes=" + idAlumnosXdocentes + " ]";
    }
    
}
