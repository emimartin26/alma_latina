/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Emiliano
 */
public class GestorCombo {

    public void cargarCombo(List lista, JComboBox combo) {
        List <Object> listaAux = lista;
        combo.removeAllItems();
        combo.addItem(null);
        for (Object objeto : listaAux) {
            combo.addItem(objeto);
        }
    }
}
