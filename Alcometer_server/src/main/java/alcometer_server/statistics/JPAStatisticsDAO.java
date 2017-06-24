package alcometer_server.statistics;

import alcometer_server.util.ContextListener.HibernateContextListener;
import alcometer_server.util.exceptions.DAOExceptions;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPAStatisticsDAO implements StatisticsDAO {

    @Override
    public Statistic getStatistic(String userID, String period) throws DAOExceptions {

        Statistic statistic = null;
        EntityManager manager = null;
        try {
            manager = HibernateContextListener.createEntityManager();

            String requestqueryStr = "SELECT e FROM History e " + 
                    "where e.userID = :userID and e.date > :date";
            Query query = manager.createQuery(requestqueryStr, History.class);
            query.setParameter("date", getDate(period));
            query.setParameter("userID", userID);

            manager.getTransaction().begin();
            List<History> list = query.getResultList();
            statistic = new Statistic(new HashSet<Drink>() {
                {
                    add(createDrink("wine", list));
                    add(createDrink("strong_alcohol", list));
                    add(createDrink("beer", list));
                }
            });

            manager.getTransaction().commit();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return statistic;
    }

    private Date getDate(String period) throws DAOExceptions {
        Calendar calendar = new GregorianCalendar();
        if (period == null) {
            throw new DAOExceptions("Period missing");
        } else if (period.equals("day")) {
            calendar.add(Calendar.HOUR_OF_DAY, -24);
        } else if (period.equals("week")) {
            calendar.add(Calendar.HOUR_OF_DAY, -168);
        } else if (period.equals("month")) {
            calendar.add(Calendar.MONTH, -1);
        } else if (period.equals("year")) {
            calendar.add(Calendar.YEAR, -1);
        } else if (period.equals("full")) {
            calendar.add(Calendar.ERA, -1);
        } else {
            throw new DAOExceptions("Incorrect period");
        }

        return calendar.getTime();
    }

    private Drink createDrink(String type, final List<History> list) {
        int sum = list.stream().filter((t) -> {
            return t.getType().equals(type);
        }).mapToInt((value) -> {
            return value.getVolume();
        }).reduce(Integer::sum).orElse(0);

        return new Drink(type, sum);
    }

}
