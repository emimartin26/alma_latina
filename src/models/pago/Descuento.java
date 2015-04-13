/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pago;


import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "descuento")
public class Descuento {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private int tasaDeInteres;
    private String descripcion;

    public int getTasaDeInteres() {
        return tasaDeInteres;
    }

    public void setTasaDeInteres(int tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
