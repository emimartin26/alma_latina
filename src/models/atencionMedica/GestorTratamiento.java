/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.atencionMedica;

import javax.swing.JOptionPane;
import hibernate.GestorHibernate;
import models.InterfaceAbm;

/**
 *
 * @author EMILIANO
 */
public class GestorTratamiento extends GestorHibernate implements InterfaceAbm {

    private Tratamiento model;

    public GestorTratamiento() {
        this.model = new Tratamiento();
    }

    public void crearTratamiento() {
        this.model = new Tratamiento();
    }

    public Tratamiento getModel() {
        return model;
    }

    public void setModel(Tratamiento model) {
        this.model = model;
    }

    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }

    public void setDetalle(String detalle) {
        this.model.setNombre(detalle);
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
