/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.inscripcion;

import controllers.Controller;
import javax.swing.JDesktopPane;
import models.inscripcion.GestorInscripcion;
import views.FrmReinscripcion;

/**
 *
 * @author EMILIANO
 */
public class ControllerInscripcion extends Controller {
    
private GestorInscripcion model;

    public FrmReinscripcion getFormularioEspecifico() {
        return (FrmReinscripcion) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)
    }

    public ControllerInscripcion(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmReinscripcion(this));
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }

    public void inicializarDatos(){
    }

}

