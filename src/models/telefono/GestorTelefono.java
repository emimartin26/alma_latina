/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.telefono;
import hibernate.GestorHibernate;
import javax.swing.JOptionPane;//ventana de error;
import models.InterfaceAbm;
/**
 *
 * @author EMILIANO
 */
public class GestorTelefono extends GestorHibernate implements InterfaceAbm {
    private Telefono model;

    public GestorTelefono() {
        this.model = new Telefono();
    }

    public Telefono getModel() {
        return model;
    }

    public void setTelefono(Telefono tel) {
        this.model = tel;
    }
    public void setNumero(String numero) {
        this.model.setNumero(numero);
    }
    public void setCaracteristica(String descripcion) {
        this.model.setCaracteristica(descripcion);
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
