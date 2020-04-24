package com.ahmedco.samplecleanarchitecture.entities;


/*
* Entities does not have any reference to any class other
than primitives , strings, and other entities.
*/

public class UserCredentials {

    private String email;
    private String password;

    public UserCredentials(String email, String password){
        this.password = password;
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
