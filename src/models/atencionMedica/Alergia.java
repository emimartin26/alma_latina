/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.atencionMedica;

import java.util.Set;

/**
 *
 * @author emiliano
 */
public class Alergia {
    
    private String descripcion;
    private String nombre;
    private Set<Tratamiento> tratamientos;

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
