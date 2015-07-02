/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.Util;
import controllers.Controller;
import java.util.Iterator;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.alumno.Alumno;
import models.alumno.GestorAlumno;
import views.FrmAlumno;
import views.FrmListAlumno;

/**
 *
 * @author emiliano
 */
public class ControllerListAlumno extends Controller {

    private GestorAlumno gestor;

    public ControllerListAlumno(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmListAlumno(this));
        this.gestor = new GestorAlumno();
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }

    public FrmListAlumno getFormularioEspecifico() {
        return (FrmListAlumno) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)

    }

    public void crearGestor() {
        this.gestor = new GestorAlumno();
    }

    public GestorAlumno getGestor() {
        return this.gestor;
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) this.getFormularioEspecifico().getTblAlumnos().getModel();
    }

    public void cargarTabla(List l) {
        DefaultTableModel modelo = this.getTableModel();
        Iterator iter = l.iterator();
        while (iter.hasNext()) {
            Alumno obj = (Alumno) iter.next();
            Object[] newRow = {obj, obj.getApellido(), obj.getNombre(), obj.getDocumento().getNumero(), obj.getDireccion(), obj.getEmail(), obj.getTutor()};
            modelo.addRow(newRow);

        }
    }

    public void limpiarTabla() {
        DefaultTableModel modelo = this.getTableModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void mostrar() {
        String character_apellido = this.getFormularioEspecifico().getTxtApellido().getText();
        String character_tutor = this.getFormularioEspecifico().getTxtPadre().getText();
        String character_dni = this.getFormularioEspecifico().getTxtDni().getText();

        this.limpiarTabla();
        if (!(character_apellido.isEmpty() & character_dni.isEmpty() & character_dni.isEmpty())) {
            this.cargarTabla(this.getQueryFilter(character_tutor, character_apellido, character_dni));

        }
    }

    public void mostrarTodo() {
        this.limpiarTabla();
        this.cargarTabla(this.getQueryFilter("", "", ""));
    }

    public List getQueryFilter(String f, String g, String h) {
        return this.getGestor().listar_por_filtro(f, g, h);
    }

    public void eliminar() {
        if (this.getFormularioEspecifico().getTblAlumnos().getSelectedRow() >= 0) {
            int fila = this.getFormularioEspecifico().getTblAlumnos().getSelectedRow();
            Alumno a = (Alumno) this.getFormularioEspecifico().getTblAlumnos().getValueAt(fila, 0);
            int num = new Util().confirmacion("Usted está por eliminar al Alumno: \n" + a.getApellido() + ", " + a.getNombre() + "\n¿Desea continuar?");
            if (num == 0) {
                getGestor().setModel(a);
                getGestor().eliminar();
                this.mostrar();
            }
        } else {
            new Util().getMensajeError("No ha seleccionado ningún Alumno...");
        }

    }

    public void modificar() {
        if (this.getFormularioEspecifico().getTblAlumnos().getSelectedRow() >= 0) {
            int fila = this.getFormularioEspecifico().getTblAlumnos().getSelectedRow();
            Alumno a = (Alumno) this.getFormularioEspecifico().getTblAlumnos().getValueAt(fila, 0);
            ControllerAlumno controller = new ControllerAlumno(this.getEscritorio());
            GestorAlumno gestor = new GestorAlumno();
            gestor.setModel(a);
            controller.setGestorAlumno(gestor);
            controller.cargarFromListAlumno();
        } else {
            new Util().getMensajeError("No ha seleccionado ningún Alumno...");
        }

    }
}
