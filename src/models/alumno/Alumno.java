/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.alumno;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import models.atencionMedica.Alergia;
import models.atencionMedica.Tratamiento;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.institucion.InstitucionPorAlumno;
import models.mutual.Mutual;
import models.telefono.Telefono;
import models.tutor.Tutor;
import models.ubicacion.Direccion;

/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private String email;
    private String observaciones;
    private int estado;
    public final static int NORMAL = 0;
    public final static int ELIMINADO = 1;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    @OneToOne(targetEntity = Documento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Documento documento;

    @OneToOne(targetEntity = Direccion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Direccion direccion;
    @OneToOne(targetEntity = GrupoSanguineo.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GrupoSanguineo GrupoSanguineo;
    @OneToOne(targetEntity = Tutor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Tutor tutor;
    @OneToOne(targetEntity = InstitucionPorAlumno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InstitucionPorAlumno InstitucionPorAlumno;
    @OneToOne(targetEntity = Mutual.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mutual mutual;

    @OneToMany(targetEntity = Telefono.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Telefono> telefonos;
    @OneToMany(targetEntity = Alergia.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Alergia> alergias;

    @OneToMany(targetEntity = Tratamiento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tratamiento> tratamientos;

    public Alumno() {
        this.telefonos = new <Telefono> HashSet();
        this.alergias = new <Alergia> HashSet();
        this.tratamientos = new <Tratamiento> HashSet();
        this.estado = NORMAL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public GrupoSanguineo getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public InstitucionPorAlumno getInstitucionPorAlumno() {
        return InstitucionPorAlumno;
    }

    public void setInstitucionPorAlumno(InstitucionPorAlumno InstitucionPorAlumno) {
        this.InstitucionPorAlumno = InstitucionPorAlumno;
    }

    public Set<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(Set<Alergia> alergias) {
        this.alergias = alergias;
    }

    public Mutual getMutual() {
        return mutual;
    }

    public void setMutual(Mutual mutual) {
        this.mutual = mutual;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String toString() {
        return this.nombre + " - " + this.apellido + " - " + this.email + " - " + this.InstitucionPorAlumno + " - " + this.GrupoSanguineo + " - " + this.alergias + " - " + this.direccion + " - " + this.documento + " - " + this.fechaNacimiento + " - " + this.mutual + " - " + this.telefonos + " - " + this.tratamientos + " - " + this.tutor + " - " + this.observaciones;
    }

}
