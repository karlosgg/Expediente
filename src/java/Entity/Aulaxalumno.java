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
@Table(name = "aulaxalumno", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulaxalumno.findAll", query = "SELECT a FROM Aulaxalumno a"),
    @NamedQuery(name = "Aulaxalumno.findByIdAulaXalumno", query = "SELECT a FROM Aulaxalumno a WHERE a.idAulaXalumno = :idAulaXalumno")})
public class Aulaxalumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAulaXalumno", nullable = false)
    private Integer idAulaXalumno;
    @JoinColumn(name = "idAula", referencedColumnName = "idAula")
    @ManyToOne
    private Aula idAula;
    @JoinColumn(name = "idAlumno", referencedColumnName = "Carnet")
    @ManyToOne
    private Alumnos idAlumno;

    public Aulaxalumno() {
    }

    public Aulaxalumno(Integer idAulaXalumno) {
        this.idAulaXalumno = idAulaXalumno;
    }

    public Integer getIdAulaXalumno() {
        return idAulaXalumno;
    }

    public void setIdAulaXalumno(Integer idAulaXalumno) {
        this.idAulaXalumno = idAulaXalumno;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
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
        hash += (idAulaXalumno != null ? idAulaXalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulaxalumno)) {
            return false;
        }
        Aulaxalumno other = (Aulaxalumno) object;
        if ((this.idAulaXalumno == null && other.idAulaXalumno != null) || (this.idAulaXalumno != null && !this.idAulaXalumno.equals(other.idAulaXalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Aulaxalumno[ idAulaXalumno=" + idAulaXalumno + " ]";
    }
    
}
