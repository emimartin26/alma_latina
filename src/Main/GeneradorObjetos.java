/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import hibernate.GestorHibernate;
import hibernate.HibernateUtil;
import models.identificacion.TipoDocumento;

/**
 *
 * @author emiliano DNI: documento nacional de identidad CI: cedula de identidad
 * LC: libreta civica
 */
public class GeneradorObjetos {

    private GestorHibernate gestor;

    public GeneradorObjetos() {
        HibernateUtil.inicializar();
        this.gestor = new GestorHibernate();
        System.out.println("Generating objects...");

    }

    public GestorHibernate getGestor() {
        return gestor;
    }

    public void cargarTiposDocumentos() {
        TipoDocumento tipo1 = new TipoDocumento();
        tipo1.setNombre("DNI");
        tipo1.setDetalle("Documento Nacional de Identidad");

        TipoDocumento tipo2 = new TipoDocumento();
        tipo2.setNombre("CI");
        tipo2.setDetalle("Cedula de Identidad");

        TipoDocumento tipo3 = new TipoDocumento();
        tipo3.setNombre("LC");
        tipo3.setDetalle("Libreta Civica");

        this.getGestor().guardarObjeto(tipo1);
        this.getGestor().guardarObjeto(tipo2);
        this.getGestor().guardarObjeto(tipo3);

        System.out.println("TiposDocumento is ready...");

    }
}
