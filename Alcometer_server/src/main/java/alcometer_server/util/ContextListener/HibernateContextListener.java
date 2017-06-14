package alcometer_server.util.ContextListener;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateContextListener implements ServletContextListener {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
           
            // TODO
        }
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("alcometer");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (ENTITY_MANAGER_FACTORY != null) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

    public static EntityManager createEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

}
