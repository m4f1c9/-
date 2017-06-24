package alcometer_server.authentication;

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
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getParameter("access_token");

        try {
            Authenticator authenticator = new GoogleAuthenticator(token);
            String userID = authenticator.getUserID();
            httpRequest.setAttribute("userID", userID);
            
            logger.debug(token + userID);
            chain.doFilter(request, response);

        } catch (AuthenticationExceptions e) {
            httpResponse.sendError(401);
            logger.debug(e);
        } catch (Throwable e) {
            httpResponse.sendError(500);
            logger.error(e);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }

}
