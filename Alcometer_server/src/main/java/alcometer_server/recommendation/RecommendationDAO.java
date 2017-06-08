
package alcometer_server.recommendation;

import alcometer_server.util.exceptions.DAOExceptions;
import java.sql.SQLException;

public interface RecommendationDAO {
    public Recommendation getRecommendation(String dishes) throws DAOExceptions, SQLException;
    
}

