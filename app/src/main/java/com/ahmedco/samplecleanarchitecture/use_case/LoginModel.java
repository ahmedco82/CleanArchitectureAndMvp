package com.ahmedco.samplecleanarchitecture.use_case;



/*
 Use-case classes does not have any reference to any class other than primitives
 , strings, entities, and helper classes that gets those entities
 from the place they are stored in.
like classes to get our entities from server , database, preference , etc.
*/



import com.ahmedco.samplecleanarchitecture.api.ApiClient;
import com.ahmedco.samplecleanarchitecture.api.ApiInterface;
import com.ahmedco.samplecleanarchitecture.entities.User;
import com.ahmedco.samplecleanarchitecture.entities.UserCredentials;
import com.ahmedco.samplecleanarchitecture.entities.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel {

    private ApiInterface loginApi = createRetrofitLoginApi();

    private boolean login = false;

    private ApiInterface createRetrofitLoginApi(){
        return ApiClient.getApiService();
    }

    public boolean requestLogin(final UserCredentials credentials){
        Call<UserList> call = loginApi.getAllUser();
         call.enqueue(new Callback<UserList>(){
            @Override
            public void onResponse(Call<UserList> call , Response<UserList> response) {
               if(response.isSuccessful()) {
                 List<User> userList = response.body().getResult();
                  for(int i = 0; i<userList.size(); i++){
                     if (credentials.getEmail().equals(userList.get(i).getEmail()) && credentials.getPassword().equals(userList.get(i).getPassword())) {
                          login = true;
                      }
                    }
                 }
              }
            @Override
            public void onFailure(Call<UserList> call, Throwable t){

            }
        });
      return login;
    }
}
