package alcometer_server.recommendation;

import alcometer_server.util.DBConnector;
import alcometer_server.util.exceptions.DAOExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class MySQLRecommendationDAO implements RecommendationDAO {

    @Override
    public Recommendation getRecommendation(String dishes) throws DAOExceptions, SQLException {
        HashSet<DrinkInfo> info = new HashSet<>();
        try (Connection connection = DBConnector.createConnection();
                Statement statement = connection.createStatement()) {
            ResultSet RS = statement.executeQuery(createSQL(dishes));
            while (RS.next()) {
                DrinkInfo drinkInfo = new DrinkInfo();
                drinkInfo.setType(RS.getString(1));
                drinkInfo.setDescription(RS.getString(2));
                info.add(drinkInfo);
            }

        }

        return new Recommendation(info);
    }

    private String createSQL(String dishes) throws DAOExceptions {

        if (dishes == null) {
            throw new DAOExceptions();
        }
        String[] params = dishes.split(",");
        if (params.length > 3) {
            throw new DAOExceptions();
        }
        StringBuilder result = new StringBuilder();
        if (params.length == 3) {
            result.append("select type, description from drinks_dishes join drinks on drinks_dishes.drinks_id = drinks.drinks_id where dishes_id = (select dishes_id from dishes where first_dish = '");
            result.append(params[0]);
            result.append("' and second_dish = '");
            result.append(params[1]);
            result.append("' and third_dish = '");
            result.append(params[2]);
            result.append("')");

        } else if (params.length == 2) {
            result.append("select type, description from drinks_dishes join drinks on drinks_dishes.drinks_id = drinks.drinks_id where dishes_id = (select dishes_id from dishes where first_dish = '");
            result.append(params[0]);
            result.append("' and second_dish = '");
            result.append(params[1]);
            result.append("')");
        } else if (params.length == 1) {
            result.append("select type, description from drinks_dishes join drinks on drinks_dishes.drinks_id = drinks.drinks_id where dishes_id = (select dishes_id from dishes where first_dish = '");
            result.append(params[0]);
            result.append("')");

        }

        return result.toString();
    }

}
