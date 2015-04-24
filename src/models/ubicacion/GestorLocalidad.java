/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.ubicacion;

import controllers.GestorConsultas;
import hibernate.GestorHibernate;
import java.util.List;
import javax.swing.JOptionPane;
import models.InterfaceAbm;

/**
 *
 * @author emiliano
 */
public class GestorLocalidad extends GestorHibernate implements InterfaceAbm {

    private Localidad model;

    public GestorLocalidad() {
        this.model = new Localidad();
    }

    public Localidad getModel() {
        return model;
    }

    public void setModel(Localidad model) {
        this.model = model;
    }

    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }

    public void setDescripcion(String descrip) {
        this.model.setDescripcion(descrip);
    }

    public void setProvincia(Provincia prov) {
        this.model.setProvincia(prov);
    }

    public List getLocalidadesXProv(String nombreProvincia) {
        GestorConsultas gestor = new GestorConsultas(Localidad.class, "localidad");
        gestor.createAlias("localidad.provincia", "provincia");
        gestor.addRestriccion("provincia.nombre", nombreProvincia);
        return gestor.resultConsulta();
        
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

    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
