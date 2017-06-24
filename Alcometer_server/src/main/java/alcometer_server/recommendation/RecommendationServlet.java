package alcometer_server.recommendation;

import alcometer_server.util.exceptions.DAOExceptions;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


    /**
     * Map to http://host:port/recommendation
     */
public class RecommendationServlet extends HttpServlet {

    Logger logger;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dishes = request.getParameter("dishes");

        try {
            RecommendationDAO dao = new JPARecommendationDAO();
            Dishes recomendation = dao.getRecommendation(dishes);
            
            String answer = JSON.toJSONString(recomendation);

            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(answer);

        } catch (DAOExceptions e) {
            response.sendError(400, e.getMessage());
            logger.debug("Incorrect dishes - " + dishes);
        } catch (Throwable e) {
            response.sendError(500);
            logger.error(e);
        }

    }

    @Override
    public void init() throws ServletException {
        logger = Logger.getLogger(RecommendationServlet.class);
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
