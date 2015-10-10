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
@Table(name = "alumnos", catalog = "expediente_ues", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByCarnet", query = "SELECT a FROM Alumnos a WHERE a.carnet = :carnet"),
    @NamedQuery(name = "Alumnos.findByNombres", query = "SELECT a FROM Alumnos a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Alumnos.findByApellidos", query = "SELECT a FROM Alumnos a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Alumnos.findByEmail", query = "SELECT a FROM Alumnos a WHERE a.email = :email"),
    @NamedQuery(name = "Alumnos.findByDireccion", query = "SELECT a FROM Alumnos a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Alumnos.findByCelular", query = "SELECT a FROM Alumnos a WHERE a.celular = :celular"),
    @NamedQuery(name = "Alumnos.findByTitulo", query = "SELECT a FROM Alumnos a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Alumnos.findByEncargado", query = "SELECT a FROM Alumnos a WHERE a.encargado = :encargado")})
public class Alumnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Carnet", nullable = false)
    private Integer carnet;
    @Size(max = 100)
    @Column(name = "Nombres", length = 100)
    private String nombres;
    @Size(max = 100)
    @Column(name = "Apellidos", length = 100)
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
    @Size(max = 100)
    @Column(name = "Encargado", length = 100)
    private String encargado;
    @OneToMany(mappedBy = "idAlumno")
    private List<Alumnosxmaterias> alumnosxmateriasList;
    @OneToMany(mappedBy = "idAlumno")
    private List<Aulaxalumno> aulaxalumnoList;
    @OneToMany(mappedBy = "idAlumno")
    private List<Alumnosxdocentes> alumnosxdocentesList;
    @OneToMany(mappedBy = "idAlumno")
    private List<Calificacionesxalumno> calificacionesxalumnoList;

    public Alumnos() {
    }

    public Alumnos(Integer carnet) {
        this.carnet = carnet;
    }

    public Integer getCarnet() {
        return carnet;
    }

    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
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

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @XmlTransient
    public List<Alumnosxmaterias> getAlumnosxmateriasList() {
        return alumnosxmateriasList;
    }

    public void setAlumnosxmateriasList(List<Alumnosxmaterias> alumnosxmateriasList) {
        this.alumnosxmateriasList = alumnosxmateriasList;
    }

    @XmlTransient
    public List<Aulaxalumno> getAulaxalumnoList() {
        return aulaxalumnoList;
    }

    public void setAulaxalumnoList(List<Aulaxalumno> aulaxalumnoList) {
        this.aulaxalumnoList = aulaxalumnoList;
    }

    @XmlTransient
    public List<Alumnosxdocentes> getAlumnosxdocentesList() {
        return alumnosxdocentesList;
    }

    public void setAlumnosxdocentesList(List<Alumnosxdocentes> alumnosxdocentesList) {
        this.alumnosxdocentesList = alumnosxdocentesList;
    }

    @XmlTransient
    public List<Calificacionesxalumno> getCalificacionesxalumnoList() {
        return calificacionesxalumnoList;
    }

    public void setCalificacionesxalumnoList(List<Calificacionesxalumno> calificacionesxalumnoList) {
        this.calificacionesxalumnoList = calificacionesxalumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnet != null ? carnet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.carnet == null && other.carnet != null) || (this.carnet != null && !this.carnet.equals(other.carnet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Alumnos[ carnet=" + carnet + " ]";
    }
    
}
