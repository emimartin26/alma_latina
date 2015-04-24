/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.GestorCombo;
import controllers.Controller;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import models.alumno.GestorAlumno;
import models.identificacion.GestorTipoDocumento;
import views.FrmAlumno;

/**
 *
 * @author emiliano
 */
public class ControllerAlumno extends Controller {

    private GestorAlumno model;
    private ControllerTelefono controllerTelefono;
    private ControllerLocalidad controllerLocalidad;

    public ControllerAlumno() {

    }

    public void crearControllerAlumno() {
        this.controllerTelefono = new ControllerTelefono(this.getFormularioEspecifico());
        this.controllerLocalidad = new ControllerLocalidad(this.getFormularioEspecifico()); 
    }
    public ControllerLocalidad getControllerLocalidad() {
        return controllerLocalidad;
    }
    public ControllerTelefono getControllerTelefono() {
        return controllerTelefono;
    }
    public void setControllerLocalidad(ControllerLocalidad controllerLocalidad) {
        this.controllerLocalidad = controllerLocalidad;
    }

    public void setControllerTelefono(ControllerTelefono controllerTelefono) {
        this.controllerTelefono = controllerTelefono;
    }

    public FrmAlumno getFormularioEspecifico() {
        return (FrmAlumno) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)

    }

    public ControllerAlumno(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmAlumno(this));
    }

    public void cargar() {
        this.abrir();
        this.crearControllerAlumno();
        this.inicializarDatos();
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }

    public void addTelefono() {
        this.getControllerTelefono().addTelefono();
    }

    public void removeTelefono() {
        this.getControllerTelefono().removeTelefono();
    }

    public void cargarLocalidades() {
        this.getControllerLocalidad().cargarLocalidades();
    }

    public void cargarTiposDocumentos() {
        JComboBox cmbTiposDoc = this.getFormularioEspecifico().getCmbTipoDni();
        GestorTipoDocumento g = new GestorTipoDocumento();
        List tipos = g.getTiposDoc();
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(tipos, cmbTiposDoc);
        

    }

    public void inicializarDatos() {
        this.cargarLocalidades();
        this.cargarTiposDocumentos();
    }

}
