/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.alumno;

import hibernate.GestorDeReportes;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author emiliano
 */
public class GestorImprimir {

    private GestorDeReportes gestorRep;
    /* primer parametro lista con los objetos a imprimir
     * segundo parametro string del subtitulo del reporte
     * tercer parametro nombre del reporte.jasper
     */

    public GestorImprimir(List lista, String Subtitulo, String nombreReporte) {
        try {
            String so = System.getProperty("os.name");
            
            if ("Linux".equals(so) || "Mac OS X".equals(so)) {
                String cadena = System.getProperty("user.dir");
                String patch = cadena + "/src/Reportes/" + nombreReporte;
                this.crearGestor(patch);
                this.getGestorRep().agregarParametro("TITULO", "ALMA LATINA");
                this.getGestorRep().agregarParametro("subtitulo", Subtitulo);
                this.getGestorRep().agregarParametro("direccion", "Dirección: La rioja 645 - Villa María, Córdoba");
                this.getGestorRep().agregarParametro("membrete", "Teléfono: 3536573298 - 3534175454 ");
                this.getGestorRep().agregarParametro("foto", cadena + "/src/Images/logo.jpg");
                this.getGestorRep().agregarParametro("directorio", cadena + "/src/Reportes/");
                this.getGestorRep().setColeccionDeDatos(lista);
            } else {
                String cadena = System.getProperty("user.dir");
                String patch = cadena + "\\src\\Reportes\\" + nombreReporte;
                this.crearGestor(patch);
                this.getGestorRep().agregarParametro("TITULO", "ALMA LATINA");
                this.getGestorRep().agregarParametro("subtitulo", Subtitulo);
                this.getGestorRep().agregarParametro("direccion", "Dirección: La rioja 645 - Villa María, Córdoba");
                this.getGestorRep().agregarParametro("membrete", "Teléfono: 3536573298 - 3534175454 ");
                this.getGestorRep().agregarParametro("foto", cadena + "\\src\\Images\\logo.jpg");
                this.getGestorRep().agregarParametro("directorio", cadena + "\\src\\Reportes\\");
                this.getGestorRep().setColeccionDeDatos(lista);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private GestorDeReportes getGestorRep() {
        return gestorRep;
    }

    public void setGestorRep(GestorDeReportes gestorRep) {
        this.gestorRep = gestorRep;
    }

    private void crearGestor(String patch) {
        this.gestorRep = new GestorDeReportes(patch);
    }

    public void imprimir() {
        this.getGestorRep().imprimir();
    }
}
