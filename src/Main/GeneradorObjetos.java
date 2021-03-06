/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controllers.GestorConsultas;
import hibernate.GestorHibernate;
import hibernate.HibernateUtil;
import models.grupo.GrupoSanguineo;
import models.identificacion.TipoDocumento;
import models.inscripcion.Categoria;
import models.inscripcion.Estado;
import models.institucion.InstitucionEducativa;
import models.institucion.Turno;
import models.mutual.Mutual;
import models.ubicacion.Direccion;
import models.ubicacion.Localidad;
import models.ubicacion.Provincia;

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

    public void cargarGrupoSanguineo() {
        GrupoSanguineo grup = new GrupoSanguineo();
        grup.setFactor("+");
        grup.setTipo("0");
        this.getGestor().guardarObjeto(grup);
        GrupoSanguineo grup2 = new GrupoSanguineo();
        grup2.setFactor("-");
        grup2.setTipo("0");
        this.getGestor().guardarObjeto(grup2);

        GrupoSanguineo grup3 = new GrupoSanguineo();
        grup3.setFactor("+");
        grup3.setTipo("A");
        this.getGestor().guardarObjeto(grup3);

        GrupoSanguineo grup4 = new GrupoSanguineo();
        grup4.setFactor("-");
        grup4.setTipo("A");
        this.getGestor().guardarObjeto(grup4);

        GrupoSanguineo grup5 = new GrupoSanguineo();
        grup5.setFactor("-");
        grup5.setTipo("B");
        this.getGestor().guardarObjeto(grup5);

        GrupoSanguineo grup6 = new GrupoSanguineo();
        grup6.setFactor("+");
        grup6.setTipo("B");
        this.getGestor().guardarObjeto(grup6);

        GrupoSanguineo grup7 = new GrupoSanguineo();
        grup7.setFactor("+");
        grup7.setTipo("AB");
        this.getGestor().guardarObjeto(grup7);

        GrupoSanguineo grup8 = new GrupoSanguineo();
        grup8.setFactor("-");
        grup8.setTipo("AB");
        this.getGestor().guardarObjeto(grup8);

        System.out.println("Grupo Sanguineo is ready...");

    }

    public void cargarMutuales() {
        Mutual mn = new Mutual();
        mn.setNombre("No Mutual");
        mn.setDescripcion("Descripcion 1");
        this.getGestor().guardarObjeto(mn);

        Mutual m = new Mutual();
        m.setNombre("Osde");
        m.setDescripcion("Descripcion 1");
        this.getGestor().guardarObjeto(m);

        Mutual m1 = new Mutual();
        m1.setNombre("Ostama");
        m1.setDescripcion("Descripcion 2");
        this.getGestor().guardarObjeto(m1);

        System.out.println("Mutuales is ready...");

    }

    public void cargarColegios() {
        GestorConsultas gestor = new GestorConsultas(Localidad.class, "localidad");
        Localidad loc = (Localidad) gestor.resultConsulta().get(0);

        InstitucionEducativa in = new InstitucionEducativa();
        in.setNombre("No Colegio");
        Direccion dx = new Direccion();
        dx.setLocalidad(loc);
        dx.setCalle("xxx");
        dx.setAltura(550);
        dx.setNumDepto(10);
        in.setDireccion(dx);
        this.getGestor().guardarObjeto(in);

        InstitucionEducativa i = new InstitucionEducativa();
        i.setNombre("Rivadabia");
        Direccion d = new Direccion();
        d.setLocalidad(loc);
        d.setCalle("Mendoza");
        d.setAltura(550);
        d.setNumDepto(10);
        i.setDireccion(d);
        this.getGestor().guardarObjeto(i);

        System.out.println("Colegios is ready...");

    }

    public void cargarTurnos() {
        Turno t = new Turno();
        t.setNombre("Mañana");
        t.setDescripcion("");

        this.getGestor().guardarObjeto(t);

        Turno t1 = new Turno();
        t1.setNombre("Tarde");
        t1.setDescripcion("");

        this.getGestor().guardarObjeto(t1);
        System.out.println("Turnos is ready...");
    }

    public void cargarCategorias() {
        Categoria c = new Categoria();
        c.setNombre("Comedia Musical");

        this.getGestor().guardarObjeto(c);
        Categoria c1 = new Categoria();
        c1.setNombre("Clasico");
        this.getGestor().guardarObjeto(c1);
        Categoria c2 = new Categoria();
        c2.setNombre("Salsa");
        this.getGestor().guardarObjeto(c2);
        System.out.println("Categorias is ready...");

    }
    
    public void cargarEstados(){
        Estado e = new Estado();
        e.setNombre("Vigente");
        e.setAmbito("inscripcion");
        e.setDescripcion("");
        this.getGestor().guardarObjeto(e);
        
        Estado e1 = new Estado();
        e1.setNombre("Finalizada");
        e1.setAmbito("inscripcion");
        e1.setDescripcion("");
        this.getGestor().guardarObjeto(e1);
        
        Estado e2 = new Estado();
        e2.setNombre("Cancelada");
        e2.setAmbito("inscripcion");
        e2.setDescripcion("");
        this.getGestor().guardarObjeto(e2);
        
        //Cuota
        Estado e3 = new Estado();
        e3.setNombre("Pendiente");
        e3.setAmbito("cuota");
        e3.setDescripcion("");
        this.getGestor().guardarObjeto(e3);
        
         Estado e4 = new Estado();
        e4.setNombre("Paga");
        e4.setAmbito("cuota");
        e4.setDescripcion("");
        this.getGestor().guardarObjeto(e4);
       
        Estado e5 = new Estado();
        e5.setNombre("Vencida");
        e5.setAmbito("cuota");
        e5.setDescripcion("");
        this.getGestor().guardarObjeto(e5);
        
        Estado e6 = new Estado();
        e6.setNombre("Cancelada");
        e6.setAmbito("cuota");
        e6.setDescripcion("");
        this.getGestor().guardarObjeto(e6);

    }
}
