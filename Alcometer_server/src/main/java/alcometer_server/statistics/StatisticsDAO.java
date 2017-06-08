package alcometer_server.statistics;

import alcometer_server.util.exceptions.DAOExceptions;

public interface StatisticsDAO {

    public Statistic getStatistic(String userID, String period) throws DAOExceptions;

}
