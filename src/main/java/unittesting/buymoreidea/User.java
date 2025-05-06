package unittesting.buymoreidea;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.userName = userName;
        this.password = hashedPassword;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
