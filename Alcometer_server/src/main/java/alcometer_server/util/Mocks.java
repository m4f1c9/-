package alcometer_server.util;

import alcometer_server.authentication.Authenticator;
import alcometer_server.drink.DrinkDAO;
import alcometer_server.recommendation.DrinkInfo;
import alcometer_server.recommendation.Recommendation;

import alcometer_server.recommendation.RecommendationDAO;
import alcometer_server.statistics.Drink;
import alcometer_server.statistics.Statistic;
import alcometer_server.statistics.StatisticsDAO;
import alcometer_server.util.exceptions.AuthenticationExceptions;
import alcometer_server.util.exceptions.DAOExceptions;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.mockito.Matchers;
import org.mockito.Mockito;

public final class Mocks {

    public static Authenticator createAuthenticator() throws AuthenticationExceptions {
        Authenticator authenticator = Mockito.mock(Authenticator.class);
        Mockito.when(authenticator.getUserID(Matchers.anyString())).thenReturn("test@gmail.com");
        return authenticator;
    }

    public static StatisticsDAO createStatisticsDAO() throws DAOExceptions {
        StatisticsDAO statisticsDAO = Mockito.mock(StatisticsDAO.class);
        Statistic s = new Statistic();
        s.setDrinks(new HashSet<Drink>() {
            {
                add(new Drink("lager", 1000));
                add(new Drink("aromatised_wine", 5000));
            }
        });
        Mockito.when(statisticsDAO.getStatistic(Matchers.anyString(), Matchers.anyString())).thenReturn(s);
        return statisticsDAO;

    }

    public static RecommendationDAO getRecommendationDAO() throws DAOExceptions, SQLException {
        RecommendationDAO dao = Mockito.mock(RecommendationDAO.class);
        Recommendation recommendation = new Recommendation();
        Set<DrinkInfo> drinks = new HashSet<>();
        drinks.add(new DrinkInfo() {
            {
                setDescription("Description");
               // setMaxPrice(600);
               // setMinPrice(500);
                setName("Sant’Orsola");
                setType("Пино Гриджио");
            }
        });
        drinks.add(new DrinkInfo() {
            {
                setDescription("Description");
                setMaxPrice(1800);
                setMinPrice(1600);
                setName("Sibaris");
                setType("Undurraga");
            }
        });
        recommendation.setDrinks(drinks);
        Mockito.when(dao.getRecommendation(Matchers.anyString())).thenReturn(recommendation);

        return dao;
    }

    public static DrinkDAO getDrinkDAO() {
        DrinkDAO DAO = Mockito.mock(DrinkDAO.class);
        return DAO;

    }

}
