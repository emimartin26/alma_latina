/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controllers.GestorConsultas;
import controllers.principal.ControllerPrincipal;
import hibernate.HibernateUtil;
import models.alumno.Alumno;
import models.inscripcion.GestorCuota;

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
//        Propiedades prop = new Propiedades();
//        prop.setConfig();
//        HibernateUtil.inicializar();
//        
//        GestorConsultas g = new GestorConsultas(Alumno.class, "alumno");
//        ControllerPrincipal contr = new ControllerPrincipal();
//        contr.abrir();
        //config();
        //GeneradorObjetos g = new GeneradorObjetos();
        //g.cargarTurnos();
        //g.cargarTiposDocumentos();
        //g.cargarGrupoSanguineo();
        //g.cargarCategorias();
        //g.cargarColegios();
        
        GestorCuota g = new GestorCuota();
        g.generarCuotas(null);

    }

}
