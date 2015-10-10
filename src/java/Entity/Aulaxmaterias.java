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
@Table(name = "aulaxmaterias", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulaxmaterias.findAll", query = "SELECT a FROM Aulaxmaterias a"),
    @NamedQuery(name = "Aulaxmaterias.findByIdAulaXmaterias", query = "SELECT a FROM Aulaxmaterias a WHERE a.idAulaXmaterias = :idAulaXmaterias")})
public class Aulaxmaterias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAulaXmaterias", nullable = false)
    private Integer idAulaXmaterias;
    @JoinColumn(name = "idMaterias", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMaterias;
    @JoinColumn(name = "idAula", referencedColumnName = "idAula")
    @ManyToOne
    private Aula idAula;

    public Aulaxmaterias() {
    }

    public Aulaxmaterias(Integer idAulaXmaterias) {
        this.idAulaXmaterias = idAulaXmaterias;
    }

    public Integer getIdAulaXmaterias() {
        return idAulaXmaterias;
    }

    public void setIdAulaXmaterias(Integer idAulaXmaterias) {
        this.idAulaXmaterias = idAulaXmaterias;
    }

    public Materias getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Materias idMaterias) {
        this.idMaterias = idMaterias;
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
        hash += (idAulaXmaterias != null ? idAulaXmaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulaxmaterias)) {
            return false;
        }
        Aulaxmaterias other = (Aulaxmaterias) object;
        if ((this.idAulaXmaterias == null && other.idAulaXmaterias != null) || (this.idAulaXmaterias != null && !this.idAulaXmaterias.equals(other.idAulaXmaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Aulaxmaterias[ idAulaXmaterias=" + idAulaXmaterias + " ]";
    }
    
}
