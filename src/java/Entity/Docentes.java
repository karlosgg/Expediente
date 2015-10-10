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
@Table(name = "docentes", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByIdDocentes", query = "SELECT d FROM Docentes d WHERE d.idDocentes = :idDocentes"),
    @NamedQuery(name = "Docentes.findByNombres", query = "SELECT d FROM Docentes d WHERE d.nombres = :nombres"),
    @NamedQuery(name = "Docentes.findByApellidos", query = "SELECT d FROM Docentes d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Docentes.findByEmail", query = "SELECT d FROM Docentes d WHERE d.email = :email"),
    @NamedQuery(name = "Docentes.findByDireccion", query = "SELECT d FROM Docentes d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Docentes.findByTelefono", query = "SELECT d FROM Docentes d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Docentes.findByCelular", query = "SELECT d FROM Docentes d WHERE d.celular = :celular"),
    @NamedQuery(name = "Docentes.findByTitulo", query = "SELECT d FROM Docentes d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "Docentes.findByDatos", query = "SELECT d FROM Docentes d WHERE d.datos = :datos")})
public class Docentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocentes", nullable = false)
    private Integer idDocentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombres", nullable = false, length = 45)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellidos", nullable = false, length = 45)
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email", length = 100)
    private String email;
    @Size(max = 200)
    @Column(name = "Direccion", length = 200)
    private String direccion;
    @Size(max = 11)
    @Column(name = "Telefono", length = 11)
    private String telefono;
    @Size(max = 11)
    @Column(name = "Celular", length = 11)
    private String celular;
    @Size(max = 100)
    @Column(name = "Titulo", length = 100)
    private String titulo;
    @Size(max = 500)
    @Column(name = "Datos", length = 500)
    private String datos;
    @OneToMany(mappedBy = "idDocente")
    private List<Alumnosxdocentes> alumnosxdocentesList;
    @OneToMany(mappedBy = "idDocentes")
    private List<Docentesxmaterias> docentesxmateriasList;

    public Docentes() {
    }

    public Docentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public Docentes(Integer idDocentes, String nombres, String apellidos) {
        this.idDocentes = idDocentes;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdDocentes() {
        return idDocentes;
    }

    public void setIdDocentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @XmlTransient
    public List<Alumnosxdocentes> getAlumnosxdocentesList() {
        return alumnosxdocentesList;
    }

    public void setAlumnosxdocentesList(List<Alumnosxdocentes> alumnosxdocentesList) {
        this.alumnosxdocentesList = alumnosxdocentesList;
    }

    @XmlTransient
    public List<Docentesxmaterias> getDocentesxmateriasList() {
        return docentesxmateriasList;
    }

    public void setDocentesxmateriasList(List<Docentesxmaterias> docentesxmateriasList) {
        this.docentesxmateriasList = docentesxmateriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocentes != null ? idDocentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.idDocentes == null && other.idDocentes != null) || (this.idDocentes != null && !this.idDocentes.equals(other.idDocentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Docentes[ idDocentes=" + idDocentes + " ]";
    }
    
}
