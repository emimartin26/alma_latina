/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import models.alumno.Alumno;

/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "inscripcion")
public class Inscripcion{
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = Alumno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Alumno alumno;
    
    @OneToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Categoria categoria;
    
    @OneToOne(targetEntity = Estado.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estado estado;
    
    @OneToMany(targetEntity = Cuota.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cuota> coutas;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    private int year;
    
    public Inscripcion() {
        this.coutas=new <Cuota> HashSet();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Set<Cuota> getCoutas() {
        return coutas;
    }

    public void setCoutas(Set<Cuota> coutas) {
        this.coutas = coutas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    @Override
    public String toString(){
        return this.categoria.getNombre() + " - " + this.getYear() + " - " + this.estado.getNombre();
    }
    
}
