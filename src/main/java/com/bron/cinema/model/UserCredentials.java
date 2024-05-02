package com.bron.cinema.model;

import lombok.Setter;

public class UserCredentials {

    private String email;

    @Setter
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPasssword(String password){
        this.password= password;
    }

}

