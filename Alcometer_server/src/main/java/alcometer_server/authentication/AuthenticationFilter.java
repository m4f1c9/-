package alcometer_server.authentication;

import alcometer_server.util.Mocks;
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
        logger.info("Initialized AuthenticationFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authenticator authenticator = Mocks.createAuthenticator();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getParameter("access_token");

        if (token == null || !authenticator.validate(token)) {
            httpResponse.sendError(401, "Authentication has failed or has not yet been provided");
        } else {
            httpRequest.setAttribute("userID", authenticator.getUserID(token));
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }

}
