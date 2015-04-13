/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

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
    
    private String referenciarAlumno;
    
    @OneToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Categoria categoria;
    
    @OneToOne(targetEntity = Estado.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estado estado;
    
        @OneToMany(targetEntity = Cuota.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cuota> coutas;
    
    private Date fecha;
    
    
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
    
    
}
