package alcometer_server.authentication;

import alcometer_server.util.Mocks;
import alcometer_server.util.exceptions.AuthenticationExceptions;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class AuthenticationFilter implements Filter {

    Logger logger;
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = Logger.getLogger(AuthenticationFilter.class);
        logger.debug("Initialized AuthenticationFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getParameter("access_token");

        try {
            Authenticator authenticator = Mocks.createAuthenticator();
            String userID = authenticator.getUserID(token);
            httpRequest.setAttribute("userID", userID);
            logger.debug("correct access token - " + token + " userID " + userID);
            chain.doFilter(request, response);

        } catch (AuthenticationExceptions e) {
            logger.debug("incorrect access token - " + token);
            httpResponse.sendError(401, "Authentication has failed");
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }

}
