/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.institucion;
import hibernate.GestorHibernate;
import javax.swing.JOptionPane;
import models.InterfaceAbm;

/**
 *
 * @author EMILIANO
 */
public class GestorTurno extends GestorHibernate implements InterfaceAbm {
    private Turno model;

    public GestorTurno(Turno model) {
        this.model = model;
    }

    public Turno getModel() {
        return model;
    }

    public void setModel(Turno model) {
        this.model = model;
    }

    public void setNombre(String nombre){
        this.model.setNombre(nombre);
    }
    public void setDescripcion(String descripcion){
        this.model.setDescripcion(descripcion);
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
