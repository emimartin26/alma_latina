/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.institucion;

import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "institucionPorAlumno")
public class InstitucionPorAlumno {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    private String descripcion;
    @OneToOne(targetEntity = InstitucionEducativa.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InstitucionEducativa institucionEductiva;
    @OneToOne(targetEntity = Turno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Turno turno; 

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InstitucionEducativa getInstitucionEductiva() {
        return institucionEductiva;
    }

    public void setInstitucionEductiva(InstitucionEducativa institucionEductiva) {
        this.institucionEductiva = institucionEductiva;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    
    public String toString(){
        return this.institucionEductiva.getNombre() + "Turno: " + this.turno.getNombre();
    }
    
    
    
}
