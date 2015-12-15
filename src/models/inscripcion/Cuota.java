/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.inscripcion;

import Main.Config;
import Utilidades.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    private long precio;

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

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
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

    @Override
    public String toString() {
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = Util.DateToCalendar(fechaVencimiento);
        long diff = fecha2.getTimeInMillis() - fecha1.getTimeInMillis();
        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String output = "Cuota: " + DATE_FORMAT.format(this.fecha) + " - " + "Vence: " + DATE_FORMAT.format(this.fechaVencimiento) + " Dif: " + diffDays;
        return output;
    }


}
