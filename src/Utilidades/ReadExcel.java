/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Emiliano
 */
import hibernate.GestorHibernate;
import hibernate.HibernateUtil;
import java.io.*;
import jxl.*;
import models.ubicacion.Localidad;
import models.ubicacion.Pais;
import models.ubicacion.Provincia;

public class ReadExcel {

    private void leerArchivoExcel(String archivoDestino) {
        Provincia prov = null;
        GestorHibernate gestorHibernate = new GestorHibernate();
        Pais p = new Pais();
        p.setNombre("Argentina");
        p.setDescripcion("Descripcion");
        gestorHibernate.guardarObjeto(p);
        try {
            WorkbookSettings workbookSettings = new WorkbookSettings();
            workbookSettings.setEncoding("Cp1252");
            Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino), workbookSettings);

            System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets());
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre cada    hoja                                                                                                                                                       
            {
                Sheet hoja = archivoExcel.getSheet(sheetNo);
                int numColumnas = hoja.getColumns();
                int numFilas = hoja.getRows();
                String data;
                String provincia;
                String localidad;
                String comparador;
                System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName());
                comparador = "";

                for (int fila = 1; fila < numFilas; fila++) { // Recorre cada fila de la hoja

                    provincia = hoja.getCell(1, fila).getContents();
                    localidad = hoja.getCell(2, fila).getContents();
                    if (comparador == provincia) {
                        System.out.println("Son igualess");

                        //
                    } else {
                        prov = new Provincia();
                        prov.setNombre(provincia);
                        prov.setPais(p);
                        comparador = provincia;
                        gestorHibernate.guardarObjeto(prov);
                    }

                    Localidad l = new Localidad();
                    l.setNombre(localidad);
                    l.setProvincia(prov);
                    gestorHibernate.guardarObjeto(l);
                    for (int columna = 0; columna < numColumnas; columna++) { // Recorre   cada columna   de la fila                                                                       
                        data = hoja.getCell(columna, fila).getContents();
                    }
                  
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }

    public static void main(String arg[]) {
        HibernateUtil.inicializar();
        ReadExcel excel = new ReadExcel();
        excel.leerArchivoExcel("/home/emiliano/localidades1.xls");
    }
}
