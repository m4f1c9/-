package alcometer_server.statistics;

public interface StatisticsDAO {

    public Statistic forDay(String id);

    public Statistic forWeek(String id);

    public Statistic forMonth(String id);

    public Statistic forYear(String id);
}
