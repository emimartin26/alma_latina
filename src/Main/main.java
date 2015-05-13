/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controllers.GestorConsultas;
import controllers.principal.ControllerPrincipal;
import gui.FrmPrincipal;
import hibernate.GestorHibernate;
import hibernate.HibernateUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import models.alumno.Alumno;

/**
 * import hibernate.HibernateUtil;
 *
 * /**
 *
 * @author emiliano
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HibernateUtil.inicializar();
        GestorConsultas g = new GestorConsultas(Alumno.class, "alumno");
//        for (int i = 0; i < g.resultConsulta().size(); i++) {
//            System.out.println(g.resultConsulta().get(i));
//            System.out.println("\t");
//        }
        ControllerPrincipal contr = new ControllerPrincipal();
        contr.abrir();
        //config();
//        GeneradorObjetos g = new GeneradorObjetos();
//        g.cargarTurnos();

    }

}
