
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Emiliano
 */
public class GestorLista {

    private DefaultListModel listModel;

    public void newDefaultListModel() {
        this.listModel = new DefaultListModel();
    }

    /**
     * Le paso como parametro un ListModel y me devuelve un DefaulListModel
     * @param list
     * @return DefaulListModel
     */
    public DefaultListModel getDefaultListModelBaseListModel(ListModel list) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < list.getSize(); i++) {
            model.addElement(list.getElementAt(i));
        }
        return model;
    }

    /**
     *
     * Metodo que llena una Jlist con una lista de objestos. listaObject es la
     * lista resultante de una consulta a la BD y listInterfaz es el componente
     * que se encuentra en la pantalla.
     */
    public void llenarList(List listObject, JList listInterfaz) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < listObject.size(); i++) {
            model.addElement(listObject.get(i));
        }
        listInterfaz.setModel(model);

    }

    public void llenarListBaseModel(DefaultListModel listObject, JList listInterfaz) {
        listInterfaz.setModel(listObject);

    }

    public DefaultListModel getListModel() {
        DefaultListModel model = new DefaultListModel();
        return model;
    }

    /**
     *
     * Limpia una Jlist
     */
    public void clearList(JList listInterfaz) {
        DefaultListModel model = new DefaultListModel();
        model.addElement("");
        listInterfaz.setModel(model);
    }

    public boolean isVacia(JList listInterfaz) {
        DefaultListModel modelVacio = new DefaultListModel();
        modelVacio.addElement("");
        return listInterfaz.getModel().equals(modelVacio);
    }

    public boolean isSelectedList(JList list) {
        return !(list.getSelectedValue() == null);
    }
}
