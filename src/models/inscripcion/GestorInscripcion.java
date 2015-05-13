/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;
import hibernate.GestorHibernate;
import java.sql.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import models.InterfaceAbm;

/**
 *
 * @author EMILIANO
 */
public class GestorInscripcion extends GestorHibernate implements InterfaceAbm{
private Inscripcion model;

    public GestorInscripcion() {
        this.model = new Inscripcion();
    }

    public Inscripcion getModel() {
        return model;
    }

    public void setModel(Inscripcion model) {
        this.model = model;
    }
    public void setCategoria(Categoria categoria){
        this.model.setCategoria(categoria);
    }
    public void setEstado(Estado estado){
        this.model.setEstado(estado);
    }
    public void setCuota( Set<Cuota> coutas){
        this.model.setCoutas(coutas);
    }
    public void setFecha(Date fecha){
        this.model.setFecha(fecha);
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

