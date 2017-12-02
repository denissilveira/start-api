package tech.yotz.start.model.resource;

public class AuthenticationResource {
	
    private String username;
    private String password;

    public AuthenticationResource() {
        super();
    }

    public AuthenticationResource(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}