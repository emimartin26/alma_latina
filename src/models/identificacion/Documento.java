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
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    @OneToOne(targetEntity = TipoDocumento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TipoDocumento tipo;
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return this.tipo.getNombre() + " :" + this.numero;
    }

}
