package hibernate;

import Utilidades.Propiedades;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    public static SessionFactory sessionFactory;
    public static Session session;

    public static void inicializar() {
        try {
            Properties prop =  new Propiedades().getPropiedades();
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            AnnotationConfiguration conf = new AnnotationConfiguration();

            
            conf.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            conf.setProperty("hibernate.connection.url", "jdbc:postgresql://192.168.1.103:5432/"+ prop.getProperty("dbname"));


            conf.setProperty("hibernate.connection.username",prop.getProperty("dbuser"));// Colocar Usuario y contraseña de postgresql
            conf.setProperty("hibernate.connection.password", prop.getProperty("dbpassword"));


            conf.setProperty("hibernate.connection.pool_size", "10");
            conf.setProperty("show_sql", "true");
            conf.setProperty("hibernate.hbm2ddl.auto", "update");
            

             conf.addPackage("models.incripcion");
                          
             conf.addAnnotatedClass(models.inscripcion.Categoria.class);
             conf.addAnnotatedClass(models.inscripcion.Estado.class);
             conf.addAnnotatedClass(models.inscripcion.Cuota.class);
             conf.addAnnotatedClass(models.inscripcion.Inscripcion.class);
             
             conf.addPackage("models.pago");
             conf.addAnnotatedClass(models.pago.Descuento.class);
             conf.addAnnotatedClass(models.pago.Pago.class);
             
             conf.addPackage("models.ubicacion");
             conf.addAnnotatedClass(models.ubicacion.Pais.class);
             conf.addAnnotatedClass(models.ubicacion.Provincia.class);
             conf.addAnnotatedClass(models.ubicacion.Localidad.class);
             conf.addAnnotatedClass(models.ubicacion.Direccion.class);
             
             conf.addPackage("models.mutual");
             conf.addAnnotatedClass(models.mutual.Mutual.class);
             
             conf.addPackage("models.turno");
             conf.addAnnotatedClass(models.institucion.Turno.class);

             conf.addPackage("models.telefono");
             conf.addAnnotatedClass(models.telefono.TipoTelefono.class); 
             conf.addAnnotatedClass(models.telefono.Telefono.class);
             
             conf.addPackage("models.tutor");
             conf.addAnnotatedClass(models.tutor.Tutor.class); 
                        
             conf.addPackage("models.atencionMedica");
             conf.addAnnotatedClass(models.atencionMedica.Tratamiento.class);
             conf.addAnnotatedClass(models.atencionMedica.Alergia.class);            
             
             conf.addPackage("models.grupo");
             conf.addAnnotatedClass(models.grupo.GrupoSanguineo.class);
             
             conf.addPackage("models.identificacion");
             conf.addAnnotatedClass(models.identificacion.TipoDocumento.class);
             conf.addAnnotatedClass(models.identificacion.Documento.class);
             
             conf.addPackage("models.institucion");
             conf.addAnnotatedClass(models.institucion.InstitucionEducativa.class);
             conf.addAnnotatedClass(models.institucion.Turno.class);
             conf.addAnnotatedClass(models.institucion.InstitucionPorAlumno.class);
             
             conf.addPackage("models.alumno");
             conf.addAnnotatedClass(models.alumno.Alumno.class);

         
            sessionFactory = conf.buildSessionFactory();
            session = sessionFactory.openSession();

        } catch (Throwable ex) {
// Log exception!
            JOptionPane.showMessageDialog(null, ex.toString());
            JOptionPane.showMessageDialog(null, "Verificar la conexión de red");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void clearCache() {
        session.clear();
    }

    public static void cerrarSession() {
        session.close();
    }
}
