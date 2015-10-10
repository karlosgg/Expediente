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
@Table(name = "alumnosxmaterias", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnosxmaterias.findAll", query = "SELECT a FROM Alumnosxmaterias a"),
    @NamedQuery(name = "Alumnosxmaterias.findByIdAlumnosXMaterias", query = "SELECT a FROM Alumnosxmaterias a WHERE a.idAlumnosXMaterias = :idAlumnosXMaterias")})
public class Alumnosxmaterias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAlumnosXMaterias", nullable = false)
    private Integer idAlumnosXMaterias;
    @JoinColumn(name = "idMateria", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMateria;
    @JoinColumn(name = "idAlumno", referencedColumnName = "Carnet")
    @ManyToOne
    private Alumnos idAlumno;

    public Alumnosxmaterias() {
    }

    public Alumnosxmaterias(Integer idAlumnosXMaterias) {
        this.idAlumnosXMaterias = idAlumnosXMaterias;
    }

    public Integer getIdAlumnosXMaterias() {
        return idAlumnosXMaterias;
    }

    public void setIdAlumnosXMaterias(Integer idAlumnosXMaterias) {
        this.idAlumnosXMaterias = idAlumnosXMaterias;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
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
        hash += (idAlumnosXMaterias != null ? idAlumnosXMaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnosxmaterias)) {
            return false;
        }
        Alumnosxmaterias other = (Alumnosxmaterias) object;
        if ((this.idAlumnosXMaterias == null && other.idAlumnosXMaterias != null) || (this.idAlumnosXMaterias != null && !this.idAlumnosXMaterias.equals(other.idAlumnosXMaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Alumnosxmaterias[ idAlumnosXMaterias=" + idAlumnosXMaterias + " ]";
    }
    
}
