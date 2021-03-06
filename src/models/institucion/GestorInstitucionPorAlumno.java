/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.institucion;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
import hibernate.GestorHibernate;
/**
 *
 * @author EMILIANO
 */
public class GestorInstitucionPorAlumno extends GestorHibernate implements InterfaceAbm {
    private InstitucionPorAlumno model;

    public GestorInstitucionPorAlumno(InstitucionPorAlumno model) {
        this.model = model;
    }

    public InstitucionPorAlumno getModel() {
        return model;
    }

    public void setModel(InstitucionPorAlumno model) {
        this.model = model;
    }
    public void setDescripcion(String descripcion){
        this.model.setDescripcion(descripcion);
    }
    public void setInstitucionEducativa(InstitucionEducativa instEduc){
        this.model.setInstitucionEductiva(instEduc);
    }
    public void setTurno(Turno turno){
        this.model.setTurno(turno);
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
