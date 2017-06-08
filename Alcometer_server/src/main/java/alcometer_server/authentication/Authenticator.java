package alcometer_server.authentication;

import alcometer_server.util.exceptions.AuthenticationExceptions;

public interface Authenticator {

    public String getUserID(String token) throws AuthenticationExceptions;
}
