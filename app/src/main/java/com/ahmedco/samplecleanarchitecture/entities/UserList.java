
package com.ahmedco.samplecleanarchitecture.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/*
* Entities does not have any reference to any class other
than primitives , strings, and other entities.
*/

public class UserList {

    @SerializedName("result")
    @Expose
    private List<User> result = null;

    public List<User> getResult(){
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

}
