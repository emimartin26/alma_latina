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
import models.inscripcion.GestorCuota;
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

    public ControllerInscripcion(JDesktopPane escritorio, GestorAlumno gestor) {
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

    public void inicializarDatos() {
        this.getFormularioEspecifico().setTitle("Inscripcion: " + this.gestorAlumno.getModel().getApellido() + ", " + this.gestorAlumno.getModel().getNombre());
        this.cargarCategorias();
    }

    public void cargarCategorias() {
        GestorCategoria gestor = new GestorCategoria();
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(gestor.listCategorias(), this.getFormularioEspecifico().getCmbCategorias(), true);
    }

    public void crearInscripcion() {
        if (this.getFormularioEspecifico().getCmbCategorias().getSelectedItem() == null) {
            new Util().getMensajeError("No ha seleccionado ninguna categoría...");
        } else {
            Categoria cat = (Categoria) this.getFormularioEspecifico().getCmbCategorias().getSelectedItem();
            int year = this.getFormularioEspecifico().getChoiceYear().getYear();
            this.gestorInscripcion.crearModel();
            this.gestorInscripcion.getModel().setCategoria(cat);
            this.gestorInscripcion.getModel().setYear(year);
            this.gestorInscripcion.getModel().setFecha(new Date());
            this.gestorInscripcion.getModel().setAlumno(this.gestorAlumno.getModel());
            Calendar aux = Calendar.getInstance();
            if (year == aux.get(Calendar.YEAR)) {
                this.gestorInscripcion.getModel().setCoutas(new GestorCuota().generarCuotas(true, null));
            } else {
                aux.set(Calendar.MONTH, 0);
                aux.set(Calendar.YEAR, year);
                this.gestorInscripcion.getModel().setCoutas(new GestorCuota().generarCuotas(false, aux));
            }
            if (this.gestorInscripcion.estaInscripto(year, cat,this.gestorAlumno.getModel())) {
                new Util().getMensajeError("El alumno ya se encuentra inscripto en la categoría " + cat.getNombre() +" para el año " + year);
            }else{
                this.gestorInscripcion.guardar();
                this.cargarTabla(); 
                new Util().getMensajeInformation("Inscripción realizada con éxito...");
            }

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
            Object[] newRow = {obj, obj.getCategoria(), obj.getYear(), Util.DATE_FORMAT().format(obj.getFecha())};
            modelo.addRow(newRow);

        }
    }

    public void limpiarTabla() {
        DefaultTableModel modelo = this.getTableModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void cargarTabla() {
        this.limpiarTabla();
        List inscripcionesByAlumno = this.gestorInscripcion.getInscripcionesByAlumno(this.gestorAlumno.getModel());
        this.cargarTabla(inscripcionesByAlumno);
    }

    public void cerrar() {
        this.getFormularioEspecifico().setVisible(false);
    }

    public void eliminar() {
      if (this.getFormularioEspecifico().getTblCategorias().getSelectedRow() >= 0) {
            int fila = this.getFormularioEspecifico().getTblCategorias().getSelectedRow();
            Inscripcion a = (Inscripcion) this.getFormularioEspecifico().getTblCategorias().getValueAt(fila, 0);
            this.gestorInscripcion.setModel(a);
            this.gestorInscripcion.eliminar();
            this.cargarTabla();
        } else {
            new Util().getMensajeError("No ha seleccionado inscripcion...");
        }
    }
}
