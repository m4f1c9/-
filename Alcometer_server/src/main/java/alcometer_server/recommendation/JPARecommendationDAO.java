package alcometer_server.recommendation;

import alcometer_server.util.ContextListener.HibernateContextListener;
import alcometer_server.util.exceptions.DAOExceptions;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JPARecommendationDAO implements RecommendationDAO {

    @Override
    public Dishes getRecommendation(String dishes) throws DAOExceptions {
        if (dishes == null) {
            throw new DAOExceptions("Missing dishes parameter");
        }
        EntityManager manager = null;
        Dishes answer = null;

        try {
            manager = HibernateContextListener.createEntityManager();
            manager.getTransaction().begin();

            Query query = manager.createQuery(createQueryString(dishes), Dishes.class);
            answer = (Dishes) query.getSingleResult();
            manager.getTransaction().commit();
        } catch (NoResultException e) {
            throw new DAOExceptions("Incorect dishes : " + dishes);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return answer;
    }

    private String createQueryString(String dishes) throws DAOExceptions {
        StringTokenizer tokinizer = new StringTokenizer(dishes, ",");
        StringBuilder builder = new StringBuilder();

        builder.append("SELECT e FROM Dishes e where firstDish = '");
        builder.append(tokinizer.nextToken());
        builder.append("' and secondDish = ");
        if (!tokinizer.hasMoreTokens()) {
            builder.append("null");
        } else {
            builder.append("'");
            builder.append(tokinizer.nextToken());
            builder.append("'");
        }
        builder.append(" and thirdDish = ");
        if (!tokinizer.hasMoreTokens()) {
            builder.append("null");
        } else {
            builder.append("'");
            builder.append(tokinizer.nextToken());
            builder.append("'");
        }
        if (tokinizer.hasMoreTokens()){
            throw new DAOExceptions("Incorect dishes : " + dishes);
        }

        return builder.toString();
    }

}
