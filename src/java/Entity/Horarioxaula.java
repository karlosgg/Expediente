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
@Table(name = "horarioxaula", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarioxaula.findAll", query = "SELECT h FROM Horarioxaula h"),
    @NamedQuery(name = "Horarioxaula.findByIdHorarioXaula", query = "SELECT h FROM Horarioxaula h WHERE h.idHorarioXaula = :idHorarioXaula")})
public class Horarioxaula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorarioXaula", nullable = false)
    private Integer idHorarioXaula;
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
    @ManyToOne
    private Horario idHorario;
    @JoinColumn(name = "idAula", referencedColumnName = "idAula")
    @ManyToOne
    private Aula idAula;

    public Horarioxaula() {
    }

    public Horarioxaula(Integer idHorarioXaula) {
        this.idHorarioXaula = idHorarioXaula;
    }

    public Integer getIdHorarioXaula() {
        return idHorarioXaula;
    }

    public void setIdHorarioXaula(Integer idHorarioXaula) {
        this.idHorarioXaula = idHorarioXaula;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioXaula != null ? idHorarioXaula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarioxaula)) {
            return false;
        }
        Horarioxaula other = (Horarioxaula) object;
        if ((this.idHorarioXaula == null && other.idHorarioXaula != null) || (this.idHorarioXaula != null && !this.idHorarioXaula.equals(other.idHorarioXaula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Horarioxaula[ idHorarioXaula=" + idHorarioXaula + " ]";
    }
    
}
