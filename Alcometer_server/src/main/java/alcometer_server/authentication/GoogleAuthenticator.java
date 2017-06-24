package alcometer_server.authentication;

import alcometer_server.util.exceptions.AuthenticationExceptions;
import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleAuthenticator implements Authenticator {

    String token;

    public GoogleAuthenticator(String token) {
        this.token = token;
    }

    @Override
    public String getUserID() throws AuthenticationExceptions {
        StringBuilder response = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(createConnection().getInputStream()));) {
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
        } catch (IOException ex) {
            throw new AuthenticationExceptions(ex);
        }
        return JSON.parseObject(response.toString(), User.class).getEmail();
    }

    private HttpURLConnection createConnection() throws AuthenticationExceptions {
        URL url;
        HttpURLConnection connection;
        try {
            url = new URL("https://www.googleapis.com/userinfo/v2/me");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.connect();

        } catch (IOException ex) {
            throw new AuthenticationExceptions(ex);
        }
        return connection;
    }

}
