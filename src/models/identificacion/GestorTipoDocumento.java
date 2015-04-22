/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.identificacion;
import controllers.GestorConsultas;
import hibernate.GestorHibernate;
import java.util.List;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
/**
 *
 * @author EMILIANO
 */
public class GestorTipoDocumento extends GestorHibernate implements InterfaceAbm{
    private TipoDocumento model;

    public GestorTipoDocumento() {
        this.model = new TipoDocumento();
    }

    public TipoDocumento getModel() {
        return model;
    }

    public void setModel(TipoDocumento model) {
        this.model = model;
    }
    public void setNombre(String nombre){
        this.model.setNombre(nombre);
    }
    public void setDetalle(String detalle){
        this.model.setDetalle(detalle);
    }
    
    public List getTiposDoc(){
        GestorConsultas g = new GestorConsultas(TipoDocumento.class, "tipodocumento");
        return g.resultConsulta();
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

    
    


