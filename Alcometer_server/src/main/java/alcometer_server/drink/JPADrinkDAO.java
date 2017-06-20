package alcometer_server.drink;

import alcometer_server.statistics.History;
import alcometer_server.util.ContextListener.HibernateContextListener;
import alcometer_server.util.exceptions.DAOExceptions;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

public class JPADrinkDAO implements DrinkDAO {

    List<String> allowedValues = new LinkedList<String>() {
        {
            add("wine");
            add("strong_alcohol");
            add("beer");
        }
    };

    @Override
    public void recordDrunk(String drinkType, String drinkVolume, String userID) throws DAOExceptions {
        EntityManager manager = null;
        
        if (!allowedValues.contains(drinkType)){
            throw new DAOExceptions("Incorrect drinkType : " + drinkType);
        }
        
        try {
            manager = HibernateContextListener.createEntityManager();

            History drink = new History();
            drink.setType(drinkType);
            drink.setVolume(Integer.parseInt(drinkVolume));
            drink.setDate(new Date());
            drink.setUserID(userID);

            manager.getTransaction().begin();
            manager.persist(drink);
            manager.getTransaction().commit();
        } catch (NumberFormatException e) {
            throw new DAOExceptions("Incorrect volume : " + drinkVolume);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

}
