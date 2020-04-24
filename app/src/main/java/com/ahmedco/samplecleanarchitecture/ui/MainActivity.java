package com.ahmedco.samplecleanarchitecture.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmedcom.test.R;


//https://stackoverflow.com/questions/12233623/alarmmanager-when-the-phone-is-turned-off-android
//https://www.linkedin.com/pulse/simple-implementation-clean-architecture-android-example-ahmed-adel/

//info.hoang8f.widget.FButton


public class MainActivity extends AppCompatActivity implements LoginView {
    // Send work requests to the background service
    private LoginPresenter presenter;
    private ProgressBar progress;
    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenter(this);
        userNameEditText =(EditText)findViewById(R.id.edtEmail);
        passwordEditText=(EditText)findViewById(R.id.edtPassword);
        loginButton = (Button)findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(onClickListener());

    }

    private View.OnClickListener onClickListener(){
        return new View.OnClickListener(){
            public void onClick(View v){
                String Email = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                presenter.onLoginClicked(Email,password);
            }
        };
    }

    @Override
    public void showProgress(){

    }

    @Override
    public void hideProgress(){

    }

    @Override
    public void showError(String error) {

    }

}

