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
@Table(name = "anoacademico", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anoacademico.findAll", query = "SELECT a FROM Anoacademico a"),
    @NamedQuery(name = "Anoacademico.findByIdAnoacademico", query = "SELECT a FROM Anoacademico a WHERE a.idAnoacademico = :idAnoacademico"),
    @NamedQuery(name = "Anoacademico.findByNombre", query = "SELECT a FROM Anoacademico a WHERE a.nombre = :nombre")})
public class Anoacademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAnoacademico", nullable = false)
    private Integer idAnoacademico;
    @Size(max = 45)
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @OneToMany(mappedBy = "idano")
    private List<Calificacionesxano> calificacionesxanoList;
    @OneToMany(mappedBy = "idAnoacademico")
    private List<Anodepago> anodepagoList;

    public Anoacademico() {
    }

    public Anoacademico(Integer idAnoacademico) {
        this.idAnoacademico = idAnoacademico;
    }

    public Integer getIdAnoacademico() {
        return idAnoacademico;
    }

    public void setIdAnoacademico(Integer idAnoacademico) {
        this.idAnoacademico = idAnoacademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Calificacionesxano> getCalificacionesxanoList() {
        return calificacionesxanoList;
    }

    public void setCalificacionesxanoList(List<Calificacionesxano> calificacionesxanoList) {
        this.calificacionesxanoList = calificacionesxanoList;
    }

    @XmlTransient
    public List<Anodepago> getAnodepagoList() {
        return anodepagoList;
    }

    public void setAnodepagoList(List<Anodepago> anodepagoList) {
        this.anodepagoList = anodepagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnoacademico != null ? idAnoacademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anoacademico)) {
            return false;
        }
        Anoacademico other = (Anoacademico) object;
        if ((this.idAnoacademico == null && other.idAnoacademico != null) || (this.idAnoacademico != null && !this.idAnoacademico.equals(other.idAnoacademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Anoacademico[ idAnoacademico=" + idAnoacademico + " ]";
    }
    
}
