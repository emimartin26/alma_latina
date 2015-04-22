/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.telefono;

import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "telefono")
public class Telefono {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String numero;
    private String caracteristica;
    
    @OneToOne(targetEntity = TipoTelefono.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TipoTelefono tipo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public TipoTelefono getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefono tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return this.caracteristica + " - " +this.numero;
    }
    
    
    
}
