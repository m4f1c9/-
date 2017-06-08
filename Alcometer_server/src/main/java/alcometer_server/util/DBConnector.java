package alcometer_server.util;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DBConnector {

    private static Logger logger;

    static {
        logger = Logger.getLogger(DBConnector.class);
    }

    public static Connection createConnection() throws SQLException {
        Properties MySQLProperties = MySQLContextListener.getMySQLProperties();
        logger.debug(MySQLProperties);
        Connection connection = new Driver().connect(MySQLProperties.getProperty("URL"), MySQLProperties);

        return connection;
    }
}
