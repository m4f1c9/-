
package alcometer_server.util.exceptions;

public class AuthenticationExceptions extends Exception{

    public AuthenticationExceptions() {
    }

    public AuthenticationExceptions(String message) {
        super(message);
    }

    public AuthenticationExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationExceptions(Throwable cause) {
        super(cause);
    }

    public AuthenticationExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
