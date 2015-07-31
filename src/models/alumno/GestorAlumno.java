/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.alumno;

import Utilidades.Util;
import controllers.GestorConsultas;
import hibernate.GestorHibernate;
import java.util.Date;
import java.util.List;
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
        this.model = new Alumno();
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

    public void setTratamientos(Set<Tratamiento> t) {
        this.model.setTratamientos(t);
    }

    public void setObservaciones(String o) {
        this.model.setObservaciones(o);
    }

    @Override
    public void guardar() {
        try {
            this.guardarObjeto(this.model);
            System.out.println(this.model + " - Guardado con exito");
            new Util().getMensajeInformation("Alumno Guardado con exito");
        } catch (Exception e) {
            new Util().getMensajeError("Comunicarse con el administrador de sistemas");
            //JOptionPane.showMessageDialog(null, "Error al guardar objeto: " + e);
        }
    }

    @Override
    public void actuailizar() {
        try {
            this.actualizarObjeto(this.model);
            System.out.println(this.model + " - Actualizado con exito");
            new Util().getMensajeInformation("Alumno Actualizado con exito");

        } catch (Exception e) {
            new Util().getMensajeError("Comunicarse con el administrador de sistemas");
            //JOptionPane.showMessageDialog(null, "Error al actualizar objeto: " + e);
        }
    }

    @Override
    public void eliminar() {
        try {
            Alumno a = this.model;
            a.setEstado(Alumno.ELIMINADO);
            this.actualizarObjeto(a);
            new Util().getMensajeInformation("Alumno Eliminado con exito");

        } catch (Exception e) {
            new Util().getMensajeError("Comunicarse con el administrador de sistemas");
        }
    }

    @Override
    public void listar() {

    }

    //Primero paso como parametro el apellido del tutor
    //Segundo parametro apellido alumno
    //numero documento
    public List listar_por_filtro(String campo1, String campo2, String campo3) {
        GestorConsultas gestor = new GestorConsultas(Alumno.class, "alumno");
        gestor.addFiltroInt("estado", Alumno.NORMAL);
        gestor.createAlias("alumno.tutor", "tutor");
        gestor.addFiltro("tutor.apellido", campo1);

        gestor.addFiltro("apellido", campo2);
        System.out.println(campo2);

        gestor.createAlias("alumno.documento", "documento");
        gestor.addFiltro("documento.numero", campo3);
        return gestor.resultConsulta();
    }

       @Override
    public void imprimir() {
        try {
            GestorImprimir gestor = new GestorImprimir(this.listar_por_filtro("","",""), "Alumnos", "alumnos.jasper");
            gestor.imprimir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
