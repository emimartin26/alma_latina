/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author emiliano
 */
public class Controller {

    private JInternalFrame frame;
    private JDesktopPane escritorio;
    private int modo;

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JInternalFrame getFrame() {
        return frame;
    }

    public void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    public int getModo() {
        return this.modo;
    }

    public void setModoGuardar() {
        this.modo = 0;
    }

    public void setModoModificar() {
        this.modo = 1;
    }
}
