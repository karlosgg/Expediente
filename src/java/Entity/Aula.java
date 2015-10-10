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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "aula", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByIdAula", query = "SELECT a FROM Aula a WHERE a.idAula = :idAula"),
    @NamedQuery(name = "Aula.findByNombre", query = "SELECT a FROM Aula a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aula.findByCapacidad", query = "SELECT a FROM Aula a WHERE a.capacidad = :capacidad")})
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAula", nullable = false)
    private Integer idAula;
    @Size(max = 45)
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Capacidad")
    private Long capacidad;
    @OneToMany(mappedBy = "idAula")
    private List<Aulaxalumno> aulaxalumnoList;
    @OneToMany(mappedBy = "idAula")
    private List<Horarioxaula> horarioxaulaList;
    @OneToMany(mappedBy = "idAula")
    private List<Aulaxmaterias> aulaxmateriasList;

    public Aula() {
    }

    public Aula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public List<Aulaxalumno> getAulaxalumnoList() {
        return aulaxalumnoList;
    }

    public void setAulaxalumnoList(List<Aulaxalumno> aulaxalumnoList) {
        this.aulaxalumnoList = aulaxalumnoList;
    }

    @XmlTransient
    public List<Horarioxaula> getHorarioxaulaList() {
        return horarioxaulaList;
    }

    public void setHorarioxaulaList(List<Horarioxaula> horarioxaulaList) {
        this.horarioxaulaList = horarioxaulaList;
    }

    @XmlTransient
    public List<Aulaxmaterias> getAulaxmateriasList() {
        return aulaxmateriasList;
    }

    public void setAulaxmateriasList(List<Aulaxmaterias> aulaxmateriasList) {
        this.aulaxmateriasList = aulaxmateriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Aula[ idAula=" + idAula + " ]";
    }
    
}
