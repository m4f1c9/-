
package alcometer_server.util;
import alcometer_server.authentication.Authenticator;
import alcometer_server.util.exceptions.AuthenticationExceptions;


public class AuthenticatorMock implements Authenticator{

    @Override
    public String getUserID(String token) throws AuthenticationExceptions {
        if (token == null){
            throw new AuthenticationExceptions("No access token");
        }
        else if (token.equals("123456")){
            return "abc";
        }
        else throw new AuthenticationExceptions("Incorrect access token");
    }
    
}
