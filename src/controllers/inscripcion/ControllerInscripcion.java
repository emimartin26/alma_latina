/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.inscripcion;

import Utilidades.GestorCombo;
import Utilidades.Util;
import controllers.Controller;
import java.util.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import models.alumno.GestorAlumno;
import models.inscripcion.Categoria;
import models.inscripcion.GestorCategoria;
import models.inscripcion.GestorInscripcion;
import models.inscripcion.Inscripcion;
import views.FrmInscripcion;

/**
 *
 * @author EMILIANO
 */
public class ControllerInscripcion extends Controller {
    
private final GestorInscripcion gestorInscripcion;
private final GestorAlumno gestorAlumno;

    public FrmInscripcion getFormularioEspecifico() {
        return (FrmInscripcion) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)
    }

    public ControllerInscripcion(JDesktopPane escritorio,GestorAlumno gestor) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmInscripcion(this));
        this.gestorAlumno = gestor;
        this.gestorInscripcion = new GestorInscripcion();
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
        this.inicializarDatos();
    }

    public void inicializarDatos(){
        this.getFormularioEspecifico().setTitle("Inscripcion: " + this.gestorAlumno.getModel().getApellido() + ", "+ this.gestorAlumno.getModel().getNombre());
        this.cargarCategorias(); 
    }
    public void cargarCategorias() {
        GestorCategoria gestor = new GestorCategoria();
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo( gestor.listCategorias(), this.getFormularioEspecifico().getCmbCategorias(), true);
    }

    public void crearInscripcion() {
        if(this.getFormularioEspecifico().getCmbCategorias().getSelectedItem()  == null){
            new Util().getMensajeError("No ha seleccionado ninguna categoría...");
        }else{
            Categoria cat = (Categoria) this.getFormularioEspecifico().getCmbCategorias().getSelectedItem();
            int year = this.getFormularioEspecifico().getChoiceYear().getYear();
            this.gestorInscripcion.getModel().setCategoria(cat);
            this.gestorInscripcion.getModel().setYear(year);
            this.gestorInscripcion.getModel().setFecha(new Date());
            this.gestorInscripcion.getModel().setAlumno(this.gestorAlumno.getModel());

        }
        
    }
    
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) this.getFormularioEspecifico().getTblCategorias().getModel();
    }

    public void cargarTabla(List l) {
        DefaultTableModel modelo = this.getTableModel();
        Iterator iter = l.iterator();
        while (iter.hasNext()) {
            Inscripcion obj = (Inscripcion) iter.next();
            Object[] newRow = {obj, };
            modelo.addRow(newRow);

        }
    }

    public void limpiarTabla() {
        DefaultTableModel modelo = this.getTableModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
}

