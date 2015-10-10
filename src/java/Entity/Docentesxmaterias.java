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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "docentesxmaterias", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentesxmaterias.findAll", query = "SELECT d FROM Docentesxmaterias d"),
    @NamedQuery(name = "Docentesxmaterias.findByIdDocentesXmaterias", query = "SELECT d FROM Docentesxmaterias d WHERE d.idDocentesXmaterias = :idDocentesXmaterias"),
    @NamedQuery(name = "Docentesxmaterias.findByDocentesXmateriascol", query = "SELECT d FROM Docentesxmaterias d WHERE d.docentesXmateriascol = :docentesXmateriascol"),
    @NamedQuery(name = "Docentesxmaterias.findByHora", query = "SELECT d FROM Docentesxmaterias d WHERE d.hora = :hora"),
    @NamedQuery(name = "Docentesxmaterias.findByDia", query = "SELECT d FROM Docentesxmaterias d WHERE d.dia = :dia")})
public class Docentesxmaterias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocentesXmaterias", nullable = false)
    private Integer idDocentesXmaterias;
    @Size(max = 45)
    @Column(name = "DocentesXmateriascol", length = 45)
    private String docentesXmateriascol;
    @Size(max = 45)
    @Column(name = "Hora", length = 45)
    private String hora;
    @Size(max = 45)
    @Column(name = "Dia", length = 45)
    private String dia;
    @JoinColumn(name = "idMaterias", referencedColumnName = "idMaterias")
    @ManyToOne
    private Materias idMaterias;
    @JoinColumn(name = "idDocentes", referencedColumnName = "idDocentes")
    @ManyToOne
    private Docentes idDocentes;

    public Docentesxmaterias() {
    }

    public Docentesxmaterias(Integer idDocentesXmaterias) {
        this.idDocentesXmaterias = idDocentesXmaterias;
    }

    public Integer getIdDocentesXmaterias() {
        return idDocentesXmaterias;
    }

    public void setIdDocentesXmaterias(Integer idDocentesXmaterias) {
        this.idDocentesXmaterias = idDocentesXmaterias;
    }

    public String getDocentesXmateriascol() {
        return docentesXmateriascol;
    }

    public void setDocentesXmateriascol(String docentesXmateriascol) {
        this.docentesXmateriascol = docentesXmateriascol;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Materias getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Materias idMaterias) {
        this.idMaterias = idMaterias;
    }

    public Docentes getIdDocentes() {
        return idDocentes;
    }

    public void setIdDocentes(Docentes idDocentes) {
        this.idDocentes = idDocentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocentesXmaterias != null ? idDocentesXmaterias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentesxmaterias)) {
            return false;
        }
        Docentesxmaterias other = (Docentesxmaterias) object;
        if ((this.idDocentesXmaterias == null && other.idDocentesXmaterias != null) || (this.idDocentesXmaterias != null && !this.idDocentesXmaterias.equals(other.idDocentesXmaterias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Docentesxmaterias[ idDocentesXmaterias=" + idDocentesXmaterias + " ]";
    }
    
}
