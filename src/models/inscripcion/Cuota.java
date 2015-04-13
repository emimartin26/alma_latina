/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.inscripcion;

import java.sql.Date;
import javax.persistence.*;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "cuota")
public class Cuota {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(targetEntity = Estado.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estado estado;
    
    private Date fechaVencimiento;
    private int numeroDeCuota;  
}
