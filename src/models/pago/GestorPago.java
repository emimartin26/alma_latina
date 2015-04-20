/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.pago;
import hibernate.GestorHibernate;
import java.sql.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
import models.inscripcion.Cuota;

/**
 *
 * @author EMILIANO
 */
public class GestorPago extends GestorHibernate implements InterfaceAbm {
    private Pago model;

    public GestorPago(Pago model) {
        this.model = model;
    }

    public Pago getModel() {
        return model;
    }

    public void setModel(Pago model) {
        this.model = model;
    }
    
    public void setDescuento(Descuento descuento) {
        this.model.setDescuento(descuento);
    }
    public void setCuota(Set<Cuota> cuotas){
        this.model.setCoutas(cuotas);
    }
    public void setFecha(Date fecha){
        this.model.setFechaDePago(fecha);
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
    
}
