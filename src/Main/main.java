/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controllers.GestorConsultas;
import controllers.principal.ControllerPrincipal;
import hibernate.HibernateUtil;
import java.util.Calendar;
import java.util.Iterator;
import models.alumno.Alumno;
import models.inscripcion.Cuota;
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
      HibernateUtil.inicializar();
//        
        GestorConsultas g = new GestorConsultas(Alumno.class, "alumno");
        ControllerPrincipal contr = new ControllerPrincipal();
        contr.abrir();
        //config();
        //GeneradorObjetos g = new GeneradorObjetos();
        //g.cargarEstados();
        //g.cargarTurnos();
        //g.cargarTiposDocumentos();
        //g.cargarGrupoSanguineo();
        //g.cargarCategorias();
        //g.cargarColegios();
//        
//        GestorCuota g1 = new GestorCuota();
//        Calendar aux = Calendar.getInstance();
//        aux.set(Calendar.YEAR, 2017);
//        aux.set(Calendar.MONTH, 0);

//        Iterator it = g1.generarCuotas(g1.generarFechasCuotas(false,aux)).iterator();
        
       // while(it.hasNext()){
       //     System.out.println((Cuota) it.next());
        //}

    }

}
