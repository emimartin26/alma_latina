/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pago;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import models.alumno.Alumno;
import models.inscripcion.Cuota;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = Descuento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Descuento descuento;
    

    
    @OneToMany(targetEntity = Cuota.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cuota> coutas;
    
    private Date fechaDePago;
    
    public Pago() {
        this.coutas=new <Cuota> HashSet();
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }


    public Set<Cuota> getCoutas() {
        return coutas;
    }

    public void setCoutas(Set<Cuota> coutas) {
        this.coutas = coutas;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    
    
    
}
