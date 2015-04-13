/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.institucion;

import javax.persistence.*;
import models.ubicacion.Direccion;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "institucionEducativa")
public class InstitucionEducativa {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String nombre;
    @OneToOne(targetEntity = Direccion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Direccion direccion;       
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
     
    
    
    
    
}
