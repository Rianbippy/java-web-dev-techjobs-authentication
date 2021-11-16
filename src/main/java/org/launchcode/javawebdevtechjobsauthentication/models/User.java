package org.launchcode.javawebdevtechjobsauthentication.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    private String username;
    private String pwHashed;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHashed = encoder.encode(password);
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHashed);
    }

    public String getUsername() {
        return username;
    }
}
