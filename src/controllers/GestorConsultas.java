/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Emiliano
 */
public class GestorConsultas {

    private Session session;
    private Criteria crit;
    private Class clase;

    /**
     *
     * En el constructor se pasa como parametro la clase sobre la cual vamos
     * hacer consultas y se setea la sesion global y sobre esa sesion se crea un
     * criterio.
     * @param clase
     * @param alias
     */
    public GestorConsultas(Class clase, String alias) {
        this.setSession(HibernateUtil.getSession());
        this.setCrit(this.crearCriterio(clase,alias));
        //this.restriccionNoBorrado();
    }

    /**
     *
     * Crea un criterio de busqueda sobre la sesion global.
     */
    private Criteria crearCriterio(Class clase, String alias) {
        return this.getSession().createCriteria(clase, alias);
    }

    private Session getSession() {
        return session;
    }

    private void setSession(Session session) {
        this.session = session;
    }

    public Criteria getCrit() {
        return crit;
    }

    private void setCrit(Criteria crit) {
        this.crit = crit;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }

    /**
     *
     * Se le agrega al criterio la restriccion de que traiga de la base de datos
     * todos los NO borrados.
     */
    public void restriccionNoBorrado() {
        this.getCrit().add(Restrictions.eq("estado", 0));
    }

    /**
     *
     * Se le agrega al criterio una restriccion absoluta.
     */
    public void addRestriccion(String campo, String campoFiltro) {
        this.getCrit().add(Restrictions.eq(campo, campoFiltro));
    }

    /**
     *
     * Este metodo recibe como parametro dos string: el primero es el nombre del
     * atributo de la clase por el cual queremos filtrar y el otro es el string
     * sobre el cual vamos filtrando. Y agrega el filtro al criterio de
     * busqueda.
     */
    public void addFiltro(String campo, String campoFiltro) {
        this.getCrit().add(Restrictions.ilike(campo, campoFiltro, MatchMode.START));
    }

    /**
     *
     * Este metodo recibe como parametro un string y un entero: el primero es el
     * nombre del atributo de la clase por el cual queremos filtrar y el otro es
     * el entero sobre el cual vamos filtrando. Y agrega el filtro al criterio
     * de busqueda.
     */
    public void addFiltroInt(String campo, int numero) {
        this.getCrit().add(Restrictions.eq(campo, numero));
    }

    /**
     *
     * Este metodo recibe como parametro el nombre del atribito por el cual
     * queremos filtrar y un objeto sobre el cual se consultara.
     */
    public void addFiltroPorObjeto(String nombre, Object objeto) {
        this.getCrit().add(Restrictions.eq(nombre, objeto));
    }

    public void add(String par) {
        this.getCrit().setFetchMode(par, FetchMode.JOIN);
    }

    /**
     *
     * Este metodo recibe como parametro el nombre del campo al cual queremos
     * ordenar ascendentemente. Y lo agrega al criterio de busqueda.
     */
    public void addOrdenAscendente(String campo) {
        this.getCrit().addOrder(Order.asc(campo));
    }

    /**
     *
     * Este metodo recibe como parametro el nombre del campo al cual queremos
     * ordenar Descendente. Y lo agrega al criterio de busqueda.
     */
    public void addOrdenDescendente(String campo) {
        this.getCrit().addOrder(Order.desc(campo));
    }

    /***
     * 
     * @param par1
     * @param par2
     * Este metodo nos permite crear un alias para referenciar una tabla al realizar un
     * innner join
     */
    public void createAlias(String par1, String par2) {
        this.getCrit().createAlias(par1, par2);
    }

    /**
     *
     * Este metodo retorna una lista con todas las restricciones que se fueron
     * agregando.
     * @return 
     */
    public List resultConsulta() {
        return this.getCrit().list();
    }

    public Object resultConsultaObject() {
        return this.getCrit().uniqueResult();
    }

    
}
