package alcometer_server.recommendation;

import alcometer_server.util.Mocks;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecommendationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RecommendationDAO dao = Mocks.getRecommendationDAO();
        String[] dishes = null;
        Recommendation recomendation = null;
        if (request.getParameter("dishes") == null) {
            onFail(response);
        } else {
            dishes = request.getParameter("dishes").split(",");
            if (dishes.length > 3) {
                onFail(response);
            } else {
                recomendation = dao.getRecommendation(dishes);
                response.setStatus(200);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String jsonResp = JSON.toJSONString(recomendation);
                response.getWriter().write(jsonResp);

            }

        }

    }

    protected void onFail(HttpServletResponse response) throws IOException {
        response.sendError(400, "Incorrect dishes");
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
