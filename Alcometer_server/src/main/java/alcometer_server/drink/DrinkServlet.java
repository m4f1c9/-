package alcometer_server.drink;

import alcometer_server.statistics.StatisticsServlet;
import alcometer_server.util.Mocks;
import alcometer_server.util.exceptions.DAOExceptions;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class DrinkServlet extends HttpServlet {

    Logger logger;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = (String) request.getAttribute("userID");
        String drinkType = request.getParameter("drink_type");
        String drinkVolume = request.getParameter("drink_volume");

        try {
            DrinkDAO dao = new JPADrinkDAO();
            dao.recordDrunk(drinkType, drinkVolume, userID);
            response.setStatus(200);
        } catch (DAOExceptions e) {
            response.sendError(400, "Incorrect request");
            logger.debug("Incorrect request: userID - " + userID + " drinkType " + drinkType + " " + " " + drinkVolume);
        }

    }

    @Override
    public void init() throws ServletException {
        logger = Logger.getLogger(DrinkServlet.class);
        logger.debug("Initialized DrinkServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
