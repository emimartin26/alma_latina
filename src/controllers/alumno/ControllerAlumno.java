/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.alumno;

import Utilidades.GestorCombo;
import Utilidades.GestorLista;
import Utilidades.Util;
import com.toedter.calendar.JDateChooser;
import controllers.Controller;
import controllers.GestorConsultas;
import java.awt.Color;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.text.JTextComponent;
import models.alumno.GestorAlumno;
import models.atencionMedica.Alergia;
import models.atencionMedica.GestorAlergia;
import models.atencionMedica.GestorTratamiento;
import models.atencionMedica.Tratamiento;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.identificacion.GestorTipoDocumento;
import models.identificacion.TipoDocumento;
import models.inscripcion.Categoria;
import models.institucion.InstitucionEducativa;
import models.institucion.InstitucionPorAlumno;
import models.institucion.Turno;
import models.mutual.Mutual;
import models.telefono.Telefono;
import models.tutor.GestorTutor;
import models.tutor.Tutor;
import models.ubicacion.Direccion;
import models.ubicacion.GestorLocalidad;
import models.ubicacion.Localidad;
import views.FrmAlumno;

/**
 *
 * @author emiliano
 */
public class ControllerAlumno extends Controller {

    private GestorAlumno gestorAlumno;
    private ControllerTelefono controllerTelefono;
    private ControllerLocalidad controllerLocalidad;

    public ControllerAlumno(JDesktopPane escritorio) {
        this.setEscritorio(escritorio);
        this.setFrame(new FrmAlumno(this));
        this.gestorAlumno = new GestorAlumno();
    }

    public GestorAlumno getGestorAlumno() {
        return gestorAlumno;
    }

    public void setGestorAlumno(GestorAlumno model) {
        this.gestorAlumno = model;
    }

    public void crearControllerAlumno() {
        this.gestorAlumno = new GestorAlumno();
        this.controllerTelefono = new ControllerTelefono(this.getFormularioEspecifico());
        this.controllerLocalidad = new ControllerLocalidad(this.getFormularioEspecifico());
    }

    public ControllerLocalidad getControllerLocalidad() {
        return controllerLocalidad;
    }

    public ControllerTelefono getControllerTelefono() {
        return controllerTelefono;
    }

    public void setControllerLocalidad(ControllerLocalidad controllerLocalidad) {
        this.controllerLocalidad = controllerLocalidad;
    }

    public void setControllerTelefono(ControllerTelefono controllerTelefono) {
        this.controllerTelefono = controllerTelefono;
    }

    public FrmAlumno getFormularioEspecifico() {
        return (FrmAlumno) this.getFrame(); //Casteo de JiInternalFrame(Padre) a FrmAlumno(Hijo)

    }

    public void cargar() {
        this.abrir();
        this.crearControllerAlumno();
        this.inicializarDatos();
    }

    public void cargarFromListAlumno() {
        this.abrir();
        this.cargarTiposDocumentos();
        this.controllerTelefono = new ControllerTelefono(this.getFormularioEspecifico());
        this.controllerLocalidad = new ControllerLocalidad(this.getFormularioEspecifico());
        this.inicializarDatos();
        this.initDataMod();
    }

    public void llenarList(Set set, JList listInterfaz) {
        DefaultListModel model = new DefaultListModel();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            model.addElement(it.next());
        }

        listInterfaz.setModel(model);

    }

    public void initDataMod() {
        GestorLista gestorLista = new GestorLista();
        ///
        this.getFormularioEspecifico().getTxtNombre().setText(this.getGestorAlumno().getModel().getNombre());
        this.getFormularioEspecifico().getTxtApellido().setText(this.getGestorAlumno().getModel().getApellido());
        this.getFormularioEspecifico().getTxtEmail().setText(this.getGestorAlumno().getModel().getEmail());
        this.getFormularioEspecifico().getDateFechaNacimiento().setDate(this.getGestorAlumno().getModel().getFechaNacimiento());
        this.getFormularioEspecifico().getTxtDni().setText(this.getGestorAlumno().getModel().getDocumento().getNumero());
        this.getFormularioEspecifico().getCmbTipoDni().setSelectedItem(this.getGestorAlumno().getModel().getDocumento().getTipo());
        this.llenarList(this.getGestorAlumno().getTelefonos(), this.getFormularioEspecifico().getLstNumerosTelefono());
        this.getFormularioEspecifico().getCmbLocalidad().setSelectedItem(this.getGestorAlumno().getModel().getDireccion().getLocalidad());
        this.getFormularioEspecifico().getTxtCalle().setText(this.getGestorAlumno().getModel().getDireccion().getCalle());
        this.getFormularioEspecifico().getTxtAlturaCalle().setText(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getAltura()));
        this.getFormularioEspecifico().getTxtPisoDepto().setText(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getPiso()));
        this.getFormularioEspecifico().getTxtNumDepto().setText(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getNumDepto()));
        this.getFormularioEspecifico().getCmbGrupoSan().setSelectedItem(this.getGestorAlumno().getModel().getGrupoSanguineo());
        this.getFormularioEspecifico().getCmbMutual().setSelectedItem(this.getGestorAlumno().getModel().getMutual());
        this.getFormularioEspecifico().getCmbColegio().setSelectedItem(this.getGestorAlumno().getModel().getInstitucionPorAlumno().getInstitucionEductiva());
        this.getFormularioEspecifico().getCmbTurno().setSelectedItem(this.getGestorAlumno().getModel().getInstitucionPorAlumno().getTurno());
        this.llenarList(this.getGestorAlumno().getModel().getTratamientos(), this.getFormularioEspecifico().getListTratamientos());
        this.llenarList(this.getGestorAlumno().getModel().getAlergias(), this.getFormularioEspecifico().getListAlergias());
        this.getFormularioEspecifico().getTextObs().setText(this.getGestorAlumno().getModel().getObservaciones());

        this.getFormularioEspecifico().getCmbLocalidadTutor().setSelectedItem(this.getGestorAlumno().getModel().getTutor().getDireccion().getLocalidad());
        this.getFormularioEspecifico().getTxtCalleTutor().setText(this.getGestorAlumno().getModel().getTutor().getDireccion().getCalle());
        this.getFormularioEspecifico().getTxtNumDeptoTutor().setText(String.valueOf(this.getGestorAlumno().getModel().getTutor().getDireccion().getNumDepto()));
        this.getFormularioEspecifico().getTxtAlturaCalleTutor().setText(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getNumDepto()));
        this.getFormularioEspecifico().getTxtPisoDeptoTutor().setText(String.valueOf(this.getGestorAlumno().getModel().getTutor().getDireccion().getPiso()));

        this.getFormularioEspecifico().getTxtNombreTutor().setText(this.getGestorAlumno().getModel().getTutor().getNombre());
        this.getFormularioEspecifico().getTxtApellidoTutor().setText(this.getGestorAlumno().getModel().getTutor().getApellido());
        if (this.getGestorAlumno().getModel().getTutor().getDireccion().getLocalidad().equals(this.getGestorAlumno().getModel().getDireccion().getLocalidad())
                & this.getGestorAlumno().getModel().getTutor().getDireccion().getCalle().equals(this.getGestorAlumno().getModel().getDireccion().getCalle())
                & String.valueOf(this.getGestorAlumno().getModel().getTutor().getDireccion().getAltura()).equals(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getAltura()))
                & String.valueOf(this.getGestorAlumno().getModel().getDireccion().getNumDepto()).equals(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getNumDepto()))
                & String.valueOf(this.getGestorAlumno().getModel().getTutor().getDireccion().getPiso()).equals(String.valueOf(this.getGestorAlumno().getModel().getDireccion().getPiso()))) {
            this.getFormularioEspecifico().getCheckAlumna().setSelected(true);
            this.blockFieldTutor(false);
        }

//        this.getFormularioEspecifico().
//        
//        this.getGestorAlumno().setNombre(nombre);
//        this.getGestorAlumno().setApellido(apellido);
//        this.getGestorAlumno().setEmail(email);
//        this.getGestorAlumno().setFechaNac(fechaNacimiento);
//        this.getGestorAlumno().setDocumento(this.getDocumento());
//        this.getGestorAlumno().setTelefonos(this.getTelefonos());
//        this.getGestorAlumno().setDireccion(this.getDireccion());
//        this.getGestorAlumno().setGrupoSanguineo(this.getGrupoSanguineo());
//        this.getGestorAlumno().setMutual(this.getMutual());
//        this.getGestorAlumno().setInstitucionPorAlumno(this.getInstitucionPorAlumno());
//        this.getGestorAlumno().setAlergia(this.getAlergias());
//        this.getGestorAlumno().setTratamientos(this.getTratamientos());
//        this.getGestorAlumno().setObservaciones(obsevarciones);
//        this.getGestorAlumno().setTutor(this.getTutor());
    }

    public void abrir() {
        this.getEscritorio().add(this.getFrame());
        this.getFrame().setVisible(true);
    }

    public boolean isEmptyTxt(JTextComponent c) {
        if (Util.estaVacioTxt(c)) {
            c.setBackground(Color.PINK);
            return false;
        }
        c.setBackground(Color.GREEN);
        return true;
    }

    public boolean validateDate(JDateChooser j) {
        if (null == j.getDate()) {
            new Util().getMensajeError("Verifique fecha de nacimiento");
            return false;
        }
        return true;

    }

    public boolean isListItem(JList j, String msg) {
        if (j.getModel().getSize() == 0) {
            new Util().getMensajeError(msg);
            return false;
        }
        return true;
    }

    public boolean isSelectCombo(JComboBox c) {
        if (!(Util.estaSeleccionadoCombo(c))) {
            c.setBackground(Color.PINK);
            return false;
        }
        c.setBackground(Color.GREEN);
        return true;
    }

    public boolean validarDatos() {
        return (isEmptyTxt(this.getFormularioEspecifico().getTxtApellido())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtNombre())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtCalle())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtAlturaCalle())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtAlturaCalleTutor())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtCalleTutor())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtApellidoTutor())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtNombreTutor())
                & isSelectCombo(this.getFormularioEspecifico().getCmbTipoDni())
                & isSelectCombo(this.getFormularioEspecifico().getCmbLocalidad())
                & isSelectCombo(this.getFormularioEspecifico().getCmbLocalidadTutor())
                & isEmptyTxt(this.getFormularioEspecifico().getTxtDni())
                & isListItem(this.getFormularioEspecifico().getLstNumerosTelefono(), "Ingrese al menos un numero de telefono")
                & validateDate(this.getFormularioEspecifico().getDateFechaNacimiento()));
    }

    public void getDatos() {
        if (validarDatos()) {
            String nombre = this.getFormularioEspecifico().getTxtNombre().getText();
            String apellido = this.getFormularioEspecifico().getTxtApellido().getText();
            String email = this.getFormularioEspecifico().getTxtEmail().getText();
            Date fechaNacimiento = (Date) this.getFormularioEspecifico().getDateFechaNacimiento().getDate();
            String obsevarciones = this.getFormularioEspecifico().getTextObs().getText();
            this.getGestorAlumno().crearModelo();
            this.getGestorAlumno().setNombre(nombre);
            this.getGestorAlumno().setApellido(apellido);
            this.getGestorAlumno().setEmail(email);
            this.getGestorAlumno().setFechaNac(fechaNacimiento);
            this.getGestorAlumno().setDocumento(this.getDocumento());
            this.getGestorAlumno().setTelefonos(this.getTelefonos());
            this.getGestorAlumno().setDireccion(this.getDireccion());
            this.getGestorAlumno().setGrupoSanguineo(this.getGrupoSanguineo());
            this.getGestorAlumno().setMutual(this.getMutual());
            this.getGestorAlumno().setInstitucionPorAlumno(this.getInstitucionPorAlumno());
            this.getGestorAlumno().setAlergia(this.getAlergias());
            this.getGestorAlumno().setTratamientos(this.getTratamientos());
            this.getGestorAlumno().setObservaciones(obsevarciones);
            this.getGestorAlumno().setTutor(this.getTutor());

            this.getGestorAlumno().guardar();
            this.getFormularioEspecifico().setVisible(false);
            int opcion = new Util().confirmacion("¿Desea crear un nuevo alumno?");
            if (opcion == JOptionPane.YES_OPTION) {
                ControllerAlumno controller = new ControllerAlumno(this.getEscritorio());
                controller.cargar();
            }
        } else {
            System.out.println("No son validos");
        }

    }

    public Mutual getMutual() {

        return (Mutual) this.getFormularioEspecifico().getCmbMutual().getSelectedItem();
    }

    public Documento getDocumento() {
        Documento doc = new Documento();
        doc.setNumero(this.getFormularioEspecifico().getTxtDni().getText());
        doc.setTipo(this.getTipoDocumento());
        return doc;
    }

    public Set<Telefono> getTelefonos() {
        ListModel model = this.getFormularioEspecifico().getLstNumerosTelefono().getModel();
        return this.cargarModelTelefonos(model);

    }

    public Set<Tratamiento> getTratamientos() {
        ListModel modelTratamiento = this.getFormularioEspecifico().getListTratamientos().getModel();
        return this.cargarModelTratamientos(modelTratamiento);
    }

    public Set<Alergia> getAlergias() {
        ListModel modelAlergias = this.getFormularioEspecifico().getListAlergias().getModel();
        return this.cargarModelAlergias(modelAlergias);
    }

    public InstitucionPorAlumno getInstitucionPorAlumno() {
        InstitucionPorAlumno institucion = new InstitucionPorAlumno();
        institucion.setDescripcion("");
        institucion.setInstitucionEductiva(this.getInstitucion());
        institucion.setTurno(this.getTurno());
        return institucion;
    }

    public Direccion getDireccion() {
        Localidad loc = (Localidad) this.getFormularioEspecifico().getCmbLocalidad().getSelectedItem();
        Direccion dir = new Direccion();
        dir.setLocalidad(loc);
        dir.setCalle(this.getFormularioEspecifico().getTxtCalle().getText());
        dir.setAltura(Integer.parseInt(this.getFormularioEspecifico().getTxtAlturaCalle().getText()));
        if (Util.estaVacioTxt(this.getFormularioEspecifico().getTxtPisoDepto())) {
            dir.setPiso(0);

        } else {
            dir.setPiso(Integer.parseInt(this.getFormularioEspecifico().getTxtPisoDepto().getText()));
        }
        if (Util.estaVacioTxt(this.getFormularioEspecifico().getTxtNumDepto())) {
            dir.setNumDepto(0);
        } else {
            dir.setNumDepto(Integer.parseInt(this.getFormularioEspecifico().getTxtNumDepto().getText()));

        }
        return dir;
    }

    public Direccion getDireccionTutor() {
        Localidad loc = (Localidad) this.getFormularioEspecifico().getCmbLocalidadTutor().getSelectedItem();
        Direccion dir = new Direccion();
        dir.setLocalidad(loc);
        dir.setCalle(this.getFormularioEspecifico().getTxtCalleTutor().getText());
        dir.setAltura(Integer.parseInt(this.getFormularioEspecifico().getTxtAlturaCalleTutor().getText()));
        if (Util.estaVacioTxt(this.getFormularioEspecifico().getTxtPisoDepto())) {
            dir.setPiso(0);

        } else {
            dir.setPiso(Integer.parseInt(this.getFormularioEspecifico().getTxtPisoDepto().getText()));
        }
        if (Util.estaVacioTxt(this.getFormularioEspecifico().getTxtNumDepto())) {
            dir.setNumDepto(0);
        } else {
            dir.setNumDepto(Integer.parseInt(this.getFormularioEspecifico().getTxtNumDepto().getText()));

        }
        return dir;
    }

    public Tutor getTutor() {
        GestorTutor t = new GestorTutor();
        t.setNombre(this.getFormularioEspecifico().getTxtNombreTutor().getText());
        t.setApellido(this.getFormularioEspecifico().getTxtApellidoTutor().getText());
        t.setDireccion(this.getDireccionTutor());
        return t.getModel();
    }

    public Set<Telefono> cargarModelTelefonos(ListModel telefonos) {
        HashSet array = new <Telefono> HashSet();
        for (int i = 0; i < telefonos.getSize(); i++) {
            array.add(telefonos.getElementAt(i));
        }
        return array;
    }

    public Set<Alergia> cargarModelAlergias(ListModel alergias) {
        HashSet array = new <Alergia> HashSet();
        for (int i = 0; i < alergias.getSize(); i++) {
            array.add(alergias.getElementAt(i));
        }
        return array;
    }

    public Set<Tratamiento> cargarModelTratamientos(ListModel trat) {
        HashSet array = new <Tratamiento> HashSet();
        for (int i = 0; i < trat.getSize(); i++) {
            array.add(trat.getElementAt(i));
        }
        return array;
    }

    public Turno getTurno() {
        return (Turno) this.getFormularioEspecifico().getCmbTurno().getSelectedItem();

    }

    public InstitucionEducativa getInstitucion() {
        return (InstitucionEducativa) this.getFormularioEspecifico().getCmbColegio().getSelectedItem();

    }

    public GrupoSanguineo getGrupoSanguineo() {
        return (GrupoSanguineo) this.getFormularioEspecifico().getCmbGrupoSan().getSelectedItem();
    }

    public TipoDocumento getTipoDocumento() {
        return (TipoDocumento) this.getFormularioEspecifico().getCmbTipoDni().getSelectedItem();
    }

    public void addAlergia() {
        if (this.validAddAler()) {
            String alergia = this.getFormularioEspecifico().getTxtNombreAlergia().getText();
            GestorAlergia g = new GestorAlergia();
            g.setNombre(alergia);
            this.addAlerListAlerg(g.getModel());

        }

    }

    public void removeAlergia() {
        if (!this.validRemoveAler()) {
            GestorLista gestorLista = new GestorLista();
            DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListAlergias().getModel());
            defaultListModel.remove(this.getFormularioEspecifico().getListAlergias().getSelectedIndex());
            gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListAlergias());
        } else {
            new Util().getMensajeError("No ha seleccionado nada");
        }

    }

    public void addAlerListAlerg(Alergia a) {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListAlergias().getModel());
        defaultListModel.addElement(a);
        gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListAlergias());
    }

    public void addTratamiento() {
        if (this.validAddTrat()) {
            String trat = this.getFormularioEspecifico().getTxtNombreTratamiento().getText();
            GestorTratamiento g = new GestorTratamiento();
            g.setNombre(trat);
            this.addTratListTrat(g.getModel());
        }

    }

    public void removeTratamiento() {
        if (!this.validRemoveTrat()) {
            GestorLista gestorLista = new GestorLista();
            DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListTratamientos().getModel());
            defaultListModel.remove(this.getFormularioEspecifico().getListTratamientos().getSelectedIndex());
            gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListTratamientos());
        } else {
            new Util().getMensajeError("No ha seleccionado nada");

        }

    }

    public void addTratListTrat(Tratamiento t) {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListTratamientos().getModel());
        defaultListModel.addElement(t);
        gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListTratamientos());
    }

    public boolean validAddTel() {
        return isEmptyTxt(this.getFormularioEspecifico().getTxtCaractTelefono()) & isEmptyTxt(this.getFormularioEspecifico().getTxtNumTelefono());
    }

    public boolean validAddTrat() {
        return isEmptyTxt(this.getFormularioEspecifico().getTxtNombreTratamiento());
    }

    public boolean validAddAler() {
        return isEmptyTxt(this.getFormularioEspecifico().getTxtNombreAlergia());
    }

    public boolean validRemoveTel() {
        return this.getFormularioEspecifico().getLstNumerosTelefono().isSelectionEmpty();
    }

    public boolean validRemoveTrat() {
        return this.getFormularioEspecifico().getListTratamientos().isSelectionEmpty();
    }

    public boolean validRemoveAler() {
        return this.getFormularioEspecifico().getListAlergias().isSelectionEmpty();
    }

    public void addTelefono() {
        if (validAddTel()) {
            this.getControllerTelefono().addTelefono();
        }

    }

    public void removeTelefono() {
        if (!validRemoveTel()) {
            this.getControllerTelefono().removeTelefono();
        } else {
            new Util().getMensajeError("No ha seleccionado nada");
        }

    }

    public void addCategoria() {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListCategoria().getModel());
        if (!(defaultListModel.contains(this.getCategoria()))) {
            defaultListModel.addElement(this.getCategoria());
            gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListCategoria());

        }
    }

    public Categoria getCategoria() {
        return (Categoria) this.getFormularioEspecifico().getCmbCategoria().getSelectedItem();
    }

    public void removeCategoria() {
        GestorLista gestorLista = new GestorLista();
        DefaultListModel defaultListModel = gestorLista.getDefaultListModelBaseListModel(this.getFormularioEspecifico().getListCategoria().getModel());
        defaultListModel.remove(this.getFormularioEspecifico().getListCategoria().getSelectedIndex());
        gestorLista.llenarListBaseModel(defaultListModel, this.getFormularioEspecifico().getListCategoria());
    }

    public void cargarLocalidades() {

        this.getControllerLocalidad().cargarLocalidades();
    }

    public void cargarTiposDocumentos() {
        JComboBox cmbTiposDoc = this.getFormularioEspecifico().getCmbTipoDni();
        GestorTipoDocumento g = new GestorTipoDocumento();
        List tipos = g.getTiposDoc();
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(tipos, cmbTiposDoc, true);

    }

    public void cargarGruposSanguineos() {
        GestorConsultas g = new GestorConsultas(GrupoSanguineo.class, "grupo");
        JComboBox cbmGruposSang = this.getFormularioEspecifico().getCmbGrupoSan();
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(g.resultConsulta(), cbmGruposSang, true);
    }

    public void cargarMutuales() {
        GestorConsultas g = new GestorConsultas(Mutual.class, "mutual");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(g.resultConsulta(), this.getFormularioEspecifico().getCmbMutual(), false);
    }

    public void cargarInstituciones() {
        GestorConsultas g = new GestorConsultas(InstitucionEducativa.class, "institucion");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(g.resultConsulta(), this.getFormularioEspecifico().getCmbColegio(), false);
    }

    public void cargarTurnos() {
        GestorConsultas g = new GestorConsultas(Turno.class, "turno");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(g.resultConsulta(), this.getFormularioEspecifico().getCmbTurno(), false);
    }

    public void cargarCategorias() {
        GestorConsultas g = new GestorConsultas(Categoria.class, "categoria");
        GestorCombo ges = new GestorCombo();
        ges.cargarCombo(g.resultConsulta(), this.getFormularioEspecifico().getCmbCategoria(), true);
    }

    public void inicializarDatos() {
        this.cargarLocalidades();
        this.cargarTiposDocumentos();
        this.cargarGruposSanguineos();
        this.cargarMutuales();
        this.cargarInstituciones();
        this.cargarTurnos();
        this.cargarCategorias();
    }

    public void eventChek() {
        if (this.getFormularioEspecifico().getCheckAlumna().isSelected()) {
            this.blockFieldTutor(false);
            Localidad loc = (Localidad) this.getFormularioEspecifico().getCmbLocalidad().getSelectedItem();
            this.getFormularioEspecifico().getCmbLocalidadTutor().setSelectedItem(loc);
            this.getFormularioEspecifico().getTxtCalleTutor().setText(this.getFormularioEspecifico().getTxtCalle().getText());
            this.getFormularioEspecifico().getTxtAlturaCalleTutor().setText(this.getFormularioEspecifico().getTxtAlturaCalle().getText());
            this.getFormularioEspecifico().getTxtPisoDeptoTutor().setText(this.getFormularioEspecifico().getTxtPisoDepto().getText());
            this.getFormularioEspecifico().getTxtNumDeptoTutor().setText(this.getFormularioEspecifico().getTxtNumDepto().getText());
        } else {
            this.blockFieldTutor(true);
            this.getFormularioEspecifico().getCmbLocalidadTutor().setSelectedIndex(0);
            this.getFormularioEspecifico().getTxtCalleTutor().setText("");
            this.getFormularioEspecifico().getTxtAlturaCalleTutor().setText("");
            this.getFormularioEspecifico().getTxtPisoDeptoTutor().setText("");
            this.getFormularioEspecifico().getTxtNumDeptoTutor().setText("");
        }
    }

    public void blockFieldTutor(boolean b) {
        this.getFormularioEspecifico().getCmbLocalidadTutor().setEnabled(b);
        this.getFormularioEspecifico().getTxtCalleTutor().setEnabled(b);
        this.getFormularioEspecifico().getTxtAlturaCalleTutor().setEnabled(b);
        this.getFormularioEspecifico().getTxtPisoDeptoTutor().setEnabled(b);
        this.getFormularioEspecifico().getTxtNumDeptoTutor().setEnabled(b);
    }

}
