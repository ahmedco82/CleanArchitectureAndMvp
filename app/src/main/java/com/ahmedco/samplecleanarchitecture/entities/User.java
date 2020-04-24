
package com.ahmedco.samplecleanarchitecture.entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/*
 * Entities does not have any reference to any class other
  than primitives , strings, and other entities.
 */
public class User {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
