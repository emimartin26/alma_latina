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
        //FrmPrincipal f = new FrmPrincipal();
        //f.setVisible(true);
        HibernateUtil.inicializar();
        //config();

    }

//    public static void config() {
//        Properties prop = new Properties();
//        OutputStream output = null;
//
//        try {
//
//            output = new FileOutputStream("config.properties");
//
//            // set the properties value
//            prop.setProperty("dbname", "db_alma_latina");
//            prop.setProperty("dbuser", "mkyong");
//            prop.setProperty("dbpassword", "password");
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        } finally {
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
}

