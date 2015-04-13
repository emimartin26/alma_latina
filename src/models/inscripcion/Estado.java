/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;

import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String ambito;
    private String descripcion;

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
