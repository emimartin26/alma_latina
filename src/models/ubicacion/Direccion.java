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
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;

    private int altura;
    private String calle;
    private int numDepto;
    private int piso;

    @OneToOne(targetEntity = Localidad.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Localidad localidad;

    public Direccion() {
        this.numDepto = 0;
        this.piso = 0;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumDepto() {
        return numDepto;
    }

    public void setNumDepto(int numDepto) {
        this.numDepto = numDepto;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String toString() {
        return this.localidad + " " + this.calle + this.altura + " " + " " + this.piso + " " + this.numDepto;
    }

}
