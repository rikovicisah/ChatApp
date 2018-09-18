package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPasswordActivity extends AppCompatActivity {

    EditText registerPassword_UtxtPassword;
    EditText registerPassword_UtxtPasswordRetype;
    Button registerPassword_btnNext;
    String email;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_password);

        registerPassword_UtxtPassword = findViewById(R.id.registerPassword_UtxtPassword);
        registerPassword_UtxtPasswordRetype = findViewById(R.id.registerPassword_UtxtPasswordRetype);
        registerPassword_btnNext = findViewById(R.id.registerPassword_btnNext);

        Intent fromRegisterEmail = getIntent();
        email = fromRegisterEmail.getStringExtra("email");
        username = fromRegisterEmail.getStringExtra("username");
    }

    public void createAccount(View view){
        if(registerPassword_UtxtPassword.getText().toString().equals(registerPassword_UtxtPasswordRetype.getText().toString())
                && registerPassword_UtxtPassword.getText().toString().length() > 7){

            //TODO kreirati account

        }else{
            Toast.makeText(RegisterPasswordActivity.this,"Please enter your password, min 8 characters", Toast.LENGTH_LONG).show();
            registerPassword_UtxtPassword.setText("");
            registerPassword_UtxtPasswordRetype.setText("");
        }
    }

}
