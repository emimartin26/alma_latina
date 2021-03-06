/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.tutor;

import hibernate.GestorHibernate;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
import models.ubicacion.Direccion;

/**
 *
 * @author EMILIANO
 */
public class GestorTutor  extends GestorHibernate implements InterfaceAbm {
    private Tutor model;

    public GestorTutor() {
        this.model = new Tutor();
    }

    
    public Tutor getModel() {
        return model;
    }

    public void setModel(Tutor model) {
        this.model = model;
    }
    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }
    public void setApellido(String apellido) {
        this.model.setApellido(apellido);
    }
    
    public void setDireccion(Direccion d){
        this.model.setDireccion(d);
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
