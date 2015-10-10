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
@Table(name = "gruposteoricos", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruposteoricos.findAll", query = "SELECT g FROM Gruposteoricos g"),
    @NamedQuery(name = "Gruposteoricos.findByIdGruposTeoricos", query = "SELECT g FROM Gruposteoricos g WHERE g.idGruposTeoricos = :idGruposTeoricos"),
    @NamedQuery(name = "Gruposteoricos.findByNombre", query = "SELECT g FROM Gruposteoricos g WHERE g.nombre = :nombre")})
public class Gruposteoricos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGruposTeoricos", nullable = false)
    private Integer idGruposTeoricos;
    @Size(max = 45)
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @OneToMany(mappedBy = "idGruposteoricos")
    private List<Gruposteoricosxmaterias> gruposteoricosxmateriasList;
    @OneToMany(mappedBy = "idGrupoteorico")
    private List<Horarioxgrupoteorico> horarioxgrupoteoricoList;

    public Gruposteoricos() {
    }

    public Gruposteoricos(Integer idGruposTeoricos) {
        this.idGruposTeoricos = idGruposTeoricos;
    }

    public Integer getIdGruposTeoricos() {
        return idGruposTeoricos;
    }

    public void setIdGruposTeoricos(Integer idGruposTeoricos) {
        this.idGruposTeoricos = idGruposTeoricos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Gruposteoricosxmaterias> getGruposteoricosxmateriasList() {
        return gruposteoricosxmateriasList;
    }

    public void setGruposteoricosxmateriasList(List<Gruposteoricosxmaterias> gruposteoricosxmateriasList) {
        this.gruposteoricosxmateriasList = gruposteoricosxmateriasList;
    }

    @XmlTransient
    public List<Horarioxgrupoteorico> getHorarioxgrupoteoricoList() {
        return horarioxgrupoteoricoList;
    }

    public void setHorarioxgrupoteoricoList(List<Horarioxgrupoteorico> horarioxgrupoteoricoList) {
        this.horarioxgrupoteoricoList = horarioxgrupoteoricoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGruposTeoricos != null ? idGruposTeoricos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruposteoricos)) {
            return false;
        }
        Gruposteoricos other = (Gruposteoricos) object;
        if ((this.idGruposTeoricos == null && other.idGruposTeoricos != null) || (this.idGruposTeoricos != null && !this.idGruposTeoricos.equals(other.idGruposTeoricos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Gruposteoricos[ idGruposTeoricos=" + idGruposTeoricos + " ]";
    }
    
}
