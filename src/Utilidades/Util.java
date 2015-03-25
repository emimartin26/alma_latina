/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Emiliano
 */
public class Util {

    public static boolean estaVacioTxt(JTextField txt) {
        return ("".equals(txt.getText().trim()));
    }

    public static boolean estaSeleccionadoCombo(JComboBox combo) {
        return (combo.getSelectedItem() == null);
    }

    public static void soloLetras(java.awt.event.KeyEvent evt) {
        char teclaPulsada = evt.getKeyChar();  // Recogemos, a partir del evento, la tecla que se pulsó
        if (Character.isLetter(teclaPulsada) || Character.isSpaceChar(teclaPulsada)) { //Si la tecla pulsada es una letra o es la tecla espacio no sucede nada.
        } else { // Si la tecla pulsada  no es un letra o no es la tecla espacio.
            evt.consume();// Borramos la última letra introducida (lo hace muy rápido, la
            // letra nunca se escribe en el textfield)
        }
    }

    public static void soloEntero(java.awt.event.KeyEvent evt) {
        char teclaPulsada = evt.getKeyChar(); // Recogemos, a partir del evento, la tecla que se pulsó

        if (!Character.isDigit(teclaPulsada)) { // Si la tecla pulsada no es un dígito, entonces... 
            evt.consume(); // Borramos la última letra introducida (lo hace muy rápido, la
            // letra nunca se escribe en el textfield)
        }
    }

    public void convierteMayusculas(java.awt.event.KeyEvent evt) {
        char teclaPulsada = evt.getKeyChar(); // Recogemos, a partir del evento, la tecla que se pulsó

        Character.toUpperCase(teclaPulsada); // La convertimos a mayúsculas

    }

    public void getMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/m_error.png")).getImage()));

    }

    public void getMensajeWarning(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/m_atencion.png")).getImage()));
    }

    public void getMensajeInformation(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/m_bien.png")).getImage()));
    }

    public int confirmacion(String mensaje) {
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/m_pregunta.png")).getImage()));
        return opcion;

    }

    public static String fecha() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es"));
        Date fechaDate = new Date();
        String fecha = formateador.format(fechaDate);
        return fecha;
    }

    public static String formatFecha(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es"));
        String fechaFormat = formateador.format(fecha);
        return fechaFormat;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public static boolean estaIngresadoList(List lista, Object obj) {
        return lista.contains(obj); //verifica si el objeto pasado como parametro, ya esta ingresado en la lista
    }

    
}
