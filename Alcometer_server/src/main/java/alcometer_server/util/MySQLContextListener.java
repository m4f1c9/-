package alcometer_server.util;

import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MySQLContextListener implements ServletContextListener {

    private static Properties mySQLProperties;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        mySQLProperties = new Properties();
        mySQLProperties.setProperty("user", sce.getServletContext().getInitParameter("user"));
        mySQLProperties.setProperty("password", sce.getServletContext().getInitParameter("password"));
        mySQLProperties.setProperty("URL", sce.getServletContext().getInitParameter("url"));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // do nothing
    }

    public static Properties getMySQLProperties() {
        return mySQLProperties;
    }

}
