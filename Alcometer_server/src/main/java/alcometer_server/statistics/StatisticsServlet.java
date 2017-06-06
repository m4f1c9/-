package alcometer_server.statistics;

import alcometer_server.util.Mocks;
import com.alibaba.fastjson.JSON;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatisticsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = (String) request.getAttribute("userID");
        StatisticsDAO dao = Mocks.createStatisticsDAO();
        String period = request.getParameter("period");
        Statistic statistic = null;

        if (period == null) {
            onFail(response);
        } else if (period.equals("day")) {
            statistic = dao.forDay(userID);
        } else if (period.equals("week")) {
            statistic = dao.forWeek(userID);
        } else if (period.equals("month")) {
            statistic = dao.forMonth(userID);
        } else if (period.equals("year")) {
            statistic = dao.forYear(userID);
        } else {
            onFail(response);
        }

        if (statistic != null) {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String jsonResp = JSON.toJSONString(statistic);
            response.getWriter().write(jsonResp);
        }
    }
    
    

    protected void onFail(HttpServletResponse response) throws IOException {
        response.sendError(400, "Incorrect period");
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
