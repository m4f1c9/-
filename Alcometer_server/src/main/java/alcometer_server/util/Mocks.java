package alcometer_server.util;

import alcometer_server.authentication.Authenticator;
import org.mockito.Matchers;
import org.mockito.Mockito;

public final class Mocks {
    public static Authenticator createAuthenticator (){
        Authenticator authenticator = Mockito.mock(Authenticator.class);
        Mockito.when(authenticator.validate(Matchers.anyString())).thenReturn(Boolean.TRUE);
        Mockito.when(authenticator.getUserEMail()).thenReturn("test@gmail.com");
        return authenticator;
    }
}
