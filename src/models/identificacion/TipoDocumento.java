/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.identificacion;

import javax.persistence.*;

/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "tipoDocumento")
public class TipoDocumento{
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String  detalle;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
