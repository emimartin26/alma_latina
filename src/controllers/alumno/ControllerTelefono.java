/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.GestorLista;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import models.telefono.GestorTelefono;
import models.telefono.Telefono;
import views.FrmAlumno;

/**
 *
 * @author emiliano
 */
public class ControllerTelefono {

    private FrmAlumno frm;

    public ControllerTelefono(FrmAlumno f) {
        this.frm = f;
    }

    public void addTelefono() {
        String caracteristica = this.getFormularioEspecifico().getTxtCaractTelefono().getText();
        String numero = this.getFormularioEspecifico().getTxtNumTelefono().getText();
        GestorTelefono g = new GestorTelefono();
        g.setNumero(numero);
        g.setCaracteristica(caracteristica);
        this.addNumLisTel(g.getModel());

    }

    public void addNumLisTel(Telefono tel) {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getListTelefonos().getModel());
        defaultListModel.addElement(tel);
        gestorLista.llenarListBaseModel(defaultListModel, this.getListTelefonos());
    }

    public void removeTelefono() {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getListTelefonos().getModel());
        defaultListModel.remove(this.getSelectListTel());
        gestorLista.llenarListBaseModel(defaultListModel, this.getListTelefonos());

    }

    public JList getListTelefonos() {
        return this.getFormularioEspecifico().getLstNumerosTelefono();
    }

    public int getSelectListTel() {
        return this.getListTelefonos().getSelectedIndex();
    }

    public FrmAlumno getFormularioEspecifico() {
        return this.frm;
    }

}
