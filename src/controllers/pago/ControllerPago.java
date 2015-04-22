/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.pago;
import controllers.Controller;
import javax.swing.JDesktopPane;
import models.pago.GestorPago;
import views.FrmGestionCouta;

/**
 *
 * @author EMILIANO
 */
public class ControllerPago extends Controller{
    private GestorPago model;
   
    public FrmGestionCouta getFormularioEspecifico() {
        return (FrmGestionCouta) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)
    }

    public ControllerPago(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmGestionCouta(this));
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }
    public void inicializarDatos(){
    }

}

