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
@Table(name = "horarioxgrupoteorico", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarioxgrupoteorico.findAll", query = "SELECT h FROM Horarioxgrupoteorico h"),
    @NamedQuery(name = "Horarioxgrupoteorico.findByIdHorarioXhorario", query = "SELECT h FROM Horarioxgrupoteorico h WHERE h.idHorarioXhorario = :idHorarioXhorario")})
public class Horarioxgrupoteorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorarioXhorario", nullable = false)
    private Integer idHorarioXhorario;
    @JoinColumn(name = "IdHorario", referencedColumnName = "idHorario")
    @ManyToOne
    private Horario idHorario;
    @JoinColumn(name = "idGrupoteorico", referencedColumnName = "idGruposTeoricos")
    @ManyToOne
    private Gruposteoricos idGrupoteorico;

    public Horarioxgrupoteorico() {
    }

    public Horarioxgrupoteorico(Integer idHorarioXhorario) {
        this.idHorarioXhorario = idHorarioXhorario;
    }

    public Integer getIdHorarioXhorario() {
        return idHorarioXhorario;
    }

    public void setIdHorarioXhorario(Integer idHorarioXhorario) {
        this.idHorarioXhorario = idHorarioXhorario;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    public Gruposteoricos getIdGrupoteorico() {
        return idGrupoteorico;
    }

    public void setIdGrupoteorico(Gruposteoricos idGrupoteorico) {
        this.idGrupoteorico = idGrupoteorico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioXhorario != null ? idHorarioXhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarioxgrupoteorico)) {
            return false;
        }
        Horarioxgrupoteorico other = (Horarioxgrupoteorico) object;
        if ((this.idHorarioXhorario == null && other.idHorarioXhorario != null) || (this.idHorarioXhorario != null && !this.idHorarioXhorario.equals(other.idHorarioXhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Horarioxgrupoteorico[ idHorarioXhorario=" + idHorarioXhorario + " ]";
    }
    
}
