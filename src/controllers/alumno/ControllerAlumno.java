/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.GestorCombo;
import controllers.Controller;
import controllers.GestorConsultas;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import models.alumno.GestorAlumno;
import models.ubicacion.Localidad;
import models.ubicacion.Provincia;
import views.FrmAlumno;

/**
 *
 * @author emiliano
 */
public class ControllerAlumno extends Controller {

    private GestorAlumno model;

    public FrmAlumno getFormularioEspecifico() {
        return (FrmAlumno) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)
    }

    public ControllerAlumno(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmAlumno(this));
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }

    public void cargarLocalidades() {
        JComboBox cmbLocalidad = this.getFormularioEspecifico().getCmbLocalidad();
        GestorConsultas gestor = new GestorConsultas(Localidad.class, "localidad");
        gestor.createAlias("localidad.provincia", "provincia");
        gestor.addRestriccion("provincia.nombre", "Córdoba");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(gestor.resultConsulta(), cmbLocalidad);

    }
    
    public void inicializarDatos(){
        this.cargarLocalidades();
    }

}
