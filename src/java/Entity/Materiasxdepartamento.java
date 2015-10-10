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
@Table(name = "materiasxdepartamento", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiasxdepartamento.findAll", query = "SELECT m FROM Materiasxdepartamento m"),
    @NamedQuery(name = "Materiasxdepartamento.findByIdMateriasXdepartamento", query = "SELECT m FROM Materiasxdepartamento m WHERE m.idMateriasXdepartamento = :idMateriasXdepartamento")})
public class Materiasxdepartamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMateriasXdepartamento", nullable = false)
    private Integer idMateriasXdepartamento;
    @JoinColumn(name = "idMaterias", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMaterias;
    @JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
    @ManyToOne
    private Departamento idDepartamento;

    public Materiasxdepartamento() {
    }

    public Materiasxdepartamento(Integer idMateriasXdepartamento) {
        this.idMateriasXdepartamento = idMateriasXdepartamento;
    }

    public Integer getIdMateriasXdepartamento() {
        return idMateriasXdepartamento;
    }

    public void setIdMateriasXdepartamento(Integer idMateriasXdepartamento) {
        this.idMateriasXdepartamento = idMateriasXdepartamento;
    }

    public Materias getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Materias idMaterias) {
        this.idMaterias = idMaterias;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMateriasXdepartamento != null ? idMateriasXdepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiasxdepartamento)) {
            return false;
        }
        Materiasxdepartamento other = (Materiasxdepartamento) object;
        if ((this.idMateriasXdepartamento == null && other.idMateriasXdepartamento != null) || (this.idMateriasXdepartamento != null && !this.idMateriasXdepartamento.equals(other.idMateriasXdepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Materiasxdepartamento[ idMateriasXdepartamento=" + idMateriasXdepartamento + " ]";
    }
    
}
