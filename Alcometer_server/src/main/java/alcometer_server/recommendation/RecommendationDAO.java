
package alcometer_server.recommendation;

import alcometer_server.util.exceptions.DAOExceptions;

public interface RecommendationDAO {
    public Dishes getRecommendation(String dishes) throws DAOExceptions;
    
}

