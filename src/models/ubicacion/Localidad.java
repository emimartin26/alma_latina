/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.ubicacion;

import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "localidad")

public class Localidad {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    private String descripcion;
    @OneToOne(targetEntity = Provincia.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Provincia provincia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    
}
