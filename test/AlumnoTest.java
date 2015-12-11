/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.GestorConsultas;
import hibernate.GestorHibernate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import models.alumno.Alumno;
import models.alumno.GestorAlumno;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.identificacion.TipoDocumento;
import models.telefono.Telefono;
import models.telefono.TipoTelefono;
import models.tutor.Tutor;
import models.ubicacion.Direccion;
import models.ubicacion.Localidad;
import models.ubicacion.Pais;
import models.ubicacion.Provincia;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author emiliano
 */
public class AlumnoTest {

    public AlumnoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hibernate.HibernateUtil.inicializar();
        GestorHibernate gh = new GestorHibernate();
        TipoDocumento t = new TipoDocumento();
        t.setNombre("Tipo Test");
        gh.guardarObjeto(t);

        GrupoSanguineo g = new GrupoSanguineo();
        g.setFactor("factor test");
        g.setTipo("tipo test");
        gh.guardarObjeto(g);

        Pais p = new Pais();
        p.setNombre("Pais test");

        Provincia prov = new Provincia();
        prov.setPais(p);
        prov.setNombre("Provincia test");

        Localidad loc = new Localidad();
        loc.setProvincia(prov);
        loc.setNombre("Localidad test");

        gh.guardarObjeto(loc);

        TipoTelefono tip = new TipoTelefono();
        tip.setNombre("Tipo tel test");
        gh.guardarObjeto(tip);
    }

    @After
    public void tearDown() {
        //clearAlumno();
    }

    @Test
    public void testInsert() {
        //clearAlumno();

        GestorAlumno ges = new GestorAlumno();
        ges.getModel().setNombre("Pedro");
        ges.getModel().setApellido("Lopez");
        ges.getModel().setEmail("p@lopez.com");
        Documento d = new Documento();
        d.setNumero("58963256");
        GestorConsultas gestor1 = new GestorConsultas(TipoDocumento.class, "tipodocumento");
        gestor1.addRestriccion("nombre", "Tipo Test");
        TipoDocumento t = (TipoDocumento) gestor1.resultConsulta().get(0);
        d.setTipo(t);
        ges.getModel().setDocumento(d);
        ges.getModel().setFechaNacimiento(new Date());

        Direccion dir = new Direccion();
        GestorConsultas gestor2 = new GestorConsultas(Localidad.class, "localidad");
        gestor2.addRestriccion("nombre", "Localidad test");
        Localidad loc = (Localidad) gestor2.resultConsulta().get(0);
        dir.setLocalidad(loc);
        dir.setAltura(0);
        dir.setNumDepto(0);
        dir.setPiso(0);
        dir.setCalle("calle test");
        ges.getModel().setDireccion(dir);

        GestorConsultas gestor3 = new GestorConsultas(GrupoSanguineo.class, "grupo");
        gestor3.addRestriccion("tipo", "tipo test");
        GrupoSanguineo gro = (GrupoSanguineo) gestor3.resultConsulta().get(0);

        ges.getModel().setGrupoSanguineo(gro);

        GestorConsultas gestor4 = new GestorConsultas(TipoTelefono.class, "TipoTelefono");
        gestor4.addRestriccion("nombre", "Tipo tel test");
        TipoTelefono tip = (TipoTelefono) gestor4.resultConsulta().get(0);
        Set<Telefono> set = new HashSet<Telefono>();
        Telefono tel = new Telefono();
        tel.setTipo(tip);
        tel.setNumero("0536589741");
        tel.setCaracteristica("0353");
        set.add(tel);
        ges.getModel().setTelefonos(set);

        Tutor tuto = new Tutor();
        tuto.setDireccion(dir);
        tuto.setNombre("Test");
        tuto.setApellido("test");
        ges.getModel().setTutor(tuto);

        ges.guardar();

        GestorConsultas gestor5 = new GestorConsultas(Alumno.class, "alumno");
        gestor5.addRestriccion("nombre", "Pedro");
        gestor5.addRestriccion("apellido", "Lopez");
        Alumno alum = (Alumno) gestor5.resultConsulta().get(0);

        assertEquals(alum.getNombre(), "Pedro");
        assertEquals(alum.getApellido(), "Lopez");
        assertEquals(alum.getDocumento().getNumero(), "58963256");

    }

    @Test
    public void testUpdate() {
        // clearAlumno();

        GestorAlumno ges = new GestorAlumno();
        ges.getModel().setNombre("Pedro");
        ges.getModel().setApellido("Lopez");
        ges.getModel().setEmail("p@lopez.com");
        Documento d = new Documento();
        d.setNumero("58963256");
        GestorConsultas gestor1 = new GestorConsultas(TipoDocumento.class, "tipodocumento");
        gestor1.addRestriccion("nombre", "Tipo Test");
        TipoDocumento t = (TipoDocumento) gestor1.resultConsulta().get(0);
        d.setTipo(t);
        ges.getModel().setDocumento(d);
        ges.getModel().setFechaNacimiento(new Date());

        Direccion dir = new Direccion();
        GestorConsultas gestor2 = new GestorConsultas(Localidad.class, "localidad");
        gestor2.addRestriccion("nombre", "Localidad test");
        Localidad loc = (Localidad) gestor2.resultConsulta().get(0);
        dir.setLocalidad(loc);
        dir.setAltura(0);
        dir.setNumDepto(0);
        dir.setPiso(0);
        dir.setCalle("calle test");
        ges.getModel().setDireccion(dir);

        GestorConsultas gestor3 = new GestorConsultas(GrupoSanguineo.class, "grupo");
        gestor3.addRestriccion("tipo", "tipo test");
        GrupoSanguineo gro = (GrupoSanguineo) gestor3.resultConsulta().get(0);

        ges.getModel().setGrupoSanguineo(gro);

        GestorConsultas gestor4 = new GestorConsultas(TipoTelefono.class, "TipoTelefono");
        gestor4.addRestriccion("nombre", "Tipo tel test");
        TipoTelefono tip = (TipoTelefono) gestor4.resultConsulta().get(0);
        Set<Telefono> set = new HashSet<Telefono>();
        Telefono tel = new Telefono();
        tel.setTipo(tip);
        tel.setNumero("0536589741");
        tel.setCaracteristica("0353");
        set.add(tel);
        ges.getModel().setTelefonos(set);

        Tutor tuto = new Tutor();
        tuto.setDireccion(dir);
        tuto.setNombre("Test");
        tuto.setApellido("test");
        ges.getModel().setTutor(tuto);

        ges.guardar();

        GestorConsultas gestor5 = new GestorConsultas(Alumno.class, "alumno");
        gestor5.addRestriccion("nombre", "Pedro");
        gestor5.addRestriccion("apellido", "Lopez");
        Alumno alum = (Alumno) gestor5.resultConsulta().get(0);

        assertEquals(alum.getNombre(), "Pedro");
        assertEquals(alum.getApellido(), "Lopez");
        assertEquals(alum.getDocumento().getNumero(), "58963256");

        ges.getModel().setNombre("Raul");
        ges.getModel().setApellido("Juarez");

        ges.actuailizar();

        GestorConsultas gestor6 = new GestorConsultas(Alumno.class, "alumno");
        gestor6.addRestriccion("nombre", "Raul");
        gestor6.addRestriccion("apellido", "Juarez");
        Alumno alum2 = (Alumno) gestor6.resultConsulta().get(0);

        assertEquals(alum2.getNombre(), "Raul");
        assertEquals(alum2.getApellido(), "Juarez");

    }

    @Test
    public void testDelete() {
        GestorAlumno ges = new GestorAlumno();
        ges.getModel().setNombre("Pedro");
        ges.getModel().setApellido("Lopez");
        ges.getModel().setEmail("p@lopez.com");
        Documento d = new Documento();
        d.setNumero("58963256");
        GestorConsultas gestor1 = new GestorConsultas(TipoDocumento.class, "tipodocumento");
        gestor1.addRestriccion("nombre", "Tipo Test");
        TipoDocumento t = (TipoDocumento) gestor1.resultConsulta().get(0);
        d.setTipo(t);
        ges.getModel().setDocumento(d);
        ges.getModel().setFechaNacimiento(new Date());

        Direccion dir = new Direccion();
        GestorConsultas gestor2 = new GestorConsultas(Localidad.class, "localidad");
        gestor2.addRestriccion("nombre", "Localidad test");
        Localidad loc = (Localidad) gestor2.resultConsulta().get(0);
        dir.setLocalidad(loc);
        dir.setAltura(0);
        dir.setNumDepto(0);
        dir.setPiso(0);
        dir.setCalle("calle test");
        ges.getModel().setDireccion(dir);

        GestorConsultas gestor3 = new GestorConsultas(GrupoSanguineo.class, "grupo");
        gestor3.addRestriccion("tipo", "tipo test");
        GrupoSanguineo gro = (GrupoSanguineo) gestor3.resultConsulta().get(0);

        ges.getModel().setGrupoSanguineo(gro);

        GestorConsultas gestor4 = new GestorConsultas(TipoTelefono.class, "TipoTelefono");
        gestor4.addRestriccion("nombre", "Tipo tel test");
        TipoTelefono tip = (TipoTelefono) gestor4.resultConsulta().get(0);
        Set<Telefono> set = new HashSet<Telefono>();
        Telefono tel = new Telefono();
        tel.setTipo(tip);
        tel.setNumero("0536589741");
        tel.setCaracteristica("0353");
        set.add(tel);
        ges.getModel().setTelefonos(set);

        Tutor tuto = new Tutor();
        tuto.setDireccion(dir);
        tuto.setNombre("Test");
        tuto.setApellido("test");
        ges.getModel().setTutor(tuto);

        ges.guardar();

        GestorConsultas gestor5 = new GestorConsultas(Alumno.class, "alumno");
        gestor5.addRestriccion("nombre", "Pedro");
        gestor5.addRestriccion("apellido", "Lopez");
        gestor5.addFiltroInt("estado", 0);
        Alumno alum = (Alumno) gestor5.resultConsulta().get(0);

        assertEquals(alum.getNombre(), "Pedro");
        assertEquals(alum.getApellido(), "Lopez");
        assertEquals(alum.getDocumento().getNumero(), "58963256");

        ges.eliminar();

        GestorConsultas gestor6 = new GestorConsultas(Alumno.class, "alumno");
        gestor6.addRestriccion("nombre", "Pedro");
        gestor6.addRestriccion("apellido", "Lopez");
        gestor6.addFiltroInt("estado", 1);

        Alumno alum2 = (Alumno) gestor6.resultConsulta().get(0);

        assertEquals(alum2.getNombre(), "Pedro");
        assertEquals(alum2.getApellido(), "Lopez");
        assertEquals(alum2.getEstado(), 1);

    }

    public void clearAlumno() {
        GestorConsultas gestor5 = new GestorConsultas(Alumno.class, "alumno");
        gestor5.addRestriccion("nombre", "Pedro");
        gestor5.addRestriccion("apellido", "Lopez");
        GestorHibernate g = new GestorHibernate();
        if (!gestor5.resultConsulta().isEmpty()) {

            Iterator it = gestor5.resultConsulta().iterator();
            Alumno a;
            while (it.hasNext()) {
                a = (Alumno) it.next();
                g.eliminarObjeto(a.getDocumento());
                g.eliminarObjeto(a.getDocumento().getTipo());

                g.eliminarObjeto(a.getTutor());
                g.eliminarObjeto(a.getDireccion());
                Iterator it2 = a.getTelefonos().iterator();
                Telefono t;
                while (it2.hasNext()) {
                    t = (Telefono) it2.next();
                    g.eliminarObjeto(t);
                }
                g.eliminarObjeto(a);

            }

        }
    }
}
