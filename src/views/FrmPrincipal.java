/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Utilidades.EscritorioFondo;
import controllers.principal.ControllerPrincipal;
import gui.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author emiliano
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    private EscritorioFondo escritorio;
    private ControllerPrincipal controller;

    public FrmPrincipal(ControllerPrincipal controller) {
        this.configSkin();
        initComponents();
        // En esta linea iniciamos el formulario maximizado
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIcon();
        this.controller = controller;
        this.configFondo();
    }

    private void setIcon() {
        URL iconURL = getClass().getResource("/Images/icons/estadoAlumno.png");
// iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
    }

    public EscritorioFondo getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(EscritorioFondo escritorio) {
        this.escritorio = escritorio;
    }

    public ControllerPrincipal getController() {
        return controller;
    }

    public void setController(ControllerPrincipal controller) {
        this.controller = controller;
    }

    public void configFondo() {
        this.escritorio = new EscritorioFondo();
        this.add(this.escritorio, BorderLayout.CENTER);
//        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemNewAlumno = new javax.swing.JMenuItem();
        menuItemListAlum = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        registrarCuota = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemReinscripcionActionPerformed = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alma Latina ");

        jMenu1.setText("Gestion Alumnos");

        menuItemNewAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/sheet3.png"))); // NOI18N
        menuItemNewAlumno.setText("Nuevo Alumno");
        menuItemNewAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemNewAlumno);

        menuItemListAlum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/chart46.png"))); // NOI18N
        menuItemListAlum.setText("Listar Alumnos");
        menuItemListAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListAlumActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemListAlum);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestion Cuotas");

        registrarCuota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/clipboard105 (1).png"))); // NOI18N
        registrarCuota.setText("Registrar cuota");
        registrarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCuotaActionPerformed(evt);
            }
        });
        jMenu2.add(registrarCuota);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Gestion Inscripcion");

        menuItemReinscripcionActionPerformed.setText("Reinscripción");
        menuItemReinscripcionActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReinscripcionActionPerformedActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemReinscripcionActionPerformed);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCuotaActionPerformed
        this.getController().abrirFrmGestionCouta();
    }//GEN-LAST:event_registrarCuotaActionPerformed

    private void menuItemNewAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewAlumnoActionPerformed
        this.getController().abrirFrmAlumno();
    }//GEN-LAST:event_menuItemNewAlumnoActionPerformed

    private void menuItemReinscripcionActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReinscripcionActionPerformedActionPerformed
        this.getController().abrirFrmInscripcion();
    }//GEN-LAST:event_menuItemReinscripcionActionPerformedActionPerformed

    private void menuItemListAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListAlumActionPerformed
        this.getController().abrirFrmListAlumno();
    }//GEN-LAST:event_menuItemListAlumActionPerformed
    private void configSkin() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceSteelBlueTheme");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemListAlum;
    private javax.swing.JMenuItem menuItemNewAlumno;
    private javax.swing.JMenuItem menuItemReinscripcionActionPerformed;
    private javax.swing.JMenuItem registrarCuota;
    // End of variables declaration//GEN-END:variables
}
