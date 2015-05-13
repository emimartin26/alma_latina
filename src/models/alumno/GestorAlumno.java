/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.alumno;

import hibernate.GestorHibernate;
import java.util.Date;
import java.util.Set;
import javax.swing.JOptionPane;
import models.InterfaceAbm;
import models.atencionMedica.Alergia;
import models.atencionMedica.Tratamiento;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.institucion.InstitucionPorAlumno;
import models.mutual.Mutual;
import models.telefono.Telefono;
import models.tutor.Tutor;
import models.ubicacion.Direccion;

/**
 *
 * @author EMILIANO
 */
public class GestorAlumno extends GestorHibernate implements InterfaceAbm {

    private Alumno model;

    public GestorAlumno() {
    }

    public Alumno getModel() {
        return model;
    }

    public void setModel(Alumno model) {
        this.model = model;
    }

    public void crearModelo() {
        this.model = new Alumno();
    }

    public void setNombre(String nombre) {
        this.model.setNombre(nombre);
    }

    public void setApellido(String apellido) {
        this.model.setApellido(apellido);
    }

    public void setEmail(String email) {
        this.model.setEmail(email);
    }

    public void setFechaNac(Date fecha) {
        this.model.setFechaNacimiento(fecha);
    }

    public void setDocumento(Documento documento) {
        this.model.setDocumento(documento);
    }

    public void setTutor(Tutor tutor) {
        this.model.setTutor(tutor);
    }

    public void setInstitucionPorAlumno(InstitucionPorAlumno insXAlumn) {
        this.model.setInstitucionPorAlumno(insXAlumn);
    }

    public void setAlergia(Set<Alergia> alergias) {
        this.model.setAlergias(alergias);
    }

    public void setMutual(Mutual mutual) {
        this.model.setMutual(mutual);
    }

    public Set<Telefono> getTelefonos() {
        return this.model.getTelefonos();
    }

    public void setTelefonos(Set<Telefono> tel) {
        this.model.setTelefonos(tel);
    }

    public void setDireccion(Direccion dir) {
        this.model.setDireccion(dir);
    }

    public void setGrupoSanguineo(GrupoSanguineo grupo) {
        this.model.setGrupoSanguineo(grupo);
    }
    
    public void setTratamientos(Set<Tratamiento> t){
        this.model.setTratamientos(t);
    }
    public void setObservaciones(String o){
        this.model.setObservaciones(o);
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
