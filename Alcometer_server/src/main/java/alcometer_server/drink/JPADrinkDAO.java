package alcometer_server.drink;

import alcometer_server.statistics.History;
import alcometer_server.util.ContextListener.HibernateContextListener;
import alcometer_server.util.exceptions.DAOExceptions;
import java.util.Date;
import javax.persistence.EntityManager;

public class JPADrinkDAO implements DrinkDAO {

    @Override
    public void recordDrunk(String drinkType, String drinkVolume, String userID) throws DAOExceptions {
        EntityManager manager = null;
        try {
            manager = HibernateContextListener.getEntityManagerFactory().createEntityManager();
            
            History drink = new History();
            drink.setType(drinkType);
            drink.setVolume(Integer.parseInt(drinkVolume));
            drink.setDate(new Date());
            drink.setUserID(userID);
            
            manager.getTransaction().begin();
            manager.persist(drink);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
    }

}
