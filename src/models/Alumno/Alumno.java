/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models.Alumno;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import models.atencionMedica.Alergia;
import models.grupo.GrupoSanguineo;
import models.identificacion.Documento;
import models.institucion.InstitucionPorAlumno;
import models.mutual.Mutual;
import models.tutor.Tutor;
/**
 *
 * @author EMILIANO
 */
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    
    
    @OneToOne(targetEntity = Documento.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Documento documento;
    @OneToOne(targetEntity = GrupoSanguineo.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GrupoSanguineo GrupoSanguineo;
    @OneToOne(targetEntity = Tutor.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Tutor tutor;
    @OneToOne(targetEntity = InstitucionPorAlumno.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InstitucionPorAlumno InstitucionPorAlumno;
    
    @OneToMany(targetEntity = Alergia.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Alergia> alergias;
    @OneToMany(targetEntity = Mutual.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Mutual> mutuales;
    
    public Alumno() {
        this.alergias=new <Alergia> HashSet();
        this.mutuales=new <Mutual> HashSet();
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public GrupoSanguineo getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public InstitucionPorAlumno getInstitucionPorAlumno() {
        return InstitucionPorAlumno;
    }

    public void setInstitucionPorAlumno(InstitucionPorAlumno InstitucionPorAlumno) {
        this.InstitucionPorAlumno = InstitucionPorAlumno;
    }

    public Set<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(Set<Alergia> alergias) {
        this.alergias = alergias;
    }

    public Set<Mutual> getMutuales() {
        return mutuales;
    }

    public void setMutuales(Set<Mutual> mutuales) {
        this.mutuales = mutuales;
    }
    
    
}
