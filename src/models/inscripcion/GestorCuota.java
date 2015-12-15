/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.inscripcion;

import Main.Config;
import Utilidades.Util;
import hibernate.GestorHibernate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import models.InterfaceAbm;

/**
 *
 * @author EMILIANO
 */
public class GestorCuota extends GestorHibernate implements InterfaceAbm {

    private Cuota model;

    public GestorCuota() {
        this.model = new Cuota();
    }

    public Cuota getModel() {
        return model;
    }

    public void setModel(Cuota model) {
        this.model = model;
    }

    public void setEstado(Estado estado) {
        this.model.setEstado(estado);
    }

    public void setFecha(Date fecha) {
        this.model.setFechaVencimiento(fecha);
    }

    public Date getFechaVencimiento() {
        return this.model.getFechaVencimiento();
    }

    @Override
    public void guardar() {
        try {
            this.guardarObjeto(this.model);
            System.out.println(this.model + " - Guardado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar objeto: " + e);
        }
    }

    @Override
    public void actuailizar() {
        try {
            this.actualizarObjeto(this.model);
            System.out.println(this.model + " - Actualizado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar objeto: " + e);
        }
    }

    @Override
    public void eliminar() {
        try {
            this.eliminarObjeto(this.model);
            System.out.println(this.model + " - Eliminado con exito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar objeto: " + e);
        }
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     Si flagNow = true, se generan fechas a partir de hoy.
     Si flagNow = false, se generan fechas a partir de la fecha auxCalendar
     */
    public ArrayList<Calendar> generarFechasCuotas(boolean flagNow, Calendar auxCalendar) {
        ArrayList<Calendar> listaFechas = new ArrayList<Calendar>();
        //Seteo en este momento como fecha inicial
        Calendar now;
        if (flagNow) {
            now = Calendar.getInstance();
        } else {
            now = auxCalendar;
        }

        //now.set(Calendar.MONTH, 5);
        now.set(Calendar.DAY_OF_MONTH, 1);
        //lo guarado en la lista de fechas
        listaFechas.add(now);

        int flag = now.get(Calendar.MONTH); // MES ACTUAL

        Calendar aux;
        while (flag < 11) {//11 es diciembre va del 0 al 11
            aux = Calendar.getInstance();
            aux.set(Calendar.YEAR, now.get(Calendar.YEAR));

            aux.set(Calendar.DAY_OF_MONTH, 1);
            aux.set(Calendar.MONTH, flag + 1);
            listaFechas.add(aux);
            flag++;
        }

        return listaFechas;
    }

    public Set<Cuota> generarCuotas(boolean flagNow, Calendar auxCalendar) {
        Set<Cuota> cuotas = new HashSet<Cuota>();
        Iterator<Calendar> it = this.generarFechasCuotas(flagNow,auxCalendar).iterator();
        Calendar fecha;

        Cuota auxCuota;
        while (it.hasNext()) {
            fecha = (Calendar) it.next();
            auxCuota = new Cuota();
            auxCuota.setFecha(fecha.getTime());
            fecha.set(Calendar.DAY_OF_MONTH, (int) Config.FECHAVENCIMIENTOCUOTA);
            auxCuota.setFechaVencimiento(fecha.getTime());
            auxCuota.setEstado(new GestorEstado().getEstado("cuota", "Pendiente"));
            auxCuota.setPrecio(Config.PRECIOCUOTA);
            cuotas.add(auxCuota);
        }

        return cuotas;
    }
    
    public boolean estaVencida() {
        Calendar fecha1 = Calendar.getInstance();
        Calendar fecha2 = Util.DateToCalendar(this.getFechaVencimiento());
        long diff = fecha2.getTimeInMillis() - fecha1.getTimeInMillis();
        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if (diffDays < 0) {// Si me devuelve negativo es porque esta vencida
            return true;
        }
        return false;
    }

}
