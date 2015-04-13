package hibernate;

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
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            AnnotationConfiguration conf = new AnnotationConfiguration();

            conf.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            conf.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/almaLatina");


            conf.setProperty("hibernate.connection.username","postgres");// Colocar Usuario y contraseña de postgresql
            conf.setProperty("hibernate.connection.password", "35638081");


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