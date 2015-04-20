/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import gui.FrmPrincipal;
import hibernate.GestorHibernate;
import hibernate.HibernateUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

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
        FrmPrincipal f = new FrmPrincipal();
        f.setVisible(true);
        HibernateUtil.inicializar();
        //config();

    }


}

