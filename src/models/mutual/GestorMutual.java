/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.mutual;

import Utilidades.Util;
import hibernate.GestorHibernate;
import javax.swing.JOptionPane;
import models.InterfaceAbm;

/**
 *
 * @author EMILIANO
 */
public class GestorMutual extends GestorHibernate implements InterfaceAbm {

    private Mutual model;

    public GestorMutual() {
        this.model = new Mutual();
    }

    public Mutual getModel() {
        return model;
    }

    public void setModel(Mutual model) {
        this.model = model;
    }

    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }

    public void setDescripcion(String descriocion) {
        this.model.setDescripcion(descriocion);
    }

    @Override
    public void guardar() {
        try {
         this.guardarObjeto(this.model);
            System.out.println(this.model + " - Guardado con exito");
            new Util().getMensajeInformation("Obra social Guardada con éxito");
        } catch (Exception e) {
            new Util().getMensajeError("Comunicarse con el administrador de sistemas");
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
