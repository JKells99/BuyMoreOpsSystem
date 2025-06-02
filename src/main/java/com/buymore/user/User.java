package com.buymore.user;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true)
    private String userName;
    private String password;
    private String systemRole;

    public User(String userName, String password, String systemRole) {
        this.userName = userName;
        this.password = password;
        this.systemRole = systemRole;
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

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", systemRole='" + systemRole + '\'' +
                '}';
    }
}
