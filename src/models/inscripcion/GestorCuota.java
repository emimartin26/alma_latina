/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.inscripcion;

import hibernate.GestorHibernate;
import java.sql.Date;
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

    public void setNumeroDeCouta(int num) {
        this.model.setNumeroDeCuota(num);
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

    public void generarCuotas(Calendar fechaInscripcion) {
        ArrayList<Calendar> listaFechas = new ArrayList<Calendar>();
        Set<Cuota> cuotas = new HashSet<Cuota>();
        Calendar now = Calendar.getInstance();
        //auxVar.set(Calendar.MONTH, 5);
        now.set(Calendar.DAY_OF_MONTH, 1);

        int flag = now.get(Calendar.MONTH); // MES ACTUAL

        System.out.println("MES ACTUAL: " + flag);
        Calendar aux;
        Cuota auxCuota;
        while (flag < 11) {//11 es diciembre va del 0 al 11
            aux = Calendar.getInstance();
            aux.set(Calendar.DAY_OF_MONTH, 1);
            aux.set(Calendar.MONTH, flag);
            listaFechas.add(aux);
            auxCuota = new Cuota();
            auxCuota.setFecha(aux.getTime());
           // aux.set(Calendar.DAY_OF_MONTH, );
           // auxCuota.setFechaVencimiento(aux);
            //cuotas.add(new Cuota().s)
            flag++;
        }

        Iterator<Calendar> it = listaFechas.iterator();
        Calendar fecha;
        int año;
        int mes;
        int dia;

       // System.out.println("Fecha Actual: " + + "/" + (mes) + "/" + año);
        while (it.hasNext()) {
            fecha = (Calendar) it.next();
            año = fecha.get(Calendar.YEAR);
            mes = fecha.get(Calendar.MONTH) + 1;
            dia = fecha.get(Calendar.DAY_OF_MONTH);

            System.out.println("Fecha Actual: " + dia + "/" + (mes) + "/" + año);
            //System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
            //System.out.println("-------------Fecha desglosada----------------");
        }
        //System.out.println("result: " + listaFechas.toString());

    }

}
