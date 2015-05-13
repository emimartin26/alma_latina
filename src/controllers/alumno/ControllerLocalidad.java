/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.GestorCombo;
import java.util.List;
import javax.swing.JComboBox;
import models.ubicacion.GestorLocalidad;
import views.FrmAlumno;

/**
 *
 * @author EMILIANO
 */
public class ControllerLocalidad {

    private FrmAlumno frm;

    public ControllerLocalidad(FrmAlumno f) {
        this.frm = f;
    }

    public void cargarLocalidades() {
        JComboBox cmbLocalidad = this.getFormularioEspecifico().getCmbLocalidad();
        JComboBox cmbLocalidad2 = this.getFormularioEspecifico().getCmbLocalidadTutor();

        GestorLocalidad g = new GestorLocalidad();
        List localidades = g.getLocalidadesXProv("Córdoba");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(localidades, cmbLocalidad);
        ges.cargarCombo(localidades, cmbLocalidad2);

    }

    public FrmAlumno getFormularioEspecifico() {
        return this.frm;
    }

}
