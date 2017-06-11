package alcometer_server.recommendation;

import alcometer_server.util.ContextListener.HibernateContextListener;
import alcometer_server.util.exceptions.DAOExceptions;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPARecommendationDAO implements RecommendationDAO {

    @Override
    public Recommendation getRecommendation(String dishes) throws DAOExceptions, SQLException {
        if (dishes == null) {
            throw new DAOExceptions();
        }
        EntityManager manager = null;
        Recommendation recommendation = null;

        StringTokenizer tokinizer = new StringTokenizer(dishes, ",");
        StringBuilder builder = new StringBuilder();
        try {
            manager = HibernateContextListener.getEntityManagerFactory().createEntityManager();
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

            manager.getTransaction().begin();
            Query query = manager.createQuery(builder.toString(), Dishes.class);
            Dishes d = (Dishes) query.getSingleResult();

            recommendation = new Recommendation(d.getDrinks());
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
        return recommendation;
    }

}
