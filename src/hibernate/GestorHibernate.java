/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.awt.Component;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GestorHibernate extends HibernateUtil {

    /**
     * Elimina un objeto del repositorio
     *
     * @param objeto Objeto a eliminar
     */
    private Transaction tx;

    public void eliminarObjeto(Object objeto) {
        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.delete(objeto);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Repositorio.eliminarObjeto(Object objeto)" + ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, "El elemento no se puede eliminar:" + ex.getMessage(), "Error", 0);
            getTx().rollback();
        }
    }

    public void guardarObjeto(Object objeto) {
        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.save(objeto);
            tx.commit();


        } catch (Exception ex) {
            System.out.println("error " + ex);
            System.out.println("Repositorio.guardarObjeto(Object objeto)" + objeto.getClass() + ": " + objeto.toString() + ex);
            ex.printStackTrace();
            getTx().rollback();
        }
    }

    /**
     * Actualiza un objeto en el repositorio
     *
     * @param objeto Objeto a actualizar
     */
    public void actualizarObjeto(Object objeto) {
        try {
            Session s = HibernateUtil.getSession();
            Transaction tx = s.beginTransaction();
            s.update(objeto);
            tx.commit();

            System.out.println(" actualizarObjeto() " + objeto.getClass() + ": " + objeto.toString());
        } catch (Exception ex) {
            System.out.println("Repositorio.actualizarObjeto(Object objeto)" + ex);
        }
    }

    public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }


}
