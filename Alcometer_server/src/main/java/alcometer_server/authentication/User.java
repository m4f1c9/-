
package alcometer_server.authentication;


public class User {
    private String email;
    private String id;

    @Override
    public String toString() {
        return "USER{" + "email=" + email + ", id=" + id + '}';
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
