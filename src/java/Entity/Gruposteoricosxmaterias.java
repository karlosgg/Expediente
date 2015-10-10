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
@Table(name = "gruposteoricosxmaterias", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruposteoricosxmaterias.findAll", query = "SELECT g FROM Gruposteoricosxmaterias g"),
    @NamedQuery(name = "Gruposteoricosxmaterias.findByIdGruposteoricosXmaterias", query = "SELECT g FROM Gruposteoricosxmaterias g WHERE g.idGruposteoricosXmaterias = :idGruposteoricosXmaterias")})
public class Gruposteoricosxmaterias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGruposteoricosXmaterias", nullable = false)
    private Integer idGruposteoricosXmaterias;
    @JoinColumn(name = "idMaterias", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMaterias;
    @JoinColumn(name = "idGruposteoricos", referencedColumnName = "idGruposTeoricos")
    @ManyToOne
    private Gruposteoricos idGruposteoricos;

    public Gruposteoricosxmaterias() {
    }

    public Gruposteoricosxmaterias(Integer idGruposteoricosXmaterias) {
        this.idGruposteoricosXmaterias = idGruposteoricosXmaterias;
    }

    public Integer getIdGruposteoricosXmaterias() {
        return idGruposteoricosXmaterias;
    }

    public void setIdGruposteoricosXmaterias(Integer idGruposteoricosXmaterias) {
        this.idGruposteoricosXmaterias = idGruposteoricosXmaterias;
    }

    public Materias getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Materias idMaterias) {
        this.idMaterias = idMaterias;
    }

    public Gruposteoricos getIdGruposteoricos() {
        return idGruposteoricos;
    }

    public void setIdGruposteoricos(Gruposteoricos idGruposteoricos) {
        this.idGruposteoricos = idGruposteoricos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGruposteoricosXmaterias != null ? idGruposteoricosXmaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruposteoricosxmaterias)) {
            return false;
        }
        Gruposteoricosxmaterias other = (Gruposteoricosxmaterias) object;
        if ((this.idGruposteoricosXmaterias == null && other.idGruposteoricosXmaterias != null) || (this.idGruposteoricosXmaterias != null && !this.idGruposteoricosXmaterias.equals(other.idGruposteoricosXmaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Gruposteoricosxmaterias[ idGruposteoricosXmaterias=" + idGruposteoricosXmaterias + " ]";
    }
    
}
