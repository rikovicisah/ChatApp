package main.client.android.shutdown.remote.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login_btnLogin;
    EditText login_UtxtEmail;
    EditText login_UtxtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btnLogin = findViewById(R.id.login_btnLogin);
        login_UtxtEmail = findViewById(R.id.login_UtxtEmail);
        login_UtxtPassword = findViewById(R.id.login_UtxtPassword);
    }

    public void login_Login(View view){
        if(!login_UtxtEmail.getText().toString().isEmpty() &&
                !login_UtxtPassword.getText().toString().isEmpty()){
            //TODO Login
        }else{
            Toast.makeText(LoginActivity.this, "Please enter your email and password", Toast.LENGTH_SHORT).show();
        }
    }
}
