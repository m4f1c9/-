package alcometer_server.util;

import alcometer_server.authentication.Authenticator;
import alcometer_server.drink.DrinkDAO;
import alcometer_server.recommendation.DrinkInfo;
import alcometer_server.recommendation.Recommendation;

import alcometer_server.recommendation.RecommendationDAO;
import alcometer_server.statistics.History;
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
        Mockito.when(authenticator.getUserID(Matchers.anyString())).thenReturn("abc");
        return authenticator;
    }

}
