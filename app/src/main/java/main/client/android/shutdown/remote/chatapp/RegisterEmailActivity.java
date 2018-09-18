package main.client.android.shutdown.remote.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterEmailActivity extends AppCompatActivity {

    EditText registerEmail_UtxtEmail;
    EditText registerEmail_UtxtUsername;
    Button registerEmail_btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);

        registerEmail_UtxtEmail = findViewById(R.id.registerEmail_UtxtEmail);
        registerEmail_UtxtUsername = findViewById(R.id.registerEmail_UtxtUsername);
        registerEmail_btnNext  = findViewById(R.id.registerEmail_btnNext);
    }

    public void toRegisterPassword(View view){
        if(!registerEmail_UtxtEmail.getText().toString().isEmpty() &&
                !registerEmail_UtxtUsername.getText().toString().isEmpty()) {
            Intent registerPassword = new Intent(RegisterEmailActivity.this, RegisterPasswordActivity.class);
            registerPassword.putExtra("email", registerEmail_UtxtEmail.getText().toString());
            registerPassword.putExtra("username", registerEmail_UtxtUsername.getText().toString());
            startActivity(registerPassword);
            finish();
        }else{
            Toast.makeText(RegisterEmailActivity.this,"Please enter your email and username", Toast.LENGTH_LONG).show();
        }
    }
}
