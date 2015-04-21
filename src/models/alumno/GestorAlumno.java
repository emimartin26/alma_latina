/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.alumno;

import hibernate.GestorHibernate;
import java.util.Set;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
import models.atencionMedica.Alergia;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.institucion.InstitucionPorAlumno;
import models.mutual.Mutual;
import models.tutor.Tutor;
/**
 *
 * @author EMILIANO
 */
public class GestorAlumno extends GestorHibernate implements InterfaceAbm{
    private Alumno model;

    public GestorAlumno(Alumno model) {
        this.model = model;
    }

    public Alumno getModel() {
        return model;
    }

    public void setModel(Alumno model) {
        this.model = model;
    }
    public void setDocumento(Documento documento){
       this.model.setDocumento(documento);
    }
    public void setGrupoSangineo(GrupoSanguineo grupSang){
        this.model.setGrupoSanguineo(grupSang);
    }
    public void setTutor(Tutor tutor){
        this.model.setTutor(tutor);
    }
    public void setInstitucionPorAlumno(InstitucionPorAlumno insXAlumn){
        this.model.setInstitucionPorAlumno(insXAlumn);
    }
    public void setAlergia(Set<Alergia> alergias){
        this.model.setAlergias(alergias);
    }
    public void setMutual(Set<Mutual> mutuales){
        this.model.setMutuales(mutuales);
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


