/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.atencionMedica;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "alergia")
public class Alergia{
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String descripcion;
    private String nombre;
      
    @OneToMany(targetEntity = Tratamiento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tratamiento> tratamientos;
    
    public Alergia() {
        this.tratamientos=new <Tratamiento> HashSet();
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
    
    
    
}
