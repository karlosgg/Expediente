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
@Table(name = "horario", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario"),
    @NamedQuery(name = "Horario.findByNombre", query = "SELECT h FROM Horario h WHERE h.nombre = :nombre")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorario", nullable = false)
    private Integer idHorario;
    @Size(max = 5)
    @Column(name = "Nombre", length = 5)
    private String nombre;
    @OneToMany(mappedBy = "idHorario")
    private List<Horarioxgrupoteorico> horarioxgrupoteoricoList;
    @OneToMany(mappedBy = "idHorario")
    private List<Horarioxaula> horarioxaulaList;

    public Horario() {
    }

    public Horario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Horarioxgrupoteorico> getHorarioxgrupoteoricoList() {
        return horarioxgrupoteoricoList;
    }

    public void setHorarioxgrupoteoricoList(List<Horarioxgrupoteorico> horarioxgrupoteoricoList) {
        this.horarioxgrupoteoricoList = horarioxgrupoteoricoList;
    }

    @XmlTransient
    public List<Horarioxaula> getHorarioxaulaList() {
        return horarioxaulaList;
    }

    public void setHorarioxaulaList(List<Horarioxaula> horarioxaulaList) {
        this.horarioxaulaList = horarioxaulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Horario[ idHorario=" + idHorario + " ]";
    }
    
}
