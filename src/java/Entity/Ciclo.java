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
@Table(name = "ciclo", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclo.findAll", query = "SELECT c FROM Ciclo c"),
    @NamedQuery(name = "Ciclo.findByIdCiclo", query = "SELECT c FROM Ciclo c WHERE c.idCiclo = :idCiclo"),
    @NamedQuery(name = "Ciclo.findByNombre", query = "SELECT c FROM Ciclo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ciclo.findByIdAnoacademico", query = "SELECT c FROM Ciclo c WHERE c.idAnoacademico = :idAnoacademico")})
public class Ciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCiclo", nullable = false)
    private Integer idCiclo;
    @Size(max = 45)
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "idAnoacademico")
    private Integer idAnoacademico;
    @OneToMany(mappedBy = "idCiclo")
    private List<Materias> materiasList;

    public Ciclo() {
    }

    public Ciclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdAnoacademico() {
        return idAnoacademico;
    }

    public void setIdAnoacademico(Integer idAnoacademico) {
        this.idAnoacademico = idAnoacademico;
    }

    @XmlTransient
    public List<Materias> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materias> materiasList) {
        this.materiasList = materiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ciclo[ idCiclo=" + idCiclo + " ]";
    }
    
}
