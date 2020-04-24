package com.ahmedco.samplecleanarchitecture.ui;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ahmedco.samplecleanarchitecture.entities.UserCredentials;
import com.ahmedco.samplecleanarchitecture.use_case.LoginModel;



public class LoginPresenter{

    private LoginView loginView;
    private LoginModel loginModel;
    Context context;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        this.context = (Context) loginView;
        this.loginModel = new LoginModel();
    }

    public void onLoginClicked(String Email, String password){
        if(!isValidFormat(Email,password)){
              requestLoginFromModel(new UserCredentials(Email,password));
        }else{
            loginView.showError("invalid data");
        }
    }

    private boolean isValidFormat(String userName, String password){
        boolean Valid = true;
        if (userName.length() == 0) {
            Valid= false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(password).matches()) {
            Valid= false;
        }
        return Valid;
    }

    private void requestLoginFromModel(final UserCredentials credentials){
        boolean response = loginModel.requestLogin(credentials);
        if(response){
           // moveToNextScreen();
          Toast.makeText(context, "Sucess.....", Toast.LENGTH_SHORT).show();
        }else{
           //loginView.showError("login failed");
           Toast.makeText(context, "Not .....", Toast.LENGTH_SHORT).show();
           }
        }
       private void moveToNextScreen() {
           Log.i("goto_0","NextScreen");
      }
}











