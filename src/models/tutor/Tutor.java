/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tutor;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import models.telefono.Telefono;
import models.ubicacion.Direccion;

/**
 *
 * @author emiliano
 */
@Entity
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String apellido;

    @OneToOne(targetEntity = Direccion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Direccion direccion;
    @OneToMany(targetEntity = Telefono.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Telefono> telefonos;
    
    public Tutor() {
        this.telefonos=new <Telefono> HashSet();
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    
    
}
