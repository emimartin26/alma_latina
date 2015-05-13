/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.principal;

import Utilidades.Util;
import controllers.alumno.ControllerAlumno;
import controllers.inscripcion.ControllerInscripcion;
import controllers.pago.ControllerPago;
import javax.swing.JDesktopPane;
import views.FrmPrincipal;

/**
 *
 * @author emiliano
 */
public class ControllerPrincipal {

    private FrmPrincipal formularioPrincipal;

    public FrmPrincipal getFormularioPrincipal() {
        return formularioPrincipal;
    }

    public void setFormularioPrincipal(FrmPrincipal formularioPrincipal) {
        this.formularioPrincipal = formularioPrincipal;
    }

    public void crearFormulario() {
        this.formularioPrincipal = new FrmPrincipal(this);
    }

    public void abrir() {
        try {
            //Sobreescribo el puntero de formulario principal para poder aplicar la configuracion
            this.crearFormulario();
            this.getFormularioPrincipal().setVisible(true);
        } catch (Exception e) {
            new Util().getMensajeError("Errror en mostrar formulario: " + e + "");
        }

    }
  
    public void abrirFrmAlumno(){
        ControllerAlumno controller = new ControllerAlumno(this.getEscritorio());
        controller.cargar();
        
    }
    public void abrirFrmInscripcion(){
        ControllerInscripcion controller = new ControllerInscripcion(this.getEscritorio());
        controller.abrir();
        controller.inicializarDatos();
        
    }
     public void abrirFrmGestionCouta(){
        ControllerPago controller = new ControllerPago(this.getEscritorio());
        controller.abrir();
        controller.inicializarDatos();
        
    }
    
    public JDesktopPane getEscritorio(){
        return this.getFormularioPrincipal().getEscritorio();
        
    }
    
    
}
