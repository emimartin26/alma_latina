/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;

import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "cuota")
public class Cuota {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = Estado.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estado estado;
    
    /*
        Fecha de la cuota
    */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    /*
        Fecha de vencimiento
    */ 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVencimiento;
    /*
        Fecha en que se pago
    */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPago;
        
    private int numeroDeCuota;  

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getNumeroDeCuota() {
        return numeroDeCuota;
    }

    public void setNumeroDeCuota(int numeroDeCuota) {
        this.numeroDeCuota = numeroDeCuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
}
