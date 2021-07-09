package com.jeeproject.ecommerce.message.request;

import java.util.Set;

public class SignUpForm  {


    private String firstname;


    private String lastname;


    private String email;

    private Set role;


    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getRole() {
        return this.role;
    }

    public void setRole(Set role) {
        this.role = role;
    }
}
