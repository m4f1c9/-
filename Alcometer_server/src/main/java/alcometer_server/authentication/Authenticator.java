
package alcometer_server.authentication;


public interface Authenticator {
    public boolean validate (String token);
    public String getUserID (String token);
}
