
package alcometer_server.drink;

import alcometer_server.util.exceptions.DAOExceptions;


public interface DrinkDAO {
    public void recordDrunk (String drinkType, String drinkVolume, String userID) throws DAOExceptions;
}
