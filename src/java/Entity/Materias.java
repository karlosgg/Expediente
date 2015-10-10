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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Admin
 */
@Entity
@Table(name = "materias", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m"),
    @NamedQuery(name = "Materias.findByIdMaterias", query = "SELECT m FROM Materias m WHERE m.idMaterias = :idMaterias"),
    @NamedQuery(name = "Materias.findByNombre", query = "SELECT m FROM Materias m WHERE m.nombre = :nombre")})
public class Materias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMaterias", nullable = false)
    private Integer idMaterias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;
    @OneToMany(mappedBy = "idMateria")
    private List<Alumnosxmaterias> alumnosxmateriasList;
    @OneToMany(mappedBy = "idMateria")
    private List<Materiasxcarrera> materiasxcarreraList;
    @OneToMany(mappedBy = "idMaterias")
    private List<Materiasxdepartamento> materiasxdepartamentoList;
    @OneToMany(mappedBy = "idMaterias")
    private List<Gruposteoricosxmaterias> gruposteoricosxmateriasList;
    @OneToMany(mappedBy = "idMateria")
    private List<Calificacionesxmateria> calificacionesxmateriaList;
    @JoinColumn(name = "idCiclo", referencedColumnName = "idCiclo")
    @ManyToOne
    private Ciclo idCiclo;
    @OneToMany(mappedBy = "idMaterias")
    private List<Aulaxmaterias> aulaxmateriasList;
    @OneToMany(mappedBy = "idMaterias")
    private List<Docentesxmaterias> docentesxmateriasList;

    public Materias() {
    }

    public Materias(Integer idMaterias) {
        this.idMaterias = idMaterias;
    }

    public Materias(Integer idMaterias, String nombre) {
        this.idMaterias = idMaterias;
        this.nombre = nombre;
    }

    public Integer getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Integer idMaterias) {
        this.idMaterias = idMaterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Alumnosxmaterias> getAlumnosxmateriasList() {
        return alumnosxmateriasList;
    }

    public void setAlumnosxmateriasList(List<Alumnosxmaterias> alumnosxmateriasList) {
        this.alumnosxmateriasList = alumnosxmateriasList;
    }

    @XmlTransient
    public List<Materiasxcarrera> getMateriasxcarreraList() {
        return materiasxcarreraList;
    }

    public void setMateriasxcarreraList(List<Materiasxcarrera> materiasxcarreraList) {
        this.materiasxcarreraList = materiasxcarreraList;
    }

    @XmlTransient
    public List<Materiasxdepartamento> getMateriasxdepartamentoList() {
        return materiasxdepartamentoList;
    }

    public void setMateriasxdepartamentoList(List<Materiasxdepartamento> materiasxdepartamentoList) {
        this.materiasxdepartamentoList = materiasxdepartamentoList;
    }

    @XmlTransient
    public List<Gruposteoricosxmaterias> getGruposteoricosxmateriasList() {
        return gruposteoricosxmateriasList;
    }

    public void setGruposteoricosxmateriasList(List<Gruposteoricosxmaterias> gruposteoricosxmateriasList) {
        this.gruposteoricosxmateriasList = gruposteoricosxmateriasList;
    }

    @XmlTransient
    public List<Calificacionesxmateria> getCalificacionesxmateriaList() {
        return calificacionesxmateriaList;
    }

    public void setCalificacionesxmateriaList(List<Calificacionesxmateria> calificacionesxmateriaList) {
        this.calificacionesxmateriaList = calificacionesxmateriaList;
    }

    public Ciclo getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Ciclo idCiclo) {
        this.idCiclo = idCiclo;
    }

    @XmlTransient
    public List<Aulaxmaterias> getAulaxmateriasList() {
        return aulaxmateriasList;
    }

    public void setAulaxmateriasList(List<Aulaxmaterias> aulaxmateriasList) {
        this.aulaxmateriasList = aulaxmateriasList;
    }

    @XmlTransient
    public List<Docentesxmaterias> getDocentesxmateriasList() {
        return docentesxmateriasList;
    }

    public void setDocentesxmateriasList(List<Docentesxmaterias> docentesxmateriasList) {
        this.docentesxmateriasList = docentesxmateriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterias != null ? idMaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.idMaterias == null && other.idMaterias != null) || (this.idMaterias != null && !this.idMaterias.equals(other.idMaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Materias[ idMaterias=" + idMaterias + " ]";
    }
    
}
